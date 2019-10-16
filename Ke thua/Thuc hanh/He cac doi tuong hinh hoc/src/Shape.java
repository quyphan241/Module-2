public class Shape {
    String color;
    boolean filled;
    public Shape(){
        this.color = "green";
        this.filled = true;
    }
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return this.color;
    }
    public boolean getFilled(){
        return this.filled;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }
}

