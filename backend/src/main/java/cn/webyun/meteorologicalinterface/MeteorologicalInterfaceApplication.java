package cn.webyun.meteorologicalinterface;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.webyun.meteorologicalinterface")
public class MeteorologicalInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeteorologicalInterfaceApplication.class, args);
    }

}
