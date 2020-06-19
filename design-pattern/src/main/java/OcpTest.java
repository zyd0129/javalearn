public class OcpTest {
    public static void main(String[] args) {
        Shape square = () -> System.out.println("draw square");
        Shape circle = () -> System.out.println("draw circle");

        GraphicEdit graphicEdit = new GraphicEdit();
        graphicEdit.draw(square);
        graphicEdit.draw(circle);
        /**
         * 接口不变，可以提供多个实现
         * 针对接口编程，符合开闭原则
         */
    }
}

interface  Shape{
    void draw();
}
class GraphicEdit{
    void draw(Shape a){
        a.draw();
    }
}
