public class ElectricLamp {
    private boolean status;
    private String name;
    public ElectricLamp(String name) {
        this.status = false;
        this.name = name;
    }

    public void turnOff() {
        this.status = false;
    }

    public void turnOn() {
        this.status = true;
    }

    public String toString() {
        if (this.status) {
            return this.name + " is on" ;
        }
        else return this.name + " is off";
    }
}

