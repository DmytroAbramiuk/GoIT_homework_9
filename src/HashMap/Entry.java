package HashMap;

public class Entry<T, E> {
    private T key;
    private E value;
    private Entry<T, E> nextNode;

    public Entry(T key, E value, Entry<T, E> nextNode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
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

    public Entry<T, E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Entry<T, E> nextNode) {
        this.nextNode = nextNode;
    }
}
