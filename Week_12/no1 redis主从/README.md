使用了dockers搭建

因为比较复杂所以使用了dockers-compose进行搭建



redis文件夹是关于redis service的config 

sentinel文件夹是哨兵机制的配置



1.把配置文件放到服务器 

2.进入对应文件夹内 输入命令：

（先进入redis服务的，再在sentinel的里面运行一下）

```
docker-compose up
```



这样一个简单的redis服务就搭建成功了。







进入容器看主节点。OK

```
[root@iZuf6faickzmmuij9s83lcZ ~]# docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED          STATUS          PORTS     NAMES
d5330eab5594   redis     "docker-entrypoint.s…"   4 minutes ago    Up 4 minutes              sentinel-1
b82038c1fe7e   redis     "docker-entrypoint.s…"   4 minutes ago    Up 4 minutes              sentinel-2
2e7e1288e0df   redis     "docker-entrypoint.s…"   26 minutes ago   Up 22 minutes             redis-server-slave-1
06b7fec2a330   redis     "docker-entrypoint.s…"   26 minutes ago   Up 22 minutes             redis-server-master
[root@iZuf6faickzmmuij9s83lcZ ~]# docker exec -it 06b7fec2a330 /bin/bash
root@iZuf6faickzmmuij9s83lcZ:/data# ls
dump.rdb
root@iZuf6faickzmmuij9s83lcZ:/data# redis-cli
127.0.0.1:6379> info replication
NOAUTH Authentication required.
127.0.0.1:6379> auth ********
OK
127.0.0.1:6379> info replication
# Replication
role:master
connected_slaves:1
slave0:ip=127.0.0.1,port=6380,state=online,offset=47261,lag=1
master_failover_state:no-failover
master_replid:d8af1519b2ba71bbd8fabf1366b9e2571794d26a
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:47261
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:47261
127.0.0.1:6379> 

```



查看从库

```
127.0.0.1:6379> info replication
# Replication
role:master
connected_slaves:1
slave0:ip=127.0.0.1,port=6380,state=online,offset=83150,lag=1
master_failover_state:no-failover
master_replid:d8af1519b2ba71bbd8fabf1366b9e2571794d26a
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:83283
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:83283
```



**PS：不知道为什么这里进入salve的容器，info显示的也是maser 但是使用可视化工具连接6380的时候就无法设置key等，它就是只读的。**





此时测试哨兵机制

```
[root@iZuf6faickzmmuij9s83lcZ ~]# docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED          STATUS          PORTS     NAMES
d5330eab5594   redis     "docker-entrypoint.s…"   20 minutes ago   Up 20 minutes             sentinel-1
b82038c1fe7e   redis     "docker-entrypoint.s…"   20 minutes ago   Up 20 minutes             sentinel-2
2e7e1288e0df   redis     "docker-entrypoint.s…"   42 minutes ago   Up 38 minutes             redis-server-slave-1
06b7fec2a330   redis     "docker-entrypoint.s…"   42 minutes ago   Up 38 minutes             redis-server-master
[root@iZuf6faickzmmuij9s83lcZ ~]# docker stop 06b7fec2a330
06b7fec2a330
[root@iZuf6faickzmmuij9s83lcZ ~]# docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED          STATUS          PORTS     NAMES
d5330eab5594   redis     "docker-entrypoint.s…"   21 minutes ago   Up 21 minutes             sentinel-1
b82038c1fe7e   redis     "docker-entrypoint.s…"   21 minutes ago   Up 21 minutes             sentinel-2
2e7e1288e0df   redis     "docker-entrypoint.s…"   43 minutes ago   Up 38 minutes             redis-server-slave-1
[root@iZuf6faickzmmuij9s83lcZ ~]# docker-compose up

```



可以看到master的服务被停掉了，此时我们再去连接salve进行添加数据就可以添加了，而maser就已经无法连接了。





当再启动masrt

```
docker restart 06b7fec2a330
```





这个时候可以看到原本的salve已经比原本的maser多了一个 xxx的key，而原本的maser它此时变成了只读状态。



![sentinel机制](sentinel\sentinel机制.PNG)









