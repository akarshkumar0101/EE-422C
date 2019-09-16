/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package assignment1;

import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String [] args) {

		// call your test methods here
		// SortTools.isSorted() etc.

		int[] arr = new int[]{4,2,23,3,5,5,2,3,3};
		int[] arr2 = new int[]{1,2,4,4,5,6,7,8};


//		System.out.println(Arrays.toString(SortTools.insertGeneral(arr2,arr2.length,9)));

//		System.out.println(SortTools.find(arr2,arr2.length,5));
//
//		System.out.println(Arrays.toString(arr));
//		SortTools.insertSort(arr, arr.length);
//		System.out.println(Arrays.toString(arr));

		for(int i=0;i<1000;i++) {
			testSorted();
			testInsert();
			testInsertionSort();
		}


	}
	public static void testSorted(){
		int D = 10;
		int[] arr = getASortedArray(D);

		boolean pass = SortTools.isSorted(arr, D);

		arr[0] = 11;
		pass = pass && !SortTools.isSorted(arr,D);//should be false
		arr[0] = 0;

		int temp = arr[D-1];
		arr[D-1] = 0;
		pass = pass && !SortTools.isSorted(arr,D);//should be false
		arr[D-1] = temp;

		int index = (int) (random()*(D-1));
		temp = arr[index];
		arr[index] = Integer.MAX_VALUE;
		pass = pass && !SortTools.isSorted(arr,D);//should be false
		arr[index] = temp;

		pass = pass && SortTools.isSorted(arr,D);//should be true

		if(!pass){
			System.out.println("fail isSorted test");
		}
	}

	public static void testInsert(){
		int D = 10;
		int[] arr = getASortedArray(D);

		//arr is sorted

		int randomVal = (int) ((random()*100)-50);
		int[] arr2 = SortTools.insertGeneral(arr,D, randomVal);

		boolean pass = SortTools.isSorted(arr2, arr2.length);

		randomVal = (int) ((random()*100)-50);
		SortTools.insertInPlace(arr2,arr2.length-1,randomVal);
		pass = pass && SortTools.isSorted(arr2,arr2.length);

		if(!pass){
			System.out.println("fail insert test");
		}
	}

	public static void testInsertionSort(){
		int D = 10;
		int[] arr = getARandomArray(D);
		int[] arr2 = Arrays.copyOf(arr,arr.length);


		SortTools.insertSort(arr,D);

		boolean pass = SortTools.isSorted(arr,D);

		if(!pass){
			System.out.println("fail insertion sort test");
		}
	}

	private static final Random random = new Random(100);

	private static double random(){
		return random.nextDouble();
	}
	private static int[] getASortedArray(int D){
		int[] arr = new int[D];
		int rand = 0;
		for(int i=0;i<D;i++){
			arr[i] = rand;
			rand+=(int)(random()*10);
		}
		return arr;
	}
	private static int[] getARandomArray(int D){
		int[] arr = new int[D];

		for(int i=0;i<D;i++){
			int rand = (int) (random() * D);
			arr[i] = rand;
		}
		return arr;
	}
}
