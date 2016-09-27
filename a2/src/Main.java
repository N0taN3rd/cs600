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


    public static void doMaxHeapyify(int[] array,int i) {
        int largest = Integer.MIN_VALUE;

        while(largest != i) {
            System.out.println(i);
            int l = lchild(i);
            int r = rchild(i);
            if (l <= array.length - 1 && (array[l] > array[i])) {
                largest = l;
            } else {
                largest = i;
            }

            if (r <= array.length - 1 && (array[r] > array[largest])) {
                largest = r;
            }
            if (largest != i) {
                int temp = array[i];
                array[i] = array[largest];
                array[largest] = temp;
                i = largest;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Random randy = new Random();
        int[] randomArray = randy.ints(randy.nextInt(100), 0, 100).toArray();
        int[] array = Arrays.copyOf(randomArray,randomArray.length);
        int[] array2 = Arrays.copyOf(randomArray,randomArray.length);
        assert array.length == array2.length;
        maxHeapify(array);
        doMaxHeapyify(array2,3);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
}
