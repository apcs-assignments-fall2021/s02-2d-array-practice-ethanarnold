import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    @Test
    public void testCountOdds() {
        int[][] m1 = {
                {1,  2,  4,  6},
                {7,  9,  10, 12},
                {14, 15, 17, 18},
                {22, 23, 27, 30}
        };

        int[][] m2 = {
                {42, 37, 23, -5,  9},
                {11,  6, 22, 12, 13},
                {14,  5, 17, 13, 20},
                {1,   4, 27,  7, 32},
                {21, -3,  5,  7, 99},
                {6,  2,  38,  1, 44} };

        assertEquals(7, MyMain.countOdds(m1),"The expected output for the number of odds in \nm1 = { {1,  2,  4,  6}, \n       {7,  9,  10, 12},\n       {14, 15, 17, 18},\n       {22, 23, 27, 30} }; should be: " + 7);
        assertEquals(18, MyMain.countOdds(m2), "The expected output for the mean of odds in \nm2 = { {42, 37, 23, -5,  9}, \n       {11,  6, 22, 12, 13},\n       {14,  5, 17, 13, 20},\n       {1,   4, 27,  7, 32},\n       {21, -3,  5,  7, 99},\n       {6,  2,  38,  1, 44}}; should be: " + 19.24);
    }

    @Test
    public void testFindLargest() {
        int[][] m1 = {
                {1,  2,  4,  6},
                {7,  9,  10, 12},
                {14, 15, 17, 18},
                {22, 23, 27, 30}
        };

        int[][] m2 = {
                {42, 37, 23, -5,  9},
                {11,  6, 22, 12, 13},
                {14,  5, 17, 13, 20},
                {1,   4, 27,  7, 32},
                {21, -3,  5,  7, 99},
                {6,  2,  38,  1, 44} };

        int[][] m3 = {
                {-2147483648, -2147483646},
                {-2147483645, -2147483647} };

        assertEquals(30, MyMain.findLargest(m1),"The expected output for the largest number in \nm1 = { {1,  2,  4,  6}, \n       {7,  9,  10, 12},\n       {14, 15, 17, 18},\n       {22, 23, 27, 30} }; should be: " + 30);
        assertEquals(99, MyMain.findLargest(m2), "The expected output for the largest number in \nm2 = { {42, 37, 23, -5,  9}, \n       {11,  6, 22, 12, 13},\n       {14,  5, 17, 13, 20},\n       {1,   4, 27,  7, 32},\n       {21, -3,  5,  7, 99},\n       {6,  2,  38,  1, 44}}; should be: " + 99);
        assertEquals(-2147483645, MyMain.findLargest(m3), "The expected output for the largest number in \nm3 = { {-2147483648, -2147483646}, \n       {-2147483645, -2147483647} }; should be: " + -2147483645);
    }

    public static boolean equal2DArrays(int[][] arr1, int[][] arr2) {
        if (arr1 == null || arr2 == null) {
            return false;
        }

        if (arr1.length != arr2.length && arr1[0].length != arr2[0].length) {
            return false;
        }

        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr1[0].length; col++) {
                if (arr1[row][col] != arr2[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void testLeftShift() {
        int[][] m1 = {
                {1,  2,  4,  6},
                {7,  9,  10, 12},
                {14, 15, 17, 18},
                {22, 23, 27, 30}
        };

        int[][] m1l = {
                {2,  4,  6,  1},
                {9,  10, 12, 7},
                {15, 17, 18, 14},
                {23, 27, 30, 22}
        };

        int[][] m2 = {
                {42, 37, 23, -5,  9},
                {11,  6, 22, 12, 13},
                {14,  5, 17, 13, 20},
                {1,   4, 27,  7, 32},
                {21, -3,  5,  7, 99},
                {6,  2,  38,  1, 44} };

        int[][] m2l = {
                {37, 23, -5,  9, 42},
                { 6, 22, 12, 13, 11},
                { 5, 17, 13, 20, 14},
                { 4, 27,  7, 32,  1},
                {-3,  5,  7, 99, 21},
                {2,  38,  1, 44,  6} };

        assertEquals(true, equal2DArrays(m1l, MyMain.leftShift(m1)),"The array should have looked like:\n" + Arrays.deepToString(m1l) + "\n but instead, it looked like:\n" + Arrays.deepToString(MyMain.leftShift(m1)));
        assertEquals(true, equal2DArrays(m2l, MyMain.leftShift(m2)),"The array should have looked like:\n" + Arrays.deepToString(m2l) + "\n but instead, it looked like:\n" + Arrays.deepToString(MyMain.leftShift(m2)));
    }

    @Test
    public void testArrayBuilder() {
        int[][] m1 = {
                {0, 1},
                {1, 2} };


        int[][] m2 = {
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, 4}};

        assertEquals(true, equal2DArrays(m1, MyMain.arrayBuilder(2)),"The array should have looked like:\n" + Arrays.deepToString(m1) + "\n but instead, it looked like:\n" + Arrays.deepToString(MyMain.arrayBuilder(2)));
        assertEquals(true, equal2DArrays(m2, MyMain.arrayBuilder(3)),"The array should have looked like:\n" + Arrays.deepToString(m2) + "\n but instead, it looked like:\n" + Arrays.deepToString(MyMain.arrayBuilder(3)));
    }

    @Test
    public void testMean() {
        double[][] m1 = {
            {1,  2,  4,  6},
            {7,  9,  10, 12},
            {14, 15, 17, 18},
            {22, 23, 27, 30}
        };

        double[][] m2 = { {1,  2,  4,  5,  6},
                          {7,  9,  10, 12, 13},
                          {14, 15, 17, 18, 20},
                          {22, 23, 27, 30, 32},
                          {33, 37, 38, 42, 44} };

        assertEquals(13.5625, MyMain.mean(m1), 0.1, "The expected output for the mean of double[][] \nm1 = { {1,  2,  4,  6}, \n       {7,  9,  10, 12},\n       {14, 15, 17, 18},\n       {22, 23, 27, 30} }; should be: " + 13.5625);
        assertEquals(19.24, MyMain.mean(m2), 0.1, "The expected output for the mean of double[][] \nm2 = { {1,  2,  4,  5,  6}, \n       {7,  9,  10, 12, 13},\n       {14, 15, 17, 18, 20},\n       {22, 23, 27, 30, 32},\n       {33, 37, 38, 42, 44} }; should be: " + 19.24);
    }

    @Test
    public void testMedian() {
        double[][] m1 = {
            {1,  2,  4,  6},
            {7,  9,  10, 12},
            {14, 15, 17, 18},
            {22, 23, 27, 30}
        };

        double[][] m2 = { {1,  2,  4,  5,  6},
                          {7,  9,  10, 12, 13},
                          {14, 15, 17, 18, 20},
                          {22, 23, 27, 30, 32},
                          {33, 37, 38, 42, 44} };

        double[][] m3 = { {1,  3,  4,  5},
                          {7,  9,  10, 12},
                          {14, 15, 17, 18} };

        assertEquals(13.0, MyMain.median(m1), 0.1, "The expected output for the median of double[][] \nm1 = { {1,  2,  4,  6}, \n       {7,  9,  10, 12},\n       {14, 15, 17, 18},\n       {22, 23, 27, 30} }; should be: " + 13.0);
        assertEquals(17.0, MyMain.median(m2), 0.1, "The expected output for the median of double[][] \nm2 = { {1,  2,  4,  5,  6}, \n       {7,  9,  10, 12, 13},\n       {14, 15, 17, 18, 20},\n       {22, 23, 27, 30, 32},\n       {33, 37, 38, 42, 44} }; should be: " + 17.0);
        assertEquals(9.5, MyMain.median(m3), 0.1, "The expected output for the median of double[][] \nm3 = { {1,  3,  4,  5}, \n       {7,  9,  10, 12},\n       {14, 15, 17, 18} }; should be: " + 9.5);
    }

    @Test
    public void testMode() {
        double[][] m4 = { {1,  2,  2,  2,  6},
                          {7,  9,  10, 11, 11},
                          {11, 11, 17, 18, 20} };

        assertEquals(11.0, MyMain.mode(m4), 0.1, "The expected output for the mode of double[][] \nm4 = { {1,  2,  2,  2,  6}, \n       {7,  9,  10, 11, 11},\n       {11, 11, 17, 18, 20} }; should be: " + 11.0);
        
        double[][] m5 = { {1,  1,  1,  1,  1} };
        assertEquals(1.0, MyMain.mode(m5), 0.1, "The expected output for the mode of double[][] m5 = { {1,  1,  1,  1,  1} }; should be: " + 1.0);
    }
}
