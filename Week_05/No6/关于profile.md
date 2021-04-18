# 6.（选做）maven/spring 的 profile 机制，都有什么用法？

主要用于在不同环境场景的切换，比如开发，测试，仿生，生产等。

当然现在还流行使用***Nacos***来统一管理这些配置。

## maven 定义 profile 的写法 

```
<profiles>
        <!--开发环境-->
        <profile>
            <id>dev</id>
            <properties>
                 <!-- package.environment 为自己定义的名字-->
                <package.environment>dev</package.environment>
            </properties>
            <!-- 默认激活该profile节点-->
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
        </profile>
        <!--测试环境-->
        <profile>
            <id>pre</id>
            <properties>
                <package.environment>pre</package.environment>
            </properties>
        </profile>
        <profile>
            <!-- 生产环境 -->
            <id>pro</id>
            <properties>
                <package.environment>prod</package.environment>
            </properties>
        </profile>
    </profiles>
```

使用 -p 参数来激活一个profile

```
mvn package –P 
```

如果需要临时切换 profile 可以在 jar 后面 更上 --spring.profiles.active=dev



## Spring profile 的用法



&ensp;&ensp;&ensp;&ensp;一般写各自的配置文件，比如dev.properties,test.properties等等，一般放到自建的 config目录下，或者resource目录也行



&ensp;&ensp;&ensp;&ensp;在全局的application.properties里指定，如下：

```java
#properties格式
spring.profiles.active=dev
```

&ensp;&ensp;&ensp;&ensp;或者application.yml格式的配置，如下：

```java
spring:
  profiles:
    active: dev
```



配置文件名称格式如下：

application.yml

application-dev.yml







