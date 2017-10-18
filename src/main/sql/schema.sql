-- noinspection SqlDialectInspectionForFile
--数据库初始化脚本


--创建表

CREATE  TABLE  seckill(
'seckill_id' bitint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
'name' VARCHAR(120) NOT NULL COMMENT '商品名称'，
'number' INT  NOT NULL comment '库存数量',
'start_time' TIMESTAMP  NOT NULL comment '秒杀开始时间',
'end_time' TIMESTAMP NOT NULL comment '秒杀结束时间',
'create_time' TIMESTAMP NOT NULL comment DEFAULT  CURRENT_TIMESTAMP '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time),
)DEFAULT CHARSET=UTF-8 COMMENT='秒杀库存表';


---初始化数据

insert INTO  seckill(name,number,start_time,end_time,create_time)
VALUES
('1000秒杀iphone6s',100,'2017-02-17 00:00:00','2017-02-19 00:00:00',CURRENT_TIMESTAMP );

insert INTO  seckill(name,number,start_time,end_time,create_time)
VALUES
('300秒杀iphone6s',100,'2017-02-16 00:00:00','2017-02-17 00:00:00',CURRENT_TIMESTAMP );

insert INTO  seckill(name,number,start_time,end_time,create_time)
VALUES
('500秒杀iphone6s',100,'2017-02-15 00:00:00','2017-02-20 00:00:00',CURRENT_TIMESTAMP );


--秒杀成功明细表
--用户登录认证相关的信息
create TABLE success_killed(
'seckill_id' bitint NOT NULL comment '秒杀商品id',
'user_phone' bitint not NULL comment '用户手机号',
'state' tinyint NOT NULL DEFAULT -1 comment '状态显示：-1:无效 0:成功 1：已付款',
'create_time' TIMESTAMP NOT NULL comment '创建时间',
PRIMARY KEY (seckill_id,user_phone),
KEY idx_create_time(create_time)
)DEFAULT charset=utf-8 comment='秒杀成功明细表';

