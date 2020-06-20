package pattern.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class JDKProxy {
    Object service;

    public JDKProxy(Service service) {
        this.service = service;
    }

    public Object getInstance() {
        return Proxy.newProxyInstance(Service.class.getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.info("before proxy");
                method.invoke(service, args);
                log.info("after proxy");
                return null;
            }
        });
    }
}
