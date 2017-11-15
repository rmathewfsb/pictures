package edu.codeanywhere.j4.pictures.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@Configuration
@Profile("local")
public class LocalDataSourceConfig
{
    @Bean
    public EnvDataSource getEnvDatasource()
    {
        return new EnvDataSource("local");
    }
}

