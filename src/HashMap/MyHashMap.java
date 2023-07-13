package HashMap;

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
            Entry<T, E> currentEntry = table[indexToPut];
            Entry<T, E> prevEntry = null;

            while (currentEntry != null) {
                if (currentEntry.getKey().equals(key)) {
                    currentEntry.setValue(value);
                    break;
                }
                prevEntry = currentEntry;
                currentEntry = currentEntry.getNextEntry();
            }

            if (prevEntry != null) {
                prevEntry.setNextEntry(entry);
            }
        }
    }

    public E get(T key) {
        int index = index(key);
        E value = null;
        Entry<T, E> currentEntry = table[index];

        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) {
                value = currentEntry.getValue();
                break;
            }
            currentEntry = currentEntry.getNextEntry();
        }
        return value;
    }

    public void remove(T key) {
        int index = index(key);
        Entry<T, E> currentEntry = table[index];
        Entry<T, E> prevEntry = null;

        if (currentEntry == null) {
            return;
        }

        if (currentEntry.getKey() == key) {
            table[index] = currentEntry.getNextEntry();
            return;
        }

        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) {
                prevEntry.setNextEntry(currentEntry.getNextEntry());
                break;
            }
            prevEntry = currentEntry;
            currentEntry = currentEntry.getNextEntry();
        }
    }

    public void clear() {
        for (int i = 0; i < table.length; i++)
            table[i] = null;
    }

    public int size() {
        int length = 0;
        Entry<T, E> currentEntry;
        for (int i = 0; i < table.length; i++) {
            currentEntry = table[i];
            if (table[i] != null) {
                while (currentEntry != null) {
                    length++;
                    currentEntry = currentEntry.getNextEntry();
                }
            }
        }
        return length;
    }

    @Override
    public String toString() {
        String hashMapStr = "empty";
        Entry<T, E> currentEntry;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            } else {
                if (hashMapStr.equals("empty"))
                    hashMapStr = "";
                currentEntry = table[i];
                while (currentEntry != null) {
                    if (currentEntry.getNextEntry() == null) {
                        hashMapStr += "{key: " + currentEntry.getKey() + ", value: " + currentEntry.getValue() + "}\n";
                    } else {
                        hashMapStr += "{key: " + currentEntry.getKey() + ", value: " + currentEntry.getValue() + "}, ";
                    }
                    currentEntry = currentEntry.getNextEntry();
                }
            }
        }
        return hashMapStr;
    }
}
