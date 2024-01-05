package sort.mergeSort;

import java.util.Arrays;
//归并排序
public class mergeSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{7,5,2,3,6,4};
        System.out.println("原始数组："+ Arrays.toString(arr));
        MergeSort(arr);
        System.out.println("排序后的数组："+ Arrays.toString(arr));
    }
    public static void MergeSort(int [] arr){
        if(arr.length<=1||arr==null){return ;}
        int [] temp=new int[arr.length];
        sort(arr, 0,arr.length-1,temp);
    }
    public static void sort(int [] arr, int left, int right, int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            sort(arr, left, mid, temp);
            sort(arr, mid+1, right, temp);
            merge(arr,left,mid,right,temp);
        }
    }
    public static void merge(int [] arr, int left, int mid,int right, int[] temp){
        int i=left;
        int j=mid+1;
        int k=left;
        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=right){
            temp[k++]=arr[j++];
        }
        for(int x=left;x<=right;x++){
            arr[x]=temp[x];
        }
    }
}
