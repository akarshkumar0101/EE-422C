// SortTools.java
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * Akarsh Kumar
 * ak39969
 * 16185
 * Fall 2019
 * Slip days used: 0
 */

package assignment1;

import java.util.Arrays;

public class SortTools {
	/**
	  * This method tests to see if the given array is sorted. Runs in O(n) time complexity and O(1) space complexity.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		// stub only, you write this!

		//base cases are defined
		if(x.length==0 || n==0){
			return false;
		}
		//go through each value up to (not including) index n and compare to previous value
		int prevVal = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(x[i]<prevVal) {
				//not sorted because decreasing
				return false;
			}
			prevVal = x[i];
		}

		return true;
	}

	/**
	 * This method returns the index of value v within array x. Runs in O(log(n)) time complexity and O(1) space complexity.
	 * @param x is the array
	 * @param n is the size of the input to be checked
	 * @param v is the value to be searched for within x
	 * @return index of v if v is contained within x. -1 if v is not contained within x
	 */
	public static int find(int[] x, int n, int v) {
		// stub only, you write this!

		//x[0,n) is sorted
		//following binary search runs in O(log(n))

		int index = binaryPlace(x,n,v);
		if(index>=x.length || x[index]!=v){
			return -1;
		}
        return index;
    }
	/**
	 *
	 * 	In the sorted array x, binaryPlace locates or finds the expected location of v.
	 *	If v is in x, the index returned is the index of v.
	 * 	Else, index is the location where v should be placed in order to keep the array sorted.
	 * 	Runs in O(log(n)) time complexity and O(1) space complexity.
	 * @param x the sorted array to search in
	 * @param n the number of items in the array (has to be less than or equal to x.length)
	 * @param v the number to search for
	 * @return index of v in x or the expected location of v in x
	 *
	 *
	 */
	private static int binaryPlace(int[]x, int n, int v){
		int left = 0, right = n-1;

		while(left<=right){
			int middle = (right-left)/2 + left; // same as (right+left)/2 but does not overflow integer

			if(x[middle]==v){
				//found it
				return middle;
			}

			if(x[middle]>v){
				//is too big
				right=middle-1;
			}
			else{
				//is too small
				left=middle+1;
			}
		}
		return left;
	}

	/**
	 * Copies a specific range in the from array into the to array.
	 * Runs in O(n) time complexity and O(1) space complexity.
	 * @param from the array to copy from
	 * @param fromOffset the offset to start the copy
	 * @param to the array to copy into
	 * @param toOffset the offset to paste the copy
	 * @param n the number of items to copy (the range length)
	 */
	private static void copyRange(int[] from, int fromOffset, int[] to, int toOffset, int n){
    	for(int i=0;i<n;i++){
    		to[toOffset+i] = from[fromOffset+i];
		}
	}

	/**
	 * This method returns a newly created array containing the first n elements of x, and v.
	 * Runs in O(n) time complexity and O(n) space complexity.
	 * @param x is the array
	 * @param n is the number of elements to be copied from x
	 * @param v is the value to be added to the new array
	 * @return a new array containing the first n elements of x, and v
	 */
	public static int[] insertGeneral(int[] x, int n, int v){
		// stub only, you write this!

		//if copyRange is optimized at assembly level, this algorithm has potential to be faster than O(n)

		int index = binaryPlace(x,n,v);
		boolean found = (index<x.length && x[index]==v);

		int[] y;
		if(found){
			y = Arrays.copyOfRange(x,0,n);
		}
		else{
			y = new int[n+1];
			copyRange(x,0,y,0,index);
			y[index] = v;
			copyRange(x,index,y,index+1,n-index);
		}
        return y;
    }

	/**
	 * This method inserts a value into the array and ensures it's still sorted.
	 * Runs in O(n) time complexity and O(1) space complexity.
	 * @param x is the array
	 * @param n is the number of elements in the array
	 * @param v is the value to be added
	 * @return n if v is already in x, otherwise returns n+1
	 */
	public static int insertInPlace(int[] x, int n, int v){
		// stub only, you write this!

		int index = binaryPlace(x,n,v);
		boolean found = (index<x.length && x[index]==v);

		if(found){
			return n;
		}
		else{
			shiftRight(x,index,n);
			x[index] = v;
			return n+1;
		}
    }

	/**
	 * This method sorts a given array using insertion sort
	 * Runs in O(n^2) time complexity and O(1) space complexity.
	 * @param x is the array to be sorted
	 * @param n is the number of elements of the array to be sorted
	 */
	public static void insertSort(int[] x, int n){
		int arraySize = 0;

		while(arraySize<n){
			int valToInsert =x[arraySize];

			//insert val
			int index = binaryPlace(x, arraySize, valToInsert);

			shiftRight(x,index,arraySize);
			x[index] = valToInsert;


			arraySize++;
		}
    }

	/**
	 * Shifts the section of the array specified to the right one unit
	 * Runs in O(end-start) time complexity and O(1) space complexity.
	 * @param x the array
	 * @param start inclusive index of range
	 * @param end exclusive index of range
	 */
    private static void shiftRight(int[] x, int start, int end){
		for(int i=end-1;i>=start;i--){
			//shift i to the right
			x[i+1]=x[i];
		}
	}
}
