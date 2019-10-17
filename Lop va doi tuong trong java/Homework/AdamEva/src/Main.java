public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple);
        Human adam = new Human("male", "Adam", 65);
        Human eva = new Human("female","Eva",50);
        adam.say("Hello");
        eva.say("Hi");
        adam.eat(apple);
        eva.eat(apple);
        System.out.println(apple);
        System.out.println(adam);
        System.out.println(eva);
    }
}
