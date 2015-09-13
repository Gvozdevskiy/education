package edu.spbu.cs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by artemaliev on 07/09/15.
 */
public class IntSort {

    public static void sort(int array[]) {
        int copy[]=new int[array.length];
        mergeSort(array,copy, 0, array.length);

    }

    public static void sort(List<Integer> list) {
        Collections.sort(list);
    }


    public  static void mergeSort(int array[],int copy[], int begin, int end) {
        if (begin == end | begin+1==end) {
            return;
        }
        int middle = (begin + end)/2;

        mergeSort(array,copy, begin, middle);
        mergeSort(array,copy, middle, end);
        merge(array,copy, begin, middle, end);
    }

    public static void merge(int array[],int copy[], int begin, int middle, int end) {
        int i = begin;
        int j = middle;

        for(int k=begin; k<end; k++) {

           if(j<end) {
               if (array[i] > array[j] | i == middle) {
                   copy[k] = array[j];

                   j++;
               } else {
                   copy[k] = array[i];

                   i++;
               }
           }else {
               copy[k] = array[i];

               i++;
           }
        }
        for (i = begin; i < end; i++) {
            array[i] = copy[i];
        }

    }
}