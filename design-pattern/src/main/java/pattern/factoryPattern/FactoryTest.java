package pattern.factoryPattern;

public class FactoryTest {

    public static void main(String[] args) {
        CarFactory carFactory = new TeslaFactory();
        SaleStore saleStore = new SaleStore();
        saleStore.setFactoryMethod(carFactory);
        saleStore.orderCar("tesla");
    }

    public static class SaleStore {
        public CarFactory carFactory;

        public void setFactoryMethod(CarFactory carFactory) {
            this.carFactory = carFactory;
        }

        public void orderCar(String type) {
            Car car = carFactory.createCar();
            // 其他操作
            System.out.println(car.getName());
        }
    }
}
