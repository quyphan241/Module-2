public class Cat extends License.Pet {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void speak(){
        System.out.println("Meow meow");
    }
}
