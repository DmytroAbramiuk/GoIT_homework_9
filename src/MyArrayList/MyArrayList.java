package MyArrayList;

public class MyArrayList<T> {
    private Object[] array;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int size) {
        this.array = new Object[size];
    }

    public void add(T element) {
        sizeCheck();
        array[size] = element;
        size++;
    }

    private void indexCheck(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("Specified index does not exist");
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        indexCheck(index);
        return (T) array[index];
    }

    public void remove(int index) {
        indexCheck(index);
        array[index] = null;
        elementsDiplacement();
    }

    private void elementsDiplacement() {
        int amountOfSkipedElements = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                amountOfSkipedElements++;
            }
            array[i] = array[i + amountOfSkipedElements];
        }
        size--;
    }

    public void clear() {
        array = new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public String toString() {
        String strList = "[";
        if (size == 0) {
            return strList += "]";
        } else {
            for (int i = 0; i < array.length; i++) {
                if (i == size - 1) {
                    strList += get(i) + "]";
                    break;
                }
                strList += get(i) + ", ";
            }
        }
        return strList;
    }

    private void sizeCheck() {
        if (size >= array.length) {
            resizeArray();
        }
    }

    private void resizeArray() {
        Object[] temp = new Object[array.length + 5];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }
}
