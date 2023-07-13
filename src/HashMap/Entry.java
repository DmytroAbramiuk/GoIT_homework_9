package HashMap;

public class Entry<T, E> {
    private T key;
    private E value;
    private Entry<T, E> nextEntry;

    public Entry(T key, E value, Entry<T, E> nextEntry) {
        this.key = key;
        this.value = value;
        this.nextEntry = nextEntry;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Entry<T, E> getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(Entry<T, E> nextEntry) {
        this.nextEntry = nextEntry;
    }
}
