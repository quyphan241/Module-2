public class Dog extends Pet implements ILicensable {
    License license;
    public Dog(String name,License license) {
        super(name);
        this.license = license;
    }

    @Override
    public License getLicense() {
        return null;
    }

    @Override
    public void speak() {
        System.out.println("Go go");
    }
}
