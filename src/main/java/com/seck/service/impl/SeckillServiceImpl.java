package com.seck.service.impl;

import com.seck.dao.SeckillDao;
import com.seck.dao.SuccessKilledDao;
import com.seck.dto.Exposer;
import com.seck.dto.SeckillExecution;
import com.seck.entity.Seckill;
import com.seck.entity.SuccessKilled;
import com.seck.enums.SeckillStatEnum;
import com.seck.exception.RepeatKillException;
import com.seck.exception.SeckillCloseException;
import com.seck.exception.SeckillException;
import com.seck.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Tman on 2017/2/22.
 */

@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger= LoggerFactory.getLogger(SeckillServiceImpl.class);
    private static String slat="das1231dasdasvdsdsa";

    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;
    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,10);
    }

    /**
     * 根据seckillId查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    /**
     * 输出秒杀接口地址，否者输出系统时间和秒杀时间。
     *
     * @param seckillId
     */
    public Exposer exportSeckillUrl(long seckillId) {

        Seckill seckill=seckillDao.queryById(seckillId);
        if(seckill==null){
            return new Exposer(false,seckillId);
        }
        Date startTime=seckill.getStartTime();
        Date endTime=seckill.getEndTime();
        Date nowTime=new Date();
        if(nowTime.getTime()<startTime.getTime()||nowTime.getTime()>endTime.getTime()){
            return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
        }
        //转换特定字符串过程，不可逆。
        String md5=getMD5(seckillId);
        return new Exposer(true,md5,seckillId);
    }


    private String getMD5(long seckillId){
        String base=seckillId+"/"+slat;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */

    @Transactional
    /**
     * 使用注解控制事务的优点
     * 1：开发团队达成一致约定，明确标注事务方法的编程风格。
     * 2：保证事务方法的执行时间尽可能短，不要穿插其他的网络操作。
     * 3：不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制。
     */
    public SeckillExecution excuteSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill date rewrite");
        }
        Date nowTime = new Date();
        try {
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                throw new SeckillCloseException("seckill is close");
            } else {
                int insertCount=successKilledDao.insertSuccessKilled(seckillId,userPhone);
                if (insertCount<=0){
                 throw new RepeatKillException("seckill repeated");
                }else {
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, nowTime.getTime());
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
                }
        }catch (RepeatKillException e2){
            throw e2;
        }catch (SeckillCloseException e1){
            throw e1;
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            //编译期异常转为运行期异常
            throw new SeckillException("seckill inner error:"+e.getMessage());
        }
    }
}
