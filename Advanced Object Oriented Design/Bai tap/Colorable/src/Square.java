public class Square extends Rectangle implements Resizeable, Colorable {
    private double side;
    public Square(double side) {
        this.side =side;
    }
    @Override
    public double getArea(){
        return this.side*this.side;
    }
    @Override
    public double getPerimeter(){
        return this.side*4;
    }
    @Override
    public void resize(double percent) {
        this.side += this.side*percent/100;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides. ");
    }
}
