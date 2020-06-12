package org.linlinjava.litemall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//基本上任何的任何新创建的springboot的启动文件都是这个样子

/* 所有springBoot项目都要设置这个  "启动注解",用来标注这是系统的启动入口函数  (这是一个复合 注解)
@Configuration  # # 这就是 Spring IoC 容器的配置类
@EnableAutoConfiguration  # 借助 @Import 的帮助，
将所有符合自动配置条件的 bean(各种名字为 @Enable 开头的 Annotation ) 定义加载到 IoC 容器
@ComponentScan
你也可以每次写这三个注解,但是比较麻烦,所以引入了这个复合注解
*/
// scanBasePackages 是SpringBootApplication注解的一个参数, 用来指定  "需要扫描的包"
// 默认情况下,它只会扫描本包下的类,如果你要使用的类在另一个 并行项目中, 它就不能在这里引用
@SpringBootApplication(scanBasePackages = {"org.linlinjava.litemall"})

// 指定要扫描的 mapper类
@MapperScan("org.linlinjava.litemall.db.dao")

//开启 事务支持, 这样在操作数据库的函数上 标记@Transactional 注解,这个函数就支持事务安全了
// 事务: 原子性, 一致性, 格里串行性, 持久性(必须落盘操作完成)
@EnableTransactionManagement

// EnableScheduling作用: 主要用来支持定时任务函数 的自动执行.
// 通过 @Import 将 Spring 调度框架相关的 bean 定义都加载到 IoC 容器
//EnableScheduling作用: 用来使@Schedule注解功能可用的注解. 在spring boot的配置类中标注启动这个功能, 就可以对项目中的方法使用
// @Schedule注解, 将其变成定时之形函数, 只有这两种注解同时使用,才能发挥效果
@EnableScheduling
public class Application {  // 这是启动类

    // 这个main函数 就是执行的第一个函数
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}