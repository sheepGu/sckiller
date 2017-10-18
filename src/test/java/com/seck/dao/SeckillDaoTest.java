package com.seck.dao;

import com.seck.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tman on 2017/2/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {


    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        long seckillId=1000;


        seckillDao.reduceNumber(seckillId,new Date());
    }

    @Test
    public void queryById() throws Exception {
        long seckillId=1000;
        Seckill seckill=seckillDao.queryById(seckillId);
        System.out.println(seckill.toString());

    }

    @Test
    public void queryAll() throws Exception {
        int ofset=0;
        int limit =10;
        List<Seckill> seckillList=seckillDao.queryAll(ofset,limit);
        for (Seckill seckill:seckillList){

            System.out.println(seckill.toString());

        }
    }

}