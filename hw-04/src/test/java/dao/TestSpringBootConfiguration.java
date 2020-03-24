package dao;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.configs.YamlProps;

@ComponentScan({"ru.otus.dao","ru.otus.service","ru.otus.configs"})

@EnableConfigurationProperties(YamlProps.class)
@SpringBootConfiguration
public class TestSpringBootConfiguration {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("i18n/messages");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
