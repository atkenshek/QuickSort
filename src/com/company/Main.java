package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {
    public void quickSort(int[] x){
        quickSort(x, 0, x.length - 1);
    }
    public static void swap(int[] x, int i, int j){
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    private static void quickSort(int[] x, int start, int end){
        if(start < end){
            int pi = partition(x, start, end);
            quickSort(x, start, pi - 1); //Before pi
            quickSort(x, pi + 1, end); //After pi
        }
    }
    private static int partition(int[] x, int start, int end){
        int pivot = x[end];
        int i = start - 1;
        for(int j = start; j <= end - 1; j++){
            if(x[j] < pivot){
                i++;
                swap(x, i, j);
            }
        }
        swap(x, i+1, end);
        return i+1;

    }
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] x = new int[n];
        for(int i = 0; i < n; i++){
            x[i] = scanner.nextInt();
        }
        quickSort(x, 0, n-1);
        for(int i = 0; i < n; i++){
            System.out.print(x[i] + " ");
        }
    }
}
