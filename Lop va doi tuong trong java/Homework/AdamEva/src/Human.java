public class Human {
    private String gender,name;
    private int weight;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Human(String gender, String name, int weight) {
        this.gender = gender;
        this.name = name;
        this.weight = weight;
    }

    public void eat(Apple apple) {
        if (!apple.isEmpty()){
            apple.decrease();
            this.weight++;
        }
        else System.out.println("The apple is empty");
    }

    public void say(String str) {
        System.out.println(this.name + ": "+str);
    }

    public String toString() {
        return this.name + "{" +
                "gender='" + gender + '\'' +
                ", weight=" + weight +
                '}';
    }
}
