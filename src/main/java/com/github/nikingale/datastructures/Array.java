package com.github.nikingale.datastructures;

/**
 * @author Nikhil Ingale 01-01-2021
 */

public class Array {

    int[] array;

    public Array() {
    }

    public Array(int[] array) {
        setArray(array);
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int searchArray(int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return index;
            }
        }
        return -1;
    }

}