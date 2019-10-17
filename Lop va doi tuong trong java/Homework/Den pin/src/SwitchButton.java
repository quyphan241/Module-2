public class SwitchButton {
    private ElectricLamp lamp;
    private boolean status;

    public SwitchButton(ElectricLamp lamp, boolean status) {
        this.lamp = lamp;
        this.status = status;
    }

    public SwitchButton() {
        this.status = false;
    }

    public void connectToLamp(ElectricLamp electricLamp) {
        this.lamp = electricLamp;
    }

    public void switchOn() {
        this.status = true;
        this.lamp.turnOn();
    }

    public void witchOff() {
        this.status = false;
        this.lamp.turnOn();
    }

    public String toString() {
        if (this.status)
            return "Switch button is on" ;
        else return "Switch button is off";
    }
}