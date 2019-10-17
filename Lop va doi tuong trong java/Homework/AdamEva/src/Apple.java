public class Apple {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public Apple() {
        this.amount = 10;
    }

    public void decrease() {
        if(!isEmpty()){
        this.amount -=1;
        }
    }

    public boolean isEmpty() {
        if (this.amount == 0){
            return true;
        }
        else return false;
    }

    public String toString() {
        return "Apple{" +
                "weight=" + amount +
                '}';
    }
}
