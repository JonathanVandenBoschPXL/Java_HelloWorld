package be.pxl.prismaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class PrismaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrismaServiceApplication.class, args);
    }

    
}
