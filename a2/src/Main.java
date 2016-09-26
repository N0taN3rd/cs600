import java.util.Arrays;
import java.util.Random;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {

    public static int lchild(int i) {
        return i * 2;
    }

    public static int rchild(int i) {
        return lchild(i) + 1;
    }

    public static boolean isLeaf(int i,int n) {
        return i >= n /2 && i < n;
    }

    public static void percolateDown(int i, int[] array) {
        int n = array.length;

        while (!isLeaf(i,n)) {
            int lpos = lchild(i);
            if(lpos < n - 1 && array[i] < array[i+1]) {
                lpos++;
            }
            if(array[i] > array[lpos]) {
                return;
            }
            int temp = array[i];
            array[i] = array[lpos];
            array[lpos] = temp;
            i = lpos;
        }
    }

    public static void maxHeapify(int[] array) {
        int n = array.length;
        for(int i = (n / 2) - 1; i >= 0; --i) {
           percolateDown(i,array);
        }
    }

    public static void main(String[] args) {
        Random randy = new Random();
        int[] array = randy.ints(randy.nextInt(100), 0, 100).toArray();
        maxHeapify(array);
        System.out.println(Arrays.toString(array));
    }
}
