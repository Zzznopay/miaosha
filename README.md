## 优化秒杀系统方案Demo

### 数据库设计

> **miaosha**

| goods | miaosha_goods | miaosha_order | miaosha_user | order_info |
| :---: | :-----------: | :-----------: | :----------: | :--------: |
| 商品  |   秒杀商品    |   秒杀订单    |     用户     |  订单信息  |

### 技术点介绍

| 前端：                       | 后端：                      | 中间件：               |
| ---------------------------- | --------------------------- | ---------------------- |
| Thymeleaf、Bootstrap、JQuery | SpringBoot、JSR303、MyBatis | RabbitMQ、Redis、Druid |

### 代码目录

miaosha
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── zzz
│   │   │           └── miaosha
│   │   │               ├── access
│   │   │               │   ├── AccessInterceptor.java
│   │   │               │   ├── AccessLimit.java
│   │   │               │   └── UserContext.java
│   │   │               ├── config
│   │   │               │   ├── UserArgumentResolver.java
│   │   │               │   └── WebConfig.java
│   │   │               ├── controller
│   │   │               │   ├── GoodsController.java
│   │   │               │   ├── LoginController.java
│   │   │               │   ├── MiaoshaController.java
│   │   │               │   └── OrderController.java
│   │   │               ├── dao
│   │   │               │   ├── GoodsDao.java
│   │   │               │   ├── MiaoshaUserDao.java
│   │   │               │   └── OrderDao.java
│   │   │               ├── domain
│   │   │               │   ├── Goods.java
│   │   │               │   ├── MiaoshaGoods.java
│   │   │               │   ├── MiaoshaOrder.java
│   │   │               │   ├── MiaoshaUser.java
│   │   │               │   └── OrderInfo.java
│   │   │               ├── exception
│   │   │               │   ├── GlobalException.java
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               ├── rabbitmq
│   │   │               │   ├── MiaoshaMessage.java
│   │   │               │   ├── MQConfig.java
│   │   │               │   ├── MQReceiver.java
│   │   │               │   └── MQSender.java
│   │   │               ├── redis
│   │   │               │   ├── AccessKey.java
│   │   │               │   ├── BasePrefix.java
│   │   │               │   ├── GoodsKey.java
│   │   │               │   ├── KeyPrefix.java
│   │   │               │   ├── MiaoshaKey.java
│   │   │               │   ├── MiaoshaUserKey.java
│   │   │               │   ├── OrderKey.java
│   │   │               │   ├── RedisConfig.java
│   │   │               │   ├── RedisPoolFactory.java
│   │   │               │   └── RedisService.java
│   │   │               ├── result
│   │   │               │   ├── CodeMsg.java
│   │   │               │   └── Result.java
│   │   │               ├── service
│   │   │               │   ├── GoodsService.java
│   │   │               │   ├── MiaoshaService.java
│   │   │               │   ├── MiaoshaUserService.java
│   │   │               │   └── OrderService.java
│   │   │               ├── utils
│   │   │               │   ├── DBUtil.java
│   │   │               │   ├── MD5Util.java
│   │   │               │   ├── UserUtil.java
│   │   │               │   ├── UUIDUtil.java
│   │   │               │   └── ValidatorUtil.java
│   │   │               ├── validator
│   │   │               │   ├── IsMobile.java
│   │   │               │   └── IsMobileValidator.java
│   │   │               └── vo
│   │   │               │   ├── GoodsDetailVo.java
│   │   │               │   ├── GoodsVo.java
│   │   │               │   ├── LoginVo.java
│   │   │               │   └── OrderDetailVo.java
│   │   │               ├── MiaoshaApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── sql
│   │       ├── static
│   │       └── templates

└── miaosha.md

### demo内容

- SpringBoot框架 + Thymeleaf模板开发环境
- 数据层使用MyBatis框架 + Druid数据连接池
- 使用Result来封装结果
- redis通用缓存Key封装
- 明文密码使用两次MD5处理
- JSR303参数校验 + 全局异常处理器
- 分布式Session

### 压力测试

JMeter工具

> 下载链接：https://jmeter.apache.org/

JMeter是Apache组织开发的开源项目，设计之初是用于做性能测试的，同时它在实现对各种借口的调用方面做的比较成熟，因此常被用于接口功能测试和性能测试。

能更好的支持各种常见接口，如HTTP（S）、WebService、JDBC、JAVA、FTP等，并以多种形式展现测试结果

使用JMeter对秒杀接口进行压力测试

### 优化方面

1. **页面优化**

   ```
   页面缓存 + Url缓存 + 对象缓存
   页面静态化，前后端分离
   静态资源优化
   CDN优化
   ```

2. **接口优化**

   ```
   Redis预减库存减少数据库访问
   内存标记减少Redis访问
   RabbitMQ队列缓存，异步下单，增强用户体验
   ```

3. **安全优化**

   ```
   秒杀接口地址隐藏
   数学公式验证码
   接口防刷
   ```

