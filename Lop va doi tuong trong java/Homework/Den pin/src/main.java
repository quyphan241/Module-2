public class main {
    public static void main(String[] args) {
        ElectricLamp lamp1 = new ElectricLamp("Lamp1");
        ElectricLamp lamp2 = new ElectricLamp("Lamp2");
        SwitchButton switchButton = new SwitchButton();
        switchButton.connectToLamp(lamp1);
        switchButton.connectToLamp(lamp2);
        switchButton.switchOn();
        System.out.println(switchButton);
        System.out.println(lamp1);
        System.out.println(lamp2);
    }
}
