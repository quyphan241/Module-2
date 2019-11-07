public class Cylinder extends Circle{
    double height;

    public Cylinder(double radius, String color, double height, String name) {
        super(radius, color,name );
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }
//    @Override
//    public double getAre(){
//        return this.radius*Math.PI*this.radius + this.radius*2*Math.PI*this.height;
//    }

    public double getVolume(){
        return this.getArea()*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                ", Volume:" + this.getVolume()+
                ", Area: " + this.getArea()+'}' ;
    }
    @Override
    public double getArea(){
        return this.radius*Math.PI*this.radius + this.radius*2*Math.PI*this.height;
    }
}
