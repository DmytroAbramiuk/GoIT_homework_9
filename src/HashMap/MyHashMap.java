package HashMap;

import static java.util.Objects.hash;

public class MyHashMap<T, E> {
    private int capacity = 8;
    private int size = 0;
    private Entry<T, E>[] table;

    public MyHashMap() {
        table = new Entry[capacity];
    }

    public int index(T key) {
        int hashCodeOfKey = hash(key);
        return hashCodeOfKey & (capacity - 1);
    }

    private void sizeCheck() {
        if (size == table.length) {
            resize();
        }
    }

    public Entry<T, E>[] putElementOfTableIntoCopy(Entry<T, E>[] toCopy, Entry<T, E> elementEntry) {
        T currentKey;
        E currentValue;
        while (elementEntry != null) {
            currentKey = elementEntry.getKey();
            currentValue = elementEntry.getValue();

            int index = index(currentKey);

            if (toCopy[index] == null) {
                toCopy[index] = new Entry<>(currentKey, currentValue, null);
            } else {
                Entry<T, E> currentEntry = toCopy[index];

                while (currentEntry.getNextEntry() != null) {
                    currentEntry = currentEntry.getNextEntry();
                }
                currentEntry.setNextEntry(new Entry<>(currentKey, currentValue, null));
            }
            elementEntry = elementEntry.getNextEntry();
        }
        return toCopy;
    }

    private void resize() {
        capacity *= 2;
        Entry<T, E>[] temp = new Entry[capacity];
        Entry<T, E> currentEntry;

        for (Entry<T, E> entry : table) {
            if (entry != null) {
                currentEntry = entry;
                temp = putElementOfTableIntoCopy(temp, currentEntry);
            }
        }
        table = temp;
    }

    public void put(T key, E value) {
        sizeCheck();
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
        size++;
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
            size--;
            return;
        }

        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) {
                prevEntry.setNextEntry(currentEntry.getNextEntry());
                size--;
                break;
            }
            prevEntry = currentEntry;
            currentEntry = currentEntry.getNextEntry();
        }
    }

    public void clear() {
        table = new Entry[capacity];
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String hashMapStr = "{}";
        Entry<T, E> currentEntry;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (hashMapStr.equals("{}"))
                    hashMapStr = "";
                currentEntry = table[i];
                while (currentEntry != null) {
                    if (currentEntry.getNextEntry() == null) {
                        hashMapStr += "{key: " + currentEntry.getKey() + ", value: " + currentEntry.getValue() + "}";
                        if (i < table.length - 1) {
                            hashMapStr += "\n";
                        }
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
