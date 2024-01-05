package sort.quickSort;

import java.util.Arrays;

public class Main {
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(array));
        }
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        System.out.println("end");
        System.out.println(Arrays.toString(array));

        return pointer;
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int position = partition(array, low, high);
            quickSort(array, low, position - 1);
            quickSort(array, position + 1, high);
        }
    }

    public static void main(String[] args) {
        int [] arr={2,1,7,5,6,3,4};
        quickSort(arr,0,6);
    }
}
