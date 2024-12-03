import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<E> {

    private final int INIT_CAPACITY = 10;
    private int elementAmount = 0;
    E[] customArray;

    public CustomArrayList() {
        this.customArray = (E[]) new Object[INIT_CAPACITY];
    }

    public E[] add(E element) {

        increaseArraySize(elementAmount);
        customArray[elementAmount++] = element;
        return customArray;
    }

    public void add(int index, E element) {
        if (index <= elementAmount) {
            elementAmount++;
            increaseArraySize(elementAmount);
            for (int i = elementAmount; i > index; i--) {
                E e = customArray[elementAmount];
                customArray[elementAmount + 1] = e;
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
            add(elementAmount, e);
        }
    }

    public void clear() {
        Arrays.fill(customArray, null);
    }

    public E get(int index) {
        if (index < elementAmount && customArray[index] == null) {
            throw new RuntimeException("Not such element");
        } return (E) customArray[index];
    }

    public boolean isEmpty() {
        return elementAmount == 0;
    }

    public void remove(int index){

        if (index < 0 || index >= elementAmount) {
            throw new RuntimeException("нет такого значения по индексу");
        }
        int moveCount = elementAmount - index - 1;
        if (moveCount > 0) {
            System.arraycopy(customArray, index + 1, customArray, index, moveCount);
        } customArray[--elementAmount] = null;
    }

    public void remove(Object o) {
        for (int i = 0; i < elementAmount; i++) {
            if (customArray[i].equals(o)) {
                remove(i);
            }
        }
    }

    public void sort(Comparator<? super E> c) {
        if (elementAmount > 1) {
            quickSort(customArray, 0, elementAmount - 1, c);
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
        builder.append("[");
        for (int i = 0; i < elementAmount; i++) {
            builder = builder.append(customArray[i].toString() + ", ");
        }
        int i = builder.toString().length();
        builder.replace(i-2, i, "");
        builder.append("]");
        return builder.toString();
    }
}
