package us.pdavidson.proxyobjects;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisHelper;
import org.springframework.objenesis.ObjenesisStd;

@Configuration
@EnableAutoConfiguration
public class AppConfig {

    @Bean
    Exerciser exerciser() {
        return new Exerciser(specialTemplate(), routingInvoker());
    }

    @Bean
    public SpecialTemplate specialTemplate() {

        RoutingInvokerHandler interceptor = routingInvoker();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SpecialTemplate.class);
        enhancer.setCallbackType(interceptor.getClass());

        final Class<?> proxyClass = enhancer.createClass();
        Enhancer.registerCallbacks(proxyClass, new Callback[]{interceptor});
        return (SpecialTemplate) ObjenesisHelper.newInstance(proxyClass);
    }

    @Bean
    public RoutingInvokerHandler routingInvoker() {
        return new RoutingInvokerHandler(bryan(), dustin());
    }

    private SpecialTemplate bryan() {
        return new SpecialTemplate("Bryan");
    }

    private SpecialTemplate dustin() {
        return new SpecialTemplate("Dustin");
    }
}
