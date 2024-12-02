import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<E> {

    private final int INIT_CAPACITY = 10;
    private int elementPointer = 0;
    E[] customArray;

    public CustomArrayList() {
        this.customArray = (E[]) new Object[INIT_CAPACITY];
    }

    public E[] add(E element) {

        increaseArraySize(elementPointer);
        customArray[elementPointer++] = element;
        return customArray;
    }


    public void add(int index, E element) {
        if (index < elementPointer) {
            elementPointer++;
            increaseArraySize(elementPointer);
            for (int i = elementPointer; i > index; i--) {
                E e = customArray[elementPointer];
                customArray[elementPointer + 1] = e;
            }
            customArray[index] = element;
        } else {
            throw new RuntimeException("введенный индекс превышает размер листа");
        }
    }

    private void increaseArraySize(int index) {
        if (customArray.length < index) {
            E[] anotherArray = (E[]) new Object[customArray.length + INIT_CAPACITY / 2];
            System.arraycopy(customArray, 0, anotherArray, 0, index - 1);
            customArray = anotherArray;
        }
    }

    public void addAll(Collection<? extends E> c){
        for (E e : c) {
            add(customArray.length + 1, e);
        }
    }

    public void clear() {

        Arrays.fill(customArray, null);
    }

    public E get(int index) {
        if (index < elementPointer && customArray[index] == null) {
            throw new RuntimeException("Not such element");
        } return (E) customArray[index];
    }

    public boolean isEmpty() {
        return customArray.length == 0;
    }

    public void remove(int index){

        if (index < 0 || index >= elementPointer) {
            throw new RuntimeException("нет такого значения по индексу");
        }
        int moveCount = elementPointer - index - 1;
        if (moveCount > 0) {
            System.arraycopy(customArray, index + 1, customArray, index, moveCount);
        } customArray[--elementPointer] = null;
    }

    public void remove(Object o) {
        for (int i = 0; i < customArray.length; i++) {
            if (customArray[i].equals(o)) {
                remove(i);
            }
        }
    }

    public void sort(Comparator<? super E> c) {
        if (elementPointer > 1) {
            quickSort(customArray, 0, elementPointer - 1, c);
        }
    }

    private void quickSort(E[] array, int low, int high, Comparator<? super E> c) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, c);
            quickSort(array, low, pivotIndex - 1, c);
            quickSort(array, pivotIndex + 1, high, c);
        }
    }

    private int partition(E[] array, int low, int high, Comparator<? super E> c) {
        E pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (c.compare(array[j], pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < customArray.length; i++) {
            builder = builder.append(this.customArray[i].toString() + " " + i);
        }
        return builder.toString();
    }
}
