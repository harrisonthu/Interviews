// This question is from Page 7 from 50 Interview Questions (Byte by Byte)
// Median of Arrays
// Question(Q3) : Given a matrix, ﬁnd the path from top left to bottom right
//                with the greatest product by moving only down and right.
// Solution:      https://www.byte-by-byte.com/matrixproduct/
// E.g
//  
//  [1, 2, 3]
//  [4, 5, 6]
//  [7, 8, 9]
//  1 -> 4 -> 7 -> 8 -> 9
//  Ans: 2016
 
//  [-1, 2, 3]
//  [4, 5, -6]
//  [7, 8, 9]
//   
//  -1 -> 4 -> 5 -> -6 -> 9
//  Ans: 1080
//  
//  
//  
public class MatrixProduct {

    // Function to solve the problem
    // Returns the maxinum number of product from the matrix
    public int MatrixProduct(int[][] matrix) {
        // Base Case:
        //     When input arry size is 0, return 0
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // Create MinCache/MaxCache
        // Reason because last cell(rightest bottom value is negative, in that scenario,
        // we have to pick the smaller of the two possible values from (top/left cell)
        int[][] MaxCache = new int[matrix.length][matrix[0].length];
        int[][] MinCache = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int MinVal = Integer.MAX_VALUE;  // possible greatest Min val so far in this path
                int MaxVal = Integer.MIN_VALUE;  // possible greatest Max val so far in this path
                // First row/First Col ==> Carry it to the first row/col in MaxCache/MinCache
                //  Since we need to copy the product from top/left since there is no 2 options to check max/min
                if (row == 0 && col == 0) {
                    MaxVal = matrix[row][col]; // set first value of input matrix to MaxVal
                    MinVal = matrix[row][col];
                }
                // Starting from second row
                if (row > 0) {
                    // TempMaxVal = current cell of possible Max value while looping
                    int TempMaxVal = Math.max(matrix[row][col] * MinCache[row - 1][col], matrix[row][col] * MaxCache[row - 1][col]);
                    MaxVal = Math.max(TempMaxVal, MaxVal);
                    int TempMinVal = Math.min(matrix[row][col] * MinCache[row - 1][col], matrix[row][col] * MaxCache[row - 1][col]);
                    MinVal = Math.min(TempMinVal, MinVal);
                } 
              
                if (col > 0) {
                    // TempMaxVal = current cell of possible Max value while looping
                    int TempMaxVal = Math.max(matrix[row][col] * MinCache[row][col - 1], matrix[row][col] * MaxCache[row][col - 1]);
                    MaxVal = Math.max(TempMaxVal, MaxVal);
                    int TempMinVal = Math.min(matrix[row][col] * MinCache[row][col - 1], matrix[row][col] * MaxCache[row][col - 1]);
                    MinVal = Math.min(TempMinVal, MinVal);
                }
                MaxCache[row][col] = MaxVal;  // Return total max val so far
                MinCache[row][col] = MinVal;  // Return total min val so far
            }
        }
        return MaxCache[MaxCache.length - 1][MaxCache[0].length - 1];
    }



    public static void main(String[] args) {
        int[][] arr = {{-1, 2,3}, {4, 5, -6}, {7, 8, 9}};

//        for (int i = 0; i <arr.length ; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//
//            System.out.println();
//        }
        MatrixProduct myclass = new MatrixProduct();
        System.out.println(myclass.matrixProduct(arr));

    }
}
