public class Retriever extends Dog {

    public Retriever(String name, License license) {
        super(name, license);
    }

    public Bird retrieve(Bird bird){
        return bird;
    }
}
