# 第七周作业

## 第一题



### 分析自己系统的 SQL 和表结构

mall_t_customer_info  客户信息表

![mall_t_customer_info](image\mall_t_customer_info.jpg)

mall_t_goods 商品信息表

![mall_t_goods](image\mall_t_goods.png)

mall_t_trade 订单信息表

![mall_t_trade](image\mall_t_trade.jpg)

mall_t_trade_detail 订单明细表

![mall_t_trade_detail](image\mall_t_trade_detail.png)



## 第二 ：按自己设计的表结构，插入 100 万订单模拟数据，测试不同方式的插入效率



/b使用sql语句方式批量插入

```SQL
DROP PROCEDURE IF EXISTS trade_init;
DELIMITER $
CREATE PROCEDURE trade_init () 
BEGIN
	DECLARE i INT DEFAULT 1;
	SET autocommit = 0;
	WHILE
			i <= 100000 DO
			INSERT INTO mall_t_trade (
				trade_no,
				trade_status,
				shop_type,
				shop_id,
				warehouse_id,
				logistic_id,
				goods_total,
				all_total,
				remark,
				coupon_total,
				trade_time,
				snd_time,
				pay_time,
				snd_to 
			)
		VALUES
			(
				CONCAT( 'DD', i ),
				CEILING( rand()* 4 ),
				'天狗商城',
				CEILING( rand()* 5+100 ),
				CEILING( rand()* 5+50 ),
				CEILING( rand()* 5+30 ),
				rand()* 1000+12,
				goods_total -(rand()* 10),
				'阿巴阿巴',
				goods_total - all_total,
				date_sub( now(), INTERVAL CEILING( rand()* 5+3 ) DAY ),
                date_sub( now(), INTERVAL CEILING( rand()* 3 ) DAY ),
				date_add( trade_time, INTERVAL CEILING( rand()* 3 ) MINUTE ),
				'***' 
			);
		SET i = i + 1;
	END WHILE;
	COMMIT;
END $ CALL trade_init ();
```



**由于是假数据：部分数据随机生成或写死了**

trade_no  --->订单号：前缀DD加自增id拼接
trade_status  --->订单状态：随机1-4类型，代表
shop_type  --->店铺类型：写死了
shop_id  --->店铺id 随机100-105
warehouse_id  --->仓库id 随机50-55
logistic_id  --->物流公司id 随机30-35
goods_total  ---> 商品金额：随机12-1012 非整数
all_total  ---> 实际收款：商品金额减了一个随机0-10元的优惠卷
remark  ---> 备注信息 ：写死
coupon_total  --->优惠金额 
trade_time  ---> 创建订单时间：用当前时间随机前3-8天的日期
snd_time  ---> 发货时间：用下单时间随机加了1-3天的天数
pay_time  --->付款时间：用下单时间随机加了1-3分钟
snd_to  --->收件人：写死了



![sql执行](image\sql执行.png)



可以看到插入一百万的数据花了173秒 大约3分钟。

如果是一条一条插入预计时间。。。。。。。。。。。。

**网上有通过memory的引擎快速创建的方式，试着弄没有成功、、**



