public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    int speed;
    boolean on;
    double radius;
    String color;
    public Fan(){
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public int getSpeed() {
        return speed;
    }
    public boolean getOn(){
        return on;
    }
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setOn(){
        this.on = true;
    }
    public void setOff(){
        this.on = false;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String toString() {
        if (this.on == true) {
            return "Fan is on " +"color is " + this.color + " speed is " +this.speed + " color is "+this.color;
        }
        else {
            return "Fan is off "+"color is " + this.color + " speed is " +this.speed + " color is "+this.color;
        }
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setColor("yellow");
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setOn();
        System.out.println(fan1);

        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        System.out.println(fan2);
    }
}
