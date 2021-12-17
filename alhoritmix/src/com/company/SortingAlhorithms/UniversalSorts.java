package com.company.SortingAlhorithms;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class UniversalSorts {
    public static <T>T[] selectionSort(T[]arr, Comparator<T> comparator){
        int index_of_minimal;
        for (int i = 0; i < arr.length - 1; i++) {
            index_of_minimal = i + 1;
            for (int j = i; j < arr.length; j++){
                if (comparator.compare(arr[index_of_minimal], arr[j]) > 0){
                    index_of_minimal = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[index_of_minimal];
            arr[index_of_minimal] = temp;
        }
        return arr;
    }
    public static <T>T[] bubbleSort(T[] arr, Comparator<T> comparator){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++){
                if (comparator.compare(arr[j], arr[j + 1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    public static <T>T[] insertionSort(T[] arr, Comparator<T> comparator){
        int insert_index;
        for (int i = 1; i < arr.length; i++) {
            T current = arr[i];
            for (insert_index = i; insert_index > 0 && comparator.compare(arr[insert_index - 1], current) > 0; insert_index--){
                arr[insert_index] = arr[insert_index - 1];
            }
            arr[insert_index] = current;
        }
        return arr;
    }
    public static <T>T[] quickSort(T[] arr, int l, int r, Comparator<T> comparator){
        int templ = l;
        int tempr = r;
        int pivot = l + (r - l) / 2;
        if (pivot == l){
            return arr;
        }
        while (l <= r){
            while (comparator.compare(arr[l], arr[pivot]) < 0){
                l++;
            }
            while (comparator.compare(arr[r], arr[pivot]) > 0){
                r--;
            }
            if (comparator.compare(arr[l], arr[r]) > 0){
                T temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
            r--;
        }
        quickSort(arr, templ, pivot, comparator);
        quickSort(arr, pivot, tempr, comparator);
        return arr;
    }


    public static <T>T[] mergeSort(T[] arr, int l, int r, Comparator<T> comparator){
        if (r - l <= 2){
            return arr;
        }else{
            int pivot = l + (r - l) / 2 + (1 - (r - l) % 2);
            mergeSort(arr, l, pivot, comparator);
            mergeSort(arr, pivot, r, comparator);
            while (pivot <= r && l <= pivot){
                if(comparator.compare(arr[l], arr[pivot]) > 0){
                    T temp = arr[l];
                    arr[l] = arr[pivot];
                    arr[pivot] = temp;
                    pivot++;
                }else{
                    l++;
                }
            }
        }
        return arr;
    }
    public static <T>T[] sortFF(T[] arr, Comparator<T> comparator){
        for (int i = 1; i < arr.length / 2; i++) {
            for (int j = 0; j < arr.length / 2 - 1; j++) {
                if (comparator.compare(arr[j], arr[arr.length - j - i]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[arr.length - j - i];
                    arr[arr.length - j - i] = temp;
                }
                int pivot = arr.length / 2;
                int r = arr.length;
                int l = 0;
                if (comparator.compare(arr[i + j], arr[i + j + 1]) > 0){
                    T temp = arr[i + j];
                    arr[i + j] = arr[i + j + 1];
                    arr[i + j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
