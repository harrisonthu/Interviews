import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This question is from Page 1 from 50 Interview Questions (Byte by Byte)
// Median of Arrays 
// Question(Q1) : Find the median of two sorted arrays. 
// Solution:  https://www.byte-by-byte.com/median/ 
//
public class median {

    public median() {


    }

    public static double findmedian(int[] inputarray) {
        double result = 0.0;
        if (inputarray.length >= 1) {
            int n = inputarray.length;
            int mid = n / 2;
            if (n % 2 == 0) {  // even size array
//                if(inputarray.length>=2){  // Array size is more than 2
//
//                }

                //result = (inputarray[mid-1]+ inputarray[mid])/2.0;
                return (inputarray[mid - 1] + inputarray[mid]) / 2.0;
            } else {   // odd size array

                //result = (inputarray[mid]);
                return inputarray[mid];
            }

        }
        return result;
    }


    public static void main(String args[]) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        int n = arr1.length;
        int m = arr2.length;

        // create the array to store the final sorted array
        int finalsize = (int) n + m;
        int[] finalsortedarray = new int[finalsize];

        //using Mergesort idea to sort the two sorted arrays.
        int i = 0; // indexes for arr1
        int j = 0; // indexes for arr2
        int k = 0; // indexes for finalsortedarray

        // compare values from two arrays
        while (i < n && j < m) {

            if (arr1[i] < arr2[j]) {
                finalsortedarray[k] = arr1[i];
                i++;
            } else {
                finalsortedarray[k] = arr2[j];
                j++;
            }
            k++;
        }
        // if the two input arrays are not same size
        // add the rest of the values from larger size array
        while (i < n) { // if arr1 size is larger than arr2
            finalsortedarray[k] = arr1[i];
            k++;
            i++;
        }
        while (j < m) { // if arr2 size is larger than arr1
            finalsortedarray[k] = arr2[j];
            k++;
            j++;
        }
        System.out.println(Arrays.toString(finalsortedarray));
        System.out.println(findmedian(finalsortedarray));
    }

}
