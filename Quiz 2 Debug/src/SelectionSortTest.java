import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    public void test1(){
        //run 100 different test cases
        for(int i=0; i <100;i++){

            //generate a random array of random size
            int D = (int) (Math.random()*1000);
            int[] arr = new int[D];
            for(int j=0;j<D;j++){
                arr[j] = (int) (Math.random()*1000);
            }

            //sort it with actual sorting algorithm
            int[] expected = Arrays.copyOf(arr,arr.length);
            Arrays.sort(expected);

            SelectionSort.sort(arr);
            assertArrayEquals(expected, arr);
        }
    }
}