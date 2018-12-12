package com.zxq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Description:
 * <p>
 *     启动类
 * </p>
 * @author Zeng XiaoQi
 * @Date 2018/12/9 15:34
 */
@SpringBootApplication
@MapperScan("com.zxq.dao")
public class CarClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarClubApplication.class, args);
    }
}
