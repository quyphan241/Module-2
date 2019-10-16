import java.util.Scanner;

public class QuadraticEquation {
    double a,b,c;
    public QuadraticEquation(double a,double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
    public double getDiscriminant(){
        return b*b-4*a*c;
    }
    public double getRoot1(){
        return (-b-Math.pow(this.getDiscriminant(),0.5))/(2*a);
    }
    public double getRoot2() {
        return (-b + Math.pow(this.getDiscriminant(), 0.5)) / (2 * a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a:");
        double a = scanner.nextDouble();
        System.out.println("Enter b:");
        double b =scanner.nextDouble();
        System.out.println("Enter c");
        double c =scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        double delta = quadraticEquation.getDiscriminant();
        if (delta>0){
            System.out.println("The equation has two roots "+ quadraticEquation.getRoot1()
                                                    + " and "+ quadraticEquation.getRoot2());
        }
        else if (delta==0){
            System.out.println("The equation has two roots "+ quadraticEquation.getRoot1());
        }
        else {
            System.out.println("The equation has no real roots");
        }
    }
}

