package org.linlinjava.litemall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 所有springBoot项目都要设置这个  "启动注解",用来标注这是系统的启动入口函数  (这是一个复合 注解)
// scanBasePackages 是SpringBootApplication注解的一个参数, 用来指定  "需要扫描的包"
// 默认情况下,它只会扫描本包下的类,如果你要使用的类在另一个 并行项目中, 它就不能在这里引用
@SpringBootApplication(scanBasePackages = {"org.linlinjava.litemall"})

// 指定要扫描的 mapper类
@MapperScan("org.linlinjava.litemall.db.dao")

//开启 事务支持, 这样在操作数据库的函数上 标记@Transactional 注解,这个函数就支持事务安全了
// 事务: 原子性, 一致性, 格里串行性, 持久性(必须落盘操作完成)
@EnableTransactionManagement

// EnableScheduling作用: 主要用来支持定时任务函数 的自动执行
//EnableScheduling作用: 用来使@Schedule注解功能可用的注解. 在spring boot的配置类中标注启动这个功能, 就可以对项目中的方法使用
// @Schedule注解, 将其变成定时之形函数, 只有这两种注解同时使用,才能发挥效果
@EnableScheduling
public class Application {  // 这是启动类

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}