public class Point2D {
    float x,y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float[] getXY(){
        float[] arr = {this.x,this.y};
        return arr;
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Point2D(){
        this.x = 0;
        this.y = 0;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
