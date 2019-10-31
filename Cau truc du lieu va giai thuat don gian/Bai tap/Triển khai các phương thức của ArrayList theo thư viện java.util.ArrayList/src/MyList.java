import java.util.Arrays;

public class MyList<E> {
    int size=0;
    static final int DEFAULT_CAPACITY=10;
    Object elements[];

    public MyList() {
        size = DEFAULT_CAPACITY;
        elements = new Object[size];
    }

    public MyList(int capacity) {
        size = capacity;
        elements = new Object[size];
    }

    public void ensureCapacity(int a) {
        int newSize = elements.length + a;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        ensureCapacity(1);
        for (int i = index+1; i < elements.length;i++) {
            elements[i+1]= elements[i];
        }
        elements[index] = element;
    }


    public void print() {
        for(int i= 0; i<elements.length;i++){
            System.out.print(elements[i] + " ");
        }
    }
}
