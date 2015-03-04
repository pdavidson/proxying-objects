package us.pdavidson.proxyobjects;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

public class RoutingInvokerHandler implements MethodInterceptor {
    static final Random random = new Random();
    private final SpecialTemplate[] templates;
    private SpecialTemplate leader;

    public RoutingInvokerHandler(SpecialTemplate ... templates){
        this.templates = templates;
        electNewLeader();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invoke(leader, objects);
    }

    public void electNewLeader() {
        int index = Math.abs(random.nextInt()) % templates.length;
        leader = templates[index];
    }
}
