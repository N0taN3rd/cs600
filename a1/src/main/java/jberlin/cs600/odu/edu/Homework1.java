package jberlin.cs600.odu.edu;

import java.util.Arrays;


public class Homework1 {

    public static void nextPermutation(int n, int[] array) {
        int[] permutation = Arrays.copyOf(array, n);
        int i = n - 1;
        while (i > 0 && permutation[i - 1] >= permutation[i]) {
            --i;
        }

        if (i <= 0) {
            System.out.println(Arrays.toString(array));
            return;
        }

        int j = n - 1;


        while (permutation[j] <= permutation[i - 1]) {
            j--;
        }

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = n - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        nextPermutation(array.length, array);

    }
}
