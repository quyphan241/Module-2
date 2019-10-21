public class License {
     public License() {
    }

    public static class Dog extends Pet implements ILicensable {
        private License license;

        public Dog(String name, License license) {
            super(name);
            this.license = license;
        }

        @Override
        public void speak(){
            System.out.println("go go");
        }

        @Override
        public License getLicense() {
            return this.license;
        }
    }

    public static class Pet {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Pet(String name) {
            this.name = name;
        }

        public void speak() {
        }
    }
}
