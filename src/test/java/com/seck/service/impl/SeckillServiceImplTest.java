package com.seck.service.impl;

import com.seck.dto.Exposer;
import com.seck.dto.SeckillExecution;
import com.seck.entity.Seckill;
import com.seck.exception.RepeatKillException;
import com.seck.exception.SeckillCloseException;
import com.seck.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tman on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {

    private final Logger logger= LoggerFactory.getLogger(SeckillServiceImplTest.class);

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list=seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
            Seckill seckill=seckillService.getById(1001);
        logger.info(seckill.toString());
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id=1000;
        Exposer exposer=seckillService.exportSeckillUrl(id);
        logger.info("exposer"+exposer.toString());
    }

    @Test
    public void excuteSeckill() throws Exception {
        long id=1000;
        long phone=13738073631L;
        String md5="a372bd153e696360a4e0a79e14e72650";

        try {
            SeckillExecution seckillExecution= seckillService.excuteSeckill(id,phone,md5);
            logger.info("返回的excution={}"+seckillExecution);
        }catch (RepeatKillException e1){
            logger.error(e1.getMessage(),e1);
        }catch (SeckillCloseException e2){
            logger.error(e2.getMessage());
        }

    }

}