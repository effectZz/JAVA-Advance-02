**1.（必做）**搭建一个 3 节点 Kafka 集群，测试功能和性能；实现 spring kafka 下对 kafka 集群的操作，将代码提交到 github。

**2.（选做）**安装 kafka-manager 工具，监控 kafka 集群状态。



使用docker-compose安装， 配置文件在Kafka目录下

搭建了3个Kafka ，1个zookeeper，一个kafka-manager。



在配置文件夹下输入

```
docker-compose -f docker-compose.yaml up -d
```



docker ps -a查看运行状态

```
[root@iZuf6faickzmmuij9s83lcZ kafka]# docker ps
CONTAINER ID   IMAGE                              COMMAND                  CREATED          STATUS          PORTS                                                                                                                           NAMES
54f4eb0ec28e   sheepkiller/kafka-manager:latest   "./start-kafka-manag…"   13 minutes ago   Up 13 minutes   0.0.0.0:9000->9000/tcp, :::9000->9000/tcp                                                                                       kafka-manager
2e2b415dd0ff   wurstmeister/kafka                 "start-kafka.sh"         13 minutes ago   Up 13 minutes   0.0.0.0:9093->9093/tcp, :::9093->9093/tcp                                                                                       kafka2
ec06d6bd98db   wurstmeister/kafka                 "start-kafka.sh"         13 minutes ago   Up 13 minutes   0.0.0.0:9092->9092/tcp, :::9092->9092/tcp                                                                                       kafka1
e5070c74197a   wurstmeister/kafka                 "start-kafka.sh"         13 minutes ago   Up 13 minutes   0.0.0.0:9094->9094/tcp, :::9094->9094/tcp                                                                                       kafka3
bdeb379ab423   wurstmeister/zookeeper             "/bin/sh -c '/usr/sb…"   13 minutes ago   Up 13 minutes   22/tcp, 2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp, :::2181->2181/tcp                                                           zookeeper
```





代码操作：kafka-demo文件夹



导入pom

```
<dependency>
   <groupId>org.springframework.kafka</groupId>
   <artifactId>spring-kafka</artifactId>
   <version>2.7.3</version>
</dependency>
```



配置application.properties



demo文件

生产者：com\example\demo\KafkaProducer

消费者：com\example\demo\KafkaConsumer

测试Demo：com\example\demo\KafkaDemo



测试类：src\test\java\com\example\demo\KafkaDemoTest



测试消息 发送了10次 "hello world"



打印到控制台数据：

```
简单消费：TestTopic-0-hello world
简单消费：TestTopic-0-hello world
简单消费：TestTopic-0-hello world
简单消费：TestTopic-0-hello world
简单消费：TestTopic-0-hello world
简单消费：TestTopic-0-hello world
简单消费：TestTopic-0-hello world
简单消费：TestTopic-0-hello world
简单消费：TestTopic-0-hello world
简单消费：TestTopic-0-hello world
```







kafka-manager

 ![kafka-manager](kafka\kafka-manager.png)

Topic

![Topic](kafka\Topic.png)