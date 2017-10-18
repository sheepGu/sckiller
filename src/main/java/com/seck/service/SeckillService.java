package com.seck.service;

import com.seck.dto.Exposer;
import com.seck.dto.SeckillExecution;
import com.seck.entity.Seckill;
import com.seck.exception.RepeatKillException;
import com.seck.exception.SeckillCloseException;
import com.seck.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：
 * Created by Tman on 2017/2/22.
 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 根据seckillId查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 输出秒杀接口地址，否者输出系统时间和秒杀时间。
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution excuteSeckill(long seckillId, long userPhone, String md5)
    throws SeckillException,RepeatKillException,SeckillCloseException;




}
