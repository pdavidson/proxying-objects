package us.pdavidson.proxyobjects;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class AppConfig {

    @Bean
    SpecialTemplate lebron() {
        return new SpecialTemplate("Lebron James");
    }

    @Bean
    SpecialTemplate barry() {
        return new SpecialTemplate("Barry Melrose");
    }

    @Bean
    Exerciser exerciser() {
        return new Exerciser(lebron(), barry());
    }

    SpecialTemplate intercepted() {
        SpecialTemplate proxied = new SpecialTemplate("THIS IS NEVER USED");

        ProxyFactoryBean factory = new ProxyFactoryBean();
        factory.setProxyTargetClass(true);
        factory.setTarget(proxied);

        return factory.get`;
    }

}
