package sort.mergeSort;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,5,2,3,6,4};
        System.out.println("原始数组："+ Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后的数组："+ Arrays.toString(arr));
    }
    // 归并排序的入口方法
    public static void mergeSort(int[] arr) {
        // 针对特殊情况，数组为空或只有一个元素时，无需排序
        if(arr == null || arr.length <= 1  ){
            return;
        }
        // 创建一个临时数组用于归并操作
        int[] temp = new int[arr.length];

        // 调用实际的排序方法，传入数组、左边界、右边界和临时数组
        sort(arr, 0, arr.length - 1, temp);
    }

    // 归并排序的核心排序方法(递归调用的方法)
    public static void sort(int[] arr,int left,int right,int[] temp) {
        //递归终止的条件
        if(left < right){
            //计算中间位置分割的下标
            int mid = (right + left) / 2;
            // 递归对左半部分进行排序

            sort(arr, left, mid, temp);
            // 递归对右半部分进行排序
            sort(arr, mid+1, right, temp);
            //合并
            //System.out.println(left+" "+mid+" "+right+" "+temp[0]+" "+temp[1]+" "+temp[2]+" "+temp[3]+" "+temp[4]+" "+temp[5]+" ");
            merge(arr,left,mid,right,temp);
            System.out.println(left+" "+mid+" "+right+" "+temp[0]+" "+temp[1]+" "+temp[2]+" "+temp[3]+" "+temp[4]+" "+temp[5]+" ");
        }

    }


    // 归并排序的核心归并方法
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;
        //System.out.println(left);
        // 比较左右两部分的元素，并将较小的元素放入临时数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //如果右边元素先放完，则将左边剩余的元素逐个放入临时数组中
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        //如果左边元素先放完，则将右边剩余的元素逐个放入临时数组中
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将临时数组的结果复制回原数组
        for (int l = left; l <= right; l++) {
            arr[l] = temp[l];
        }
    }
}
