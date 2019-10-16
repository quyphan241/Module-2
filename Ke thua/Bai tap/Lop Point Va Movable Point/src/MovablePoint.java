public class MovablePoint extends Point{
    float speedX, speedY;

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public float[] getSpeed() {
        float[] arr = {this.speedX,this.speedY};
        return arr;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void setSpeed(float speedX, float speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public MovablePoint() {
        this.speedX = 0;
        this.speedY = 0;
    }

    public MovablePoint(float x, float y, float speedX, float speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void move() {
        this.x += speedX;
        this.y += speedY;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y +") , speed=(" + this.speedX +"," +this.speedY + ")";
    }
}
