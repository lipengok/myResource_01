package com.lp.spring_jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
// 可选，指定扫描的表映射实体Entity的目录，如果不指定，会扫描全部目录
@EntityScan("com.lp.spring_jpa..entity")
// 可选，指定扫描的表repository目录，如果不指定，会扫描全部目录
@EnableJpaRepositories(basePackages = {"com.lp.spring_jpa.jpa.repository"})
// 可选，开启JPA auditing能力，可以自动赋值一些字段，比如创建时间、最后一次修改时间等等
@EnableJpaAuditing
public class SpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
        log.info("项目初始化完成");
    }

}
