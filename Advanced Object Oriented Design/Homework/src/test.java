public class test {
    public static void main(String[] args) {
        Cat meo = new Cat("mun");
        meo.speak();
        License license1 = new License();
        Retriever choSan = new Retriever("Rex",license1);
        choSan.speak();
    }
}
