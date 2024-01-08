package com.example;

/**
 * Write a function that takes an array and return sorted version of the array. use bubble sort to sort
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        boolean sorted = false;
        for(int i=0 ;i<array.length-1 && !sorted; i++){
            sorted = true; //assuming sorted = true
            for(int j = 0 ; j < array.length-1-i; j++){
                if(array[j] > array[j+1]){
                    sorted = false;
                    int temp = array[j];
                    array[j] =  array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
