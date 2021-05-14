package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void quickSort(int[] x){
        quickSort(x, 0, x.length - 1);
    }
    public static void swap(int[] x, int i, int j){ //Created swap method
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    private static void quickSort(int[] x, int start, int end){
        if(start < end){
            int pi = partition(x, start, end); //pi is partitioning index
            quickSort(x, start, pi - 1); //Sort left half
            quickSort(x, pi + 1, end); //Sort right half
        }
    }
    private static int partition(int[] x, int start, int end){
        int pivot = x[end]; //Select the pivot point
        int i = start - 1; //Index of right position of pivot found
        for(int j = start; j <= end - 1; j++){
            if(x[j] < pivot){ //if element smaller than pivot
                //Increment index of smaller element and do swap
                i++;
                swap(x, i, j);
            }
        }
        swap(x, i+1, end);
        return i+1;

    }
    public static void main(String[] args) {
        int n; //Size of array
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] x = new int[n];
        for(int i = 0; i < n; i++){
            x[i] = scanner.nextInt(); //Input array
        }
        quickSort(x); //Called our method
        for(int i = 0; i < n; i++){ //Output the result
            System.out.print(x[i] + " ");
        }
    }
}
