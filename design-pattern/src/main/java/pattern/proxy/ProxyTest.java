package pattern.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        JDKProxy proxy = new JDKProxy(service);
        Service serviceProxy = (Service) proxy.getInstance();
        serviceProxy.work();
        CglibProxy proxy1 = new CglibProxy(service);
        Service cglibProxy = (Service) proxy1.getInstance();
        cglibProxy.work();

    }
}
