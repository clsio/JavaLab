package me.zhang.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Zhang on 2016/3/22 上午 10:33 .
 */
public class Contains {
    public static void main(String[] args) {
        String[] arr = new String[10000];

        Random s = new Random();
        for (int i = 0; i < 10000; i++) {
            arr[i] = String.valueOf(s.nextInt());
        }

        //use list
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useList(arr, "A");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("useList:  " + duration / 1000000);

        //use set
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useSet(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useSet:  " + duration / 1000000);

        //use loop
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useLoop(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useLoop:  " + duration / 1000000);

        //use Arrays.binarySearch()
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useArraysBinarySearch(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useArrayBinary:  " + duration / 1000000);
    }

    public static boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    public static boolean useSet(String[] arr, String targetValue) {
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        return set.contains(targetValue);
    }

    public static boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }

    /* !!! In this case, the array is not sorted, therefore, it should not be used. */
    public static boolean useArraysBinarySearch(String[] arr, String targetValue) {
        int a = Arrays.binarySearch(arr, targetValue);
        return a > 0;
    }
}
