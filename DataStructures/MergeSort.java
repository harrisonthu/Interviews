
// Tutorial:
// https://www.youtube.com/watch?v=TzeBrDU-JaY
// https://www.geeksforgeeks.org/merge-sort/

public class MergeSort {


    // e.g
    //
    //          _________________________________
    //         |__38_|_27_|_43_|_3_|_9_|_82_|_10_|
    //Index==>     0    1    2   3   4   5     6 
    // 
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[],int l, int m, int r){

        // TEST: Print out the first time when merge function run??
        // System.out.println ("inside merge: l = "+ l +" m="+ m + " r="+r);
        // initialize size of two subarrays
        int n1 = m-l+1; // first subarray size
        int n2 = r-m;   // second subarray size

        // initialize array for two new subarrays
        int[] L = new int [n1];
        int[] R = new int [n2];

        // fill in all new initialized 1st subarray
        // TEST: System.out.print("l= " + l);
        for (int i=0;i<n1;i++){
            L[i] = arr[l+i]; // TODO why arr[l+i] instead of arr [i], Left subaray bring leftest of the splited(instead of first index)
        }
        // fill in all new initialized 2nd subarray
        for (int i=0;i<n2;i++){
            R[i] = arr[m+i+1];
        }

        // This section has been explained very well in Youtube video
        // Youtube: https://www.youtube.com/watch?v=TzeBrDU-JaY
        int i = 0;
        int j = 0;
        int k = l;

        
        // looping two subarrays to compare the values from each
        while(i<n1 && j< n2){
            // left subarray is less than right
            if(L[i] < R[j]){
                arr[k] = L[i]; // replace existing array with updated sorted values
                i++;
                //k++;
            }else{  // right subarray value less than left subarray
                arr[k] = R[j];
                j++;
                //k++;
            }
            k++;
        }

        // scenario when one of the bigger/longer subarray has elements
        // add the remaining items to replace the existing array
        while (i<n1){   // left subarray into existing original array
            arr[k] = L[i];
            k++;
            i++;
        }
        while (j<n2){   // add right subarray into existing original array
            arr[k] = R[j];
            k++;
            j++;
        }
    }


    // Main function that sorts arr[l..r] using
    // this sort() function split all original array in single pieces
    void sort (int arr[], int l, int r){
        if (l<r){
            int mid = (l+r)/2;
            sort(arr, l, mid);
            sort(arr, mid+1,r);
            merge(arr, l, mid, r);
        }
    }

    static void printarray(int arr[]){
        int n = arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int[]  myarray= {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printarray(myarray);
        MergeSort ob = new MergeSort();
        ob.sort(myarray, 0, myarray.length-1);
        System.out.println("\nSorted array");
        printarray(myarray); 
    }
}

