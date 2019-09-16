
public final class SelectionSort {
	
	/**
	 * Implementation of selection sort algorithm.
	 * 
	 * @param x The integer array to sort in place
	 */
	public static void sort(int[] x) {		
		for (int i = 0; i < x.length - 1; i++) {
			// Assume min is index of smallest value in array
			int minI = i;
			
			// Check all other values in array to find smallest value
			for (int j = i + 1; j < x.length; j++) {
				if (x[j] < x[minI]) {
					minI = j;
				}
			}
			
			// Swap smallest value to its correct location
			swap(x, i, minI);
		}
	}
	
	/**
	 * Swap two values in place using XOR algorithm.
	 * 
	 * @param x The array of values
	 * @param a Index of first value in x
	 * @param b Index of second value in x
	 */
	private static void swap(int[] x, int a, int b) {
		int temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	}
	//a: a^(a^b)=b
	//b: b^(a^b)=a
}
