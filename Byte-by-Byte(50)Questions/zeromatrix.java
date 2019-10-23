// This question is from Page 9 from 50 Interview Questions (Byte by Byte)
// Zero Matrix
// Question(Q6) :  Given a boolean matrix, update it so that if any cell is true,
//                  all the cells in that row and column are true
// Solution:      https://www.byte-by-byte.com/zeromatrix/
// Solution:      (Similar one)https://leetcode.com/problems/set-matrix-zeroes/discuss/408914/Java-100-runtime-O(1)-extra-space

public class MatrixProduct {

    // Constructor
    protected int MatrixProduct(int[][] matrix) {
        // Base Case:
        //     When row/col is 0, return 0
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] MaxCache = new int[matrix.length][matrix[0].length];
        int[][] MinCache = new int[matrix.length][matrix[0].length];
        // Create MinCache/MaxCache


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int MinVal = Integer.MAX_VALUE;  // possible greatest Min val so far in this path
                int MaxVal = Integer.MIN_VALUE;  // possible greatest Max val so far in this path
                // First row/First Col ==> Carry it to the first row/col in MaxCache/MinCache

                if (row == 0 && col == 0) {
                    MaxVal = matrix[row][col];
                    MinVal = matrix[row][col];
                    //continue;
                }
                // When row is greater than 1,

                if (row > 0) {
                    // TempMaxVal = current cell of possible Max value while looping
                    int TempMaxVal = Math.max(matrix[row][col] * MinCache[row - 1][col], matrix[row][col] * MaxCache[row - 1][col]);
                    MaxVal = Math.max(TempMaxVal, MaxVal);
                    int TempMinVal = Math.min(matrix[row][col] * MinCache[row - 1][col], matrix[row][col] * MaxCache[row - 1][col]);
                    MinVal = Math.min(TempMinVal, MinVal);
                }
                if (col > 0) {
                    // TempMaxVal = current cell of possible Max value while looping
                    int TempMaxVal = Math.max(matrix[row][col] * MaxCache[row][col - 1]  , matrix[row][col] * MinCache[row][col - 1]);
                    MaxVal = Math.max(TempMaxVal, MaxVal);
                    int TempMinVal = Math.min(matrix[row][col] * MaxCache[row][col - 1] , matrix[row][col] * MinCache[row][col - 1]);
                    MinVal = Math.min(TempMinVal, MinVal);
                }
                MaxCache[row][col] = MaxVal;
                //System.out.println("MaxVal " + MaxVal);
                MinCache[row][col] = MinVal;
                //System.out.println("MinVal " + MinVal);
            }
        }

                for (int i = 0; i <MaxCache.length ; i++) {
            for (int j = 0; j < MaxCache[0].length; j++) {
                System.out.print(MaxCache[i][j] + " ");
            }

            System.out.println();
        }

        return MaxCache[MaxCache.length - 1][MaxCache[0].length - 1];
    }


    public static void main3(String[] args) {
        int[][] arr = {{-1, 2,3}, {4, 5, -6}, {7, 8, 9}};

//        for (int i = 0; i <arr.length ; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//
//            System.out.println();
//        }

        MatrixProduct myclass = new MatrixProduct();
        System.out.println(myclass.MatrixProduct(arr));


    }
}
