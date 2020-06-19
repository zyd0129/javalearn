package factoryPattern;

public class TeslaFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Tesla();
    }
}
