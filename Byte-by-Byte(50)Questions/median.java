import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This question is from Page 1 from 50 Interview Questions (Byte by Byte)
// Median of Arrays
// Question(Q1) : Find the median of two sorted arrays.
// Solution:  https://www.byte-by-byte.com/median/ 
//

public class median {

    // Find the median (in a single array)
    public static double FindMedian(int[] inputarray) {
        double result = 0.0;
        if (inputarray.length >= 1) {
            int n = inputarray.length;
            int mid = n / 2;
            if (n % 2 == 0) {  // even size array n = 2, 4, 6, 8
                return (inputarray[mid - 1] + inputarray[mid]) / 2.0;
            } else {   // odd size array
                return inputarray[mid];
            }
        }
        return result;
    }

    // Find the median (in two arrays)
    public static double FindMedian2(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int o = n + m;
        int[] resultarr = new int[o];


        // Using Mergesort
        int i = 0; // index for arr1
        int j = 0; // index for arr2
        int k = 0; // index for resultarr

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                resultarr[k] = arr1[i];
                i++;
            } else { // arr2 [j] > arr1[i]
                resultarr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            resultarr[k] = arr1[i];
            i++;
        }

        while (j < m) {
            resultarr[k] = arr2[j];
            j++;
        }
        List<Integer> printout = new ArrayList<Integer>();
        for (int b : resultarr) {
            printout.add(b);
        }
        System.out.println("printout: " + printout);

        return FindMedian(resultarr);
    }


    public static void main(String args[]) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        FindMedian2(arr1, arr2);
        System.out.println(FindMedian2(arr1, arr2));
    }

}
