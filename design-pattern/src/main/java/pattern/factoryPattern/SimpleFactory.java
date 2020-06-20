package pattern.factoryPattern;

public class SimpleFactory {
    public static Car createCar(String type) {
        Car car;
        if ("Porsche".equals(type)) {
            car = new Porsche();
        } else if ("Tesla".equals(type)) {
            car = new Tesla();
        }else {
            car = null;
        }
        return car;
    }
}
