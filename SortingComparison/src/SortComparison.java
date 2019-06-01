// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Dearbhla Boylan ID: 17330661
 * @version HT 2019
 */
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {

		// todo: implement the sort
		if (a == null) {
			return null;
		}
		double temp;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		return a;
	}// end insertionsort

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double a[]) {

		// todo: implement the sort
		quickSortRecursive(a, 0, a.length - 1);
		return a;

	}// end quicksort

	static void quickSortRecursive(double a[], int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int pivotPos = quickSortPartition(a, lo, hi);
		quickSortRecursive(a, lo, pivotPos - 1);
		quickSortRecursive(a, pivotPos + 1, hi);

	}

	static int quickSortPartition(double[] a, int lo, int hi) {
		int x = lo;
		int y = hi + 1;
		Double pivot = a[lo];
		while (true) {
			while (Double.compare((a[++x]), pivot) < 0) {
				if (x == hi)
					break;
			}
			while ((pivot.compareTo(a[--y]) < 0)) {
				if (y == lo)
					break;
			}
			if (x >= y)
				break;
			double temp = a[x];
			a[x] = a[y];
			a[y] = temp;
		}
		a[lo] = a[y];
		a[y] = pivot;
		return y;
	}

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSortIterative(double a[]) {

		// todo: implement the sort

		if (a == null) {
			return null;
		}

		if (a.length > 1) {
			int mid = a.length / 2;

			// Split left part
			double[] left = new double[mid];
			for (int i = 0; i < mid; i++) {
				left[i] = a[i];
			}

			// Split right part
			double[] right = new double[a.length - mid];
			for (int i = mid; i < a.length; i++) {
				right[i - mid] = a[i];
			}
			mergeSortIterative(left);
			mergeSortIterative(right);

			int i = 0;
			int j = 0;
			int k = 0;

			// Merge left and right arrays
			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					a[k] = left[i];
					i++;
				} else {
					a[k] = right[j];
					j++;
				}
				k++;
			}
			// Collect remaining elements
			while (i < left.length) {
				a[k] = left[i];
				i++;
				k++;
			}
			while (j < right.length) {
				a[k] = right[j];
				j++;
				k++;
			}

		}
		return a;

	}// end mergesortIterative

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	static double[] mergeSortRecursive(double a[]) {

		// todo: implement the sort
		double[] aux = new double[a.length];
		recursiveMethod(a, aux, 0, a.length - 1);
		return a;

	}// end mergeSortRecursive

	static void recursiveMethod(double a[], double aux[], int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - (lo)) / 2;
		recursiveMethod(a, aux, lo, mid);
		recursiveMethod(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);

	}

	static void merge(double a[], double aux[], int lo, int mid, int hi) {
		// Copy both parts into the helper array
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}

		int i = lo;
		int j = mid + 1;
		int k = lo;
		// Copy the smaller values from either side back to array a
		while (i <= mid && j <= hi) {
			if (aux[i] <= aux[j]) {
				a[k] = aux[i];
				i++;
			} else {
				a[k] = aux[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			// Copy the rest of the left side into array a
			a[k] = aux[i];
			k++;
			i++;
		}

	}

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {

		// todo: implement the sort
		int size = a.length;

		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			double temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
		return a;

	}// end selectionsort

	public static void main(String[] args) throws InterruptedException {

		// todo: do experiments as per assignment instructions

	}

	public static double[] readFiles(String file) {
		try {
			File f = new File(file);
			Scanner scanner = new Scanner(f);
			int counter = 0;
			while (scanner.hasNextDouble()) {
				counter++;
				scanner.nextDouble();
			}
			double[] numbers = new double[counter];
			Scanner scanner2 = new Scanner(f);

			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = scanner2.nextDouble();
			}

			return numbers;
		} catch (Exception e) {
			return null;
		}
	}

}// end class
