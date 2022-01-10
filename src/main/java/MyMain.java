public class MyMain {

    // Returns the number of odd numbers in mat
    public static int countOdds(int[][] mat) {
        int res = 0;
        for (int[] inner: mat) {
            for (int x : inner) {
                if(x % 2 != 0) res++;
            }
        }
        return res;
    }

    // Returns the largest value in mat
    public static int findLargest(int[][] mat) {
        int biggie = mat[0][0];
        for (int[] inner: mat) {
            for (int x : inner) {
                if(x > biggie) biggie = x;
            }
        }
        return biggie;
    }

    // Write a method that "left-shifts" each row in a 2D array.
    // This means that for each row, all the numbers should be
    // shifted to the left by 1, with wraparound (the first value
    // should wrap around to the last entry in the row)
    public static int[][] leftShift(int[][] mat) {
        int temp;
        for (int row = 0; row < mat.length; row++) {
            temp = mat[row][0];
            for (int col = 0; col < mat[0].length-1; col++) {
                mat[row][col] = mat[row][col+1];
            }
            mat[row][mat[0].length-1] = temp;
        }
        return mat;
    }

    // Creates a new array list of size arraySize x arraySize
    // where each value is each to the sum of its row and col indexes
    public static int[][] arrayBuilder(int arraySize) {
        int[][] mat = new int[arraySize][arraySize];
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[row][col] = row + col;
            }
        }
        return mat;
    }

    // Methods for the homework:

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) {
        double sum = 0.0;
        int numValues = 0;
        for (double[] inner : mat) {
            for (double x : inner) {
                numValues++;
                sum += x;
            }
        }
        return sum/numValues;
    }

    // Returns the median of the 2D array mat
    // Remember that the array is sorted!
    public static double median(double[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        if (row % 2 != 0 && col % 2 != 0) {
            return mat[row / 2][col / 2];
        }
        if (row % 2 != 0) {
            return (mat[row/2][col/2-1] + mat[row/2][col/2])/2;
        }
        return (mat[row/2-1][col-1] + mat[row/2][0]) / 2;
    }


    // Returns the mode of the 2D array mat
    // Remember that the array is sorted!
    public static double mode(double[][] mat) {
        double mode = mat[0][0];
        int count = count(mode, mat);
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if(count(mat[row][col], mat) > count) {
                    mode = mat[row][col];
                    count = count(mode, mat);
                }
            }
        }
        return mode;
    }

    public static int count(double num, double[][] mat) {
        int count = 0;
        for (double[] inner : mat) {
            for (double x : inner) {
                if(Math.abs(x-num) < 0.00001) count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        double[][] testMat = {
                {1,  2,  2,  2,  6},
                {7,  9,  10, 11, 11},
                {11, 11, 17, 18, 20} };

        System.out.println(count(6, testMat));
    }
}
