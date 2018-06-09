[TOC]

# Spring Cloud 全家桶

## 1、Spring Cloud 简介

> Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。 
>
> Spring Cloud是一系列框架的有序集合。它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用Spring Boot的开发风格做到一键启动和部署。Spring Cloud并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过Spring Boot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。 

### 1.1 Spring Boot VS Spring Cloud

* Spring boot 是 Spring 的一套快速配置脚手架，可以基于spring boot 快速开发单个微服务，Spring Cloud是一个基于Spring Boot实现的云应用开发工具；

* Spring boot专注于快速、方便集成的单个个体，Spring Cloud是关注全局的服务治理框架；

* spring boot使用了默认大于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置，Spring Cloud很大的一部分是基于Spring boot来实现。

* Spring boot可以离开Spring Cloud独立使用开发项目，但是Spring Cloud离不开Spring boot，属于依赖的关系。

* spring -> spring boot > spring cloud 这样的关系。




### 1.2 Spring Cloud 子项目

![img](https://spring.io/img/homepage/diagram-distributed-systems.svg) 

* 服务发现 Srping Cloud Eureka
* 客户端负载均衡 Spring Cloud Ribbon
* 声明式服务调用 Spring Cloud Feign
* 熔断器、监控Hystrix
* 配置中心Spring Cloud Config
* 网关 Spring Cloud Zuul
* 消息总线 Spring Cloud Bus
* 消息驱动的微服务 Spring Cloud Stream
* 分布式服务跟踪 Spring Cloud Sleuth

## 2、Spring Cloud全家桶
** Spring Cloud 版本 **`Edgware.SR3`

**应用端口规划**

|模块|服务名|端口号|备注|
|:-:|-|-|-|-|
|服务发现|discovery|6001,6002|对应两个应用名discovery1,discovery2|
|配置中心|config-server|6101,6102||
|网关|gateway|6201,6202||



### 2.1 服务发现
>Spring Cloud支持得最好的是Eureka，其次是Consul，最次是Zookeeper


* pom.xml
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```
* application.properties
``` 
eureka.instance.hostname=discovery     # 指定该Eureka实例的主机名
eureka.client.registerWithEureka=false # 不向注册中心注册自己
eureka.client.fetchRegistry=false	   # 不检索服务
eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
```

* Application
``` 
@SpringBootApplication
@EnableEurekaServer  //使用Eureka做服务发现。
public class EurekaApplication {
...
}
```


#### 2.1.1 Spring Cloud Eureka
```
这是什么呢？
猜 猜 看
```


### 2.2 客户端负载均衡



### 2.3 熔断器、监控



### 2.4 配置中心



### 2.5 网关(API Gateway)
