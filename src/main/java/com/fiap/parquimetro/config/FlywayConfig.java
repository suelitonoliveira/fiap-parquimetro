package com.fiap.parquimetro.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.flyway.clean}")
    private Boolean fywayClean = false;

    @Value("${spring.flyway.schemas}")
    private String schemas;

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(url, user, password)
                .schemas(schemas)
                .cleanDisabled(false)
                .load();

        if (fywayClean) {
            flyway.clean();
        }
        flyway.migrate();
        return flyway;
    }
}
