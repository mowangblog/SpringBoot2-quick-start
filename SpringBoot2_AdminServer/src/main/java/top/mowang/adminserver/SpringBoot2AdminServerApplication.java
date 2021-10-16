package top.mowang.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class SpringBoot2AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2AdminServerApplication.class, args);
    }

}
