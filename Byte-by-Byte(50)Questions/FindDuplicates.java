import java.util.ArrayList;
import java.util.HashSet;


// This question is from Page 8 from 50 Interview Questions (Byte by Byte)
// Find Duplicates 
// Question(Q4) :  Given an array of integers where each value 1 <=x<=len(array)
// write a function that ﬁnds all the duplicates in the array
// Solution:  https://www.byte-by-byte.com/findduplicates/?utm_source=optin_carrot&utm_medium=pdf&utm_campaign=50questions
//
public class FindDuplicates {


    public static HashSet FindDuplicates(int[] arr) {
        // If the input array is empty, return
        if (arr.length == 0) {
            return new HashSet();
        }

        HashSet<Integer> myhs = new HashSet<Integer>();
        HashSet<Integer> dupeslist = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            // if current value in arry contain in dupeslist<Hashset>
            if (myhs.contains(arr[i])) {
                dupeslist.add(arr[i]);
                continue;
            }
            // Not included in dupeslist, so add it to hashset
            else {
                myhs.add(arr[i]);
            }
        }
        return dupeslist;

    }

    public static void main(String[] args) {
        int[] arr = {2 , 1, 2, 1,7,8,8,8,8,8};
        System.out.println(FindDuplicates(arr));

    }
}
