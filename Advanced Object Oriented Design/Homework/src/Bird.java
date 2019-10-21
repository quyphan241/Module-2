public class Bird implements ISpeaking {
    private String name;
    public Bird(String name) {
        this.name = name;
    }

    @Override
    public void speak(){
        System.out.println("chim hót");
    }
}
