package us.pdavidson.proxyobjects;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class AppConfig {


    SpecialTemplate lebron() {
        return new SpecialTemplate("Lebron James");
    }


    SpecialTemplate barry() {
        return new SpecialTemplate("Barry Melrose");
    }

    @Bean
    Exerciser exerciser() {
        return new Exerciser(specialTemplate(), templateSwitchingScope());
    }

    @Bean
    @Scope(value = "templateSwitching")
    public SpecialTemplate specialTemplate() {
        return new SpecialTemplate("Never used");
    }

    @Bean
    CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("templateSwitching", templateSwitchingScope());
        return customScopeConfigurer;
    }

    @Bean
    TemplateSwitchingScope templateSwitchingScope() {
        return new TemplateSwitchingScope(lebron(), barry());
    }


}
