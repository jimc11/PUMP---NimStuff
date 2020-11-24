package edu.sjsu;

import java.util.ArrayList;
import java.util.Arrays;

// the list is the values of each subhand (1.a., 1.b., 1.c., 1.d., 2.a., 2.b., ... )
public class NimList {

    private ArrayList<Integer> nimValues;
    private int max;

    public NimList(){
        nimValues = new ArrayList<Integer>();
        max = -1;
    }
    public void addNim(int newVal){
        this.nimValues.add(newVal);
    }


    public static int nimSum(int [] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++){
            sum = arr[i] ^ sum;
        }
        return sum;
    }


    // this is very slow for big values!
    public int MEX(){
        Integer [] temp2 = this.nimValues.toArray(new Integer[0]);
        int [] temp = new int[temp2.length];
        for (int i = 0; i< temp2.length; i++){
            temp[i] = temp2[i].intValue();
        }

        quickSort(temp,0,temp.length-1);
        removeDuplicates(temp, temp.length);

        int mex = 0;

        for (int i = 0; i < temp.length ; i++){
            if (temp[i] == mex)
                mex++;
            else
                break;
        }
        return mex;
    }
    // ----- support functions -----
    static int removeDuplicates(int arr[], int n)
    {
        // Return, if array is empty
        // or contains a single element
        if (n==0 || n==1)
            return n;

        int[] temp = new int[n];

        // Start traversing elements
        int j = 0;
        for (int i=0; i<n-1; i++)
            // If current element is not equal
            // to next element then store that
            // current element
            if (arr[i] != arr[i+1])
                temp[j++] = arr[i];

        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        temp[j++] = arr[n-1];

        // Modify original array
        for (int i=0; i<j; i++)
            arr[i] = temp[i];

        return j;
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    public static void quickSort(int [] arr, int low, int high)
    {
        if (low < high)
        {
        /* pi is partitioning index, arr[pi] is now
           at right place */
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Before pi
            quickSort(arr, pi + 1, high); // After pi
        }
    }

    // ----- driver -----
    public static void main(String[] args) {
    /*    int [] arr = new int [] {5,5,4,2,2,3,6,0,1,9,8,8,9,1,3,45,0,7,10};
        int mex = MEX(arr);
        System.out.println("Mex: ");
        System.out.println(mex);*/
    }
}
