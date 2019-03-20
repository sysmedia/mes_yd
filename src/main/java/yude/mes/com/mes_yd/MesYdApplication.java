package yude.mes.com.mes_yd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(value = "yude.mes.com.mes_yd.*.dao")
@EnableCaching
@SpringBootApplication
public class MesYdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MesYdApplication.class, args);
    }
}
