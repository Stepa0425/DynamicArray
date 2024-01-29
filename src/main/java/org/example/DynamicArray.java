package org.example;

import java.util.Arrays;

public class DynamicArray {
    private int[] array;
    private final double GROWTH_FACTOR = 1.5;
    private int capacity;
    private int size;


    public DynamicArray(int size) {
        if (size < 0) {
            System.out.println("You can't create an array with negative size value!");
            return;
        }
        this.size = size;
        this.capacity = getIncreaseCapacity(size);
        this.array = new int[this.capacity];
    }

    public DynamicArray(int[] array) {
        this.size = array.length;
        this.capacity = getIncreaseCapacity(array.length);
        this.array = Arrays.copyOf(array, this.capacity);
    }

    private int getIncreaseCapacity(int capacity) {
        return (int) (capacity * GROWTH_FACTOR);
    }

    private int getDecreaseCapacity(int capacity) {
        return (int) (capacity / GROWTH_FACTOR);
    }

    private void increaseCapacity() {
        this.capacity = getIncreaseCapacity(this.capacity);
        this.array = Arrays.copyOf(this.array, this.capacity);
    }

    private void decreaseCapacity() {
        this.capacity = getDecreaseCapacity(this.capacity);
        this.array = Arrays.copyOf(this.array, this.capacity);
    }


    public int size() {
        return this.size;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + "\t");
        }
        System.out.println();
    }

    public void add(int newElement) {
        if (this.size == this.capacity) {
            increaseCapacity();
        }
        if (this.size == 0) {
            this.array = new int[1];
            this.array[this.size] = newElement;
            this.size = 1;
        } else {
            this.array[this.size] = newElement;
            this.size++;
        }
    }

    public void addAll(int[] elements) {
        if(elements.length == 0){
            return;
        }
        while (this.size + elements.length > this.capacity) {
            this.increaseCapacity();
        }

        int[] resultArray = Arrays.copyOf(this.array, this.capacity);
        System.arraycopy(elements, 0, resultArray, this.size, elements.length);
        this.array = resultArray;
        this.size += elements.length;
    }

    public void remove(int elementToRemove) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == elementToRemove) {
                for (int j = i; j < this.size - 1; j++) {
                    this.array[j] = this.array[j + 1];
                }
                this.size--;
                break;
            }
        }
        double quotient = (double) this.capacity / this.size;
        if (quotient > 1.5) {
            decreaseCapacity();
        }
        int[] resultArray = new int[this.capacity];
        System.arraycopy(this.array, 0, resultArray, 0, this.size);
        this.array = resultArray;
    }


    public void removeAll(int[] elements) {
        int length = this.size;
        int lengthElements = elements.length;

        if (lengthElements > length || lengthElements == 0) {
            return;
        }

        for (int i = 0; i <= length - lengthElements; i++) {
            int[] firstArray = new int[lengthElements];
            System.arraycopy(this.array, i, firstArray, 0, lengthElements);

            if (Arrays.equals(firstArray, elements)) {
                int k = 0;
                while (k < lengthElements) {
                    this.remove(this.array[i]);
                    k++;
                }
                break;
            }
        }
    }

    public int indexOf(int element) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.array[i] == element) {
                index = i;
            }
        }
        return index;
    }

    public boolean contains(int element) {
        int indexElement = Arrays.binarySearch(this.array, element);
        return indexElement >= 0;
    }

    public int[] reversedToInt() {
        int[] reversedArray = new int[this.size()];
        for (int i = this.size(); i > 0; i--) {
            reversedArray[this.size() - i] = this.array[i - 1];
        }
        return reversedArray;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            result.append(this.array[i]).append("\t");
        }
        return result.toString();
    }

    public int[] toIntArray() {
        return Arrays.copyOf(this.array, this.size);
    }
}


