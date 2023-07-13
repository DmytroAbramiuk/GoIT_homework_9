package HashMap;

import java.util.Arrays;

import static java.util.Objects.hash;

public class MyHashMap<T, E> {
    private final int capacity = 15;
    private Entry<T, E>[] table;

    public MyHashMap() {
        table = new Entry[capacity];
    }

    public int index(T key) {
        int hashCodeOfKey = hash(key);
        return hashCodeOfKey & (capacity - 1);
    }

    public void put(T key, E value) {
        int indexToPut = index(key);
        Entry entry = new Entry(key, value, null);

        if (table[indexToPut] == null) {
            table[indexToPut] = entry;
        } else {
            Entry<T, E> currentNode = table[indexToPut];
            Entry<T, E> prevNode = null;

            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    break;
                }
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }

            if (prevNode != null) {
                prevNode.setNextNode(entry);
            }
        }
    }

    public E get(T key) {
        int index = index(key);
        E value = null;
        Entry<T, E> currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                value = currentNode.getValue();
                break;
            }
            currentNode = currentNode.getNextNode();
        }
        return value;
    }

    public void remove(T key) {
        int index = index(key);
        Entry<T, E> currentNode = table[index];
        Entry<T, E> prevNode = null;

        if (currentNode == null) {
            return;
        }

        if (currentNode.getKey() == key) {
            table[index] = currentNode.getNextNode();
            return;
        }

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                prevNode.setNextNode(currentNode.getNextNode());
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
    }

    public void clear() {
        for (int i = 0; i < table.length; i++)
            table[i] = null;
    }

    public int size() {
        int length = 0;
        Entry<T, E> currentNode;
        for (int i = 0; i < table.length; i++) {
            currentNode = table[i];
            if (table[i] != null) {
                while (currentNode != null) {
                    length++;
                    currentNode = currentNode.getNextNode();
                }
            }
        }
        return length;
    }

    @Override
    public String toString() {
        String hashMapStr = "empty";
        Entry<T, E> currentNode;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            } else {
                if (hashMapStr.equals("empty"))
                    hashMapStr = "";
                currentNode = table[i];
                while (currentNode != null) {
                    if (currentNode.getNextNode() == null) {
                        hashMapStr += "{key: " + currentNode.getKey() + ", value: " + currentNode.getValue() + "}\n";
                    } else {
                        hashMapStr += "{key: " + currentNode.getKey() + ", value: " + currentNode.getValue() + "}, ";
                    }
                    currentNode = currentNode.getNextNode();
                }
            }
        }
        return hashMapStr;
    }
}
