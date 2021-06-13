## redis操作

### 安装

docker 下安装了redis

进入容器命令：docker exec -it redis /bin/bash

连接redis客户端：redis-cli



### Redis 字符串(String)

设置了一个key值   name  值是 lili

set name lili



把这个 name 设置了10s有效时间 expire name 10

或者

del name  删除



### Redis 哈希(Hash)

 添加一个hash   rediskey是hkey  hash结构为 name:lili,age:18

hmset hkey name lili age 18



查看所有的字段

hkeys hkey





### Redis 事务

开启事务

multi

添加了事务 并且设置了几个值，其中一处报错导致最终无法提交。

但是事务已经取消了，所以再次取消的时候会报错。。。

```
127.0.0.1:6379> MULTI
OK
127.0.0.1:6379(TX)> set user aaa
QUEUED
127.0.0.1:6379(TX)> set user bbb
QUEUED
127.0.0.1:6379(TX)> get user aaa
(error) ERR wrong number of arguments for 'get' command
127.0.0.1:6379(TX)> get user
QUEUED
127.0.0.1:6379(TX)> lpush temp qq
QUEUED
127.0.0.1:6379(TX)> lpush temp ww
QUEUED
127.0.0.1:6379(TX)> lpush temp ee
QUEUED
127.0.0.1:6379(TX)> exec
(error) EXECABORT Transaction discarded because of previous errors.
127.0.0.1:6379> discard
(error) ERR DISCARD without MULTI
```



重新提交一次

```
127.0.0.1:6379> multi
OK
127.0.0.1:6379(TX)> set user aaa
QUEUED
127.0.0.1:6379(TX)> set user bbb
QUEUED
127.0.0.1:6379(TX)> get user
QUEUED
127.0.0.1:6379(TX)> lpush temp qq
QUEUED
127.0.0.1:6379(TX)> lpush temp ww
QUEUED
127.0.0.1:6379(TX)> exec
1) OK
2) OK
3) "bbb"
4) (integer) 1
5) (integer) 2
127.0.0.1:6379> 
```



基本的五种类型只展示了两种的简单操作。

其他的还有一些发布订阅，GEO、HyperLogLog等未实现。。。