package com.seck.dao;

import com.seck.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Tman on 2017/2/17.
 */
public interface SeckillDao {

    /**
     * 执行减库存的操作
     * @param seckillId
     * @param killedTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killedTime") Date killedTime);

    /**
     * 根据ID查询出秒杀的对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offet,@Param("limit") int limit);
}
