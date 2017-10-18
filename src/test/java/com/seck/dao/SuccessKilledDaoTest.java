package com.seck.dao;

import com.seck.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tman on 2017/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() throws Exception {
        long seckillId=1000;
        long phone=18767156246l;
        successKilledDao.insertSuccessKilled(seckillId,phone);

    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long seckillId=1000;
        long userphone=18767156246l;
        SuccessKilled successKilled= successKilledDao.queryByIdWithSeckill(seckillId,userphone);
        System.out.println(successKilled.toString());
        System.out.println(successKilled.getSeckill().toString());
    }

    @Test
    public void queryll() throws Exception {
            int ofset=0;
            int limit=10;
        List<SuccessKilled> successKilleds =successKilledDao.queryAllSuccessKill(ofset,limit);
        for (SuccessKilled successKilled:successKilleds){
            System.out.println(successKilled.toString());
        }
    }

}