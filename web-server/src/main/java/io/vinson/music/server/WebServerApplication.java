package io.vinson.music.server;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@ServletComponentScan
public class WebServerApplication {

    private static Logger log = org.slf4j.LoggerFactory.getLogger(WebServerApplication.class);

    /** 关闭http的arg */
    private static final String CLOSE_HTTP_ARG = "-closehttp";

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WebServerApplication.class);
        springApplication.run(args);
        log.info("===============WebServerApplication start success.===================");
    }
}
