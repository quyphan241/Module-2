public class Apple {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public Apple() {
        this.weight = 10;
    }

    public void decrease() {
        if(isEmpty()){
            System.out.println("The apple is empty");
        }
        else{
        this.weight -=1;
        }
    }

    public boolean isEmpty() {
        if (this.weight == 0){
            return true;
        }
        else return false;
    }

    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
