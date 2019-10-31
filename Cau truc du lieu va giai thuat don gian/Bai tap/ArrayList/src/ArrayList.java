import java.util.Arrays;

public class ArrayList<E> {
    int size=0;
    static final int DEFAULT_CAPACITY=10;
    Object elements[];

    public ArrayList() {
        size = DEFAULT_CAPACITY;
        elements = new Object[size];
    }

    public ArrayList(int capacity) {
        size = capacity;
        elements = new Object[size];
    }

    public void ensureCapacity(int a) {
        int newSize = elements.length + a;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        ensureCapacity(1);
        elements[elements.length-1]=elements[elements.length-2];
        for (int i = index+1; i < elements.length-1;i++) {
            elements[i+1]= elements[i];
        }
        elements[elements.length-1]=elements[elements.length-2];
        elements[index] = element;
    }

    public void setIndex(int index, E element) {
        elements[index]=element;
    }

   public String toString(){
        String result = "";
        for(int i= 0; i<elements.length;i++){
            result+=elements[i] + " ";
        }
        return result;
    }

    public E remove(int index) {
        E result = (E) elements[index];
        for(int i=index;i<elements.length-1;i++){
            elements[i]=elements[i+1];
        }
        ensureCapacity(-1);
        return (E) result;
    }

    public int size() {
        return elements.length;
    }

    public E clone(){
        E elements2= (E) elements;
        return elements2;
    }

    public boolean contains(E o) {
        boolean check=false;
        for (int i = 0; i < elements.length; i++) {
            if(elements[i]==o)
                check=true;
        }
        return check;
    }

    public int indexOf(E o) {
        int check =-1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == o)
                check = i;
            break;
        }
        return check;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void clear() {
        for(int i=0; i <elements.length; i++) {
            elements[i]=null;
        }
    }
}