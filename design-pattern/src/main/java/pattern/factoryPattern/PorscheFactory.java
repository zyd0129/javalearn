package pattern.factoryPattern;

public class PorscheFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Porsche();
    }
}
