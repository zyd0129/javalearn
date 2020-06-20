package pattern.factoryPattern;

public class Tesla implements Car {
    @Override
    public String getName() {
        System.out.println("tesla");
        return "Tesla";
    }
}
