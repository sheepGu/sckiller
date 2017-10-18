package com.seck.dao;

import com.seck.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Tman on 2017/2/17.
 */
public interface SuccessKilledDao {
    /**
     * 插入购买的明细，过滤重复
     * @param seckill_id
     * @param user_phone
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") long seckill_id,@Param("userPhone") long user_phone);

    /**
     * 根据Id查询SuccessKilled并携带seckill对象
     * @param seckill_id
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckill_id,@Param("userPhone") long user_phone);

    /**
     * 查询的结果集
     * @param offet
     * @param limit
     * @return
     */
    List<SuccessKilled> queryAllSuccessKill(@Param("offet") int offet,@Param("limit") int limit);
}
