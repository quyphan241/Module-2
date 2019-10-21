public class Pet implements ISpeaking {
    private String name;

    public String getName() {
        return name;
    }

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public void speak() {
    }
}
