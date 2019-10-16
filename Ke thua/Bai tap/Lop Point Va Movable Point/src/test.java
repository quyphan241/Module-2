public class test {
    public static void main(String[] args) {
        //test Point
        Point point = new Point();
        System.out.println(point);

        //test Movable Point
        MovablePoint movablePoint = new MovablePoint(5,5,10,10);
        System.out.println(movablePoint);
        movablePoint.move();
        System.out.println(movablePoint);
    }
}
