public class test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(3);
        list.setIndex(0, 1);
        list.setIndex(1, 2);
        list.setIndex(2, 3);
        System.out.println(list);
        System.out.println(list.remove(1));
    }
}