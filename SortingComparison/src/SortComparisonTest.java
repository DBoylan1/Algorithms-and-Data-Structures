import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Arrays;

//-------------------------------------------------------------------------
/*
 * a. Which of the sorting algorithms does the order of input have an impact on? Why?
 * 	There is a big impact on Merge sort iterative with 1000 few unique having a 10 millisecond execution time.
 * This order of input has a lot of duplicates so it takes more iterations for the algorithm to find at least two elements out of order.
 * Order of input also has an impact on insertion, quick and selection sort.
 * For selection, insertion the more out or order elements there are the more swaps that have to be made.
 * For quick sort the execution time is effected more when input is not completely random as it takes more iterations to find an element less / greater than the pivot.
 * 		
b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
	Merge sort iterative has the biggest difference in best and worse performance. It's best performance time is 0 milliseconds and worst performance time is 10 miliseconds.
	The longer execution time is when it is executing with 1000 few unique. 1000 few unique contains a lot of duplicates of numbers.
	
c. Which algorithm has the best/worst scalability, i.e., the difference in performance time based on the input size? Please consider only input files with random order for this answer.
	Best Scalability:
		The algorithm with the best scalability is selection sort. The biggest difference in performance time for the input files is 4 milliseconds.
	Worst Scalability:
		The algorithm with the worst scalability is Merge sort iterative , with a difference of 10 milliseconds in performance time.
d. Did you observe any difference between iterative and recursive implementations of merge
sort?
	Merge sort iterative executed each of the input files except 1000few unique in 0 milliseconds. It executed with 1000 few unique in 10 milliseconds.
	Merge sort recursive executed each of the input files except 1000random and 1000 nearly ordered in 0 milliseconds. It executed 1000 random in 8 milliseconds and 1000 nearly ordered in 1 millisecond.
	Merge sort iterative executed in a longer time frame on 1000 few unique because it takes more iterations to find at least two elements out of order.
	Merge sort recursive executed in a longer time frame on 1000 random because there are more sub arrays that need to be put in ordered and then merged together.
	
	
e. Which algorithm is the fastest for each of the 7 input files?
 	10 random: All the algorithms have the same running time
 	100 random: All algorithms except for selection sort have a running time of 0 milliseconds
 	1000 random: Quick sort and merge sort iterative are the fastest.
 	1000 few unique: Insertion and merge sort recursive are the fastest algorithms.
 	1000 nearly ordered: Merge sort iterative is the fastest.
 	1000 reverse ordered: Merge sort recursive and merge sort iterative are the fastest.
 	1000 sorted: All the algorithms except insertion sort are the fastest.

						Insert  Quick  Merge Recursive  Merge Iterative  Selection
10 random               0		0		0				0					0	
100 random				0		0		0				0					3
1000 random				5		0		8				0					3
1000 few unique			0		2		0				10					2
1000 nearly ordered		6		7		1				0					4
1000 reverse order		5		1		0				0					2
1000 sorted				1		0		0				0					0
 */
/**
 * Test class for SortComparison.java
 *
 * @author
 * @version HT 2019
 */
public class SortComparisonTest {

	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new SortComparison();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty() {
		// Insertion Sort Empty
		double[] testArray = {};
		double[] expectedArray = {};
		testArray = SortComparison.insertionSort(testArray);
		assertTrue(Arrays.equals(expectedArray, testArray));

		// Selection Sort Empty
		double[] testArray2 = {};
		double[] expectedArray2 = {};
		testArray2 = SortComparison.selectionSort(testArray2);
		assertTrue(Arrays.equals(expectedArray2, testArray2));

		// Quick Sort Empty
		double[] testArray3 = {};
		double[] expectedArray3 = {};
		testArray3 = SortComparison.quickSort(testArray3);
		assertTrue(Arrays.equals(expectedArray3, testArray3));

		// Merge Sort Iterative Empty
		double[] testArray4 = {};
		double[] expectedArray4 = {};
		testArray4 = SortComparison.mergeSortIterative(testArray4);
		assertTrue(Arrays.equals(expectedArray4, testArray4));

		// Merge Sort Recursive Empty
		double[] testArray5 = {};
		double[] expectedArray5 = {};
		testArray5 = SortComparison.mergeSortRecursive(testArray5);
		assertTrue(Arrays.equals(expectedArray5, testArray5));

	}

	// TODO: add more tests here. Each line of code and ech decision in
	// Collinear.java should
	// be executed at least once from at least one test.

	// ----------------------------------------------------------
	/**
	 * Main Method. Use this main method to create the experiments needed to answer
	 * the experimental performance questions of this assignment.
	 *
	 */

	@Test
	public void testInsertionSort() {
		double[] testArray = { 6.0, 7.0, 10.0, 3.0, 21.0, 5.0 };
		double[] expectedArray = { 3.0, 5.0, 6.0, 7.0, 10.0, 21.0 };
		testArray = SortComparison.insertionSort(testArray);
		assertTrue(Arrays.equals(expectedArray, testArray));

		double[] testArray2 = {};
		double[] expectedArray2 = {};
		testArray2 = SortComparison.insertionSort(testArray2);
		assertTrue(Arrays.equals(expectedArray2, testArray2));

	}

	@Test
	public void testQuickSort() {
		double[] testArray = { 6.0, 7.0, 10.0, 3.0, 21.0, 5.0 };
		double[] expectedArray = { 3.0, 5.0, 6.0, 7.0, 10.0, 21.0 };
		testArray = SortComparison.quickSort(testArray);
		assertTrue(Arrays.equals(expectedArray, testArray));
		
		double[] testArray2 = { 1 };
		double[] expectedArray2 = { 1 };
		testArray2 = SortComparison.quickSort(testArray2);
		assertTrue(Arrays.equals(expectedArray2, testArray2));
	}

	@Test
	public void testMergeSortIterative() {
		double[] testArray = { 6.0, 7.0, 10.0, 3.0, 21.0, 5.0 };
		double[] expectedArray = { 3.0, 5.0, 6.0, 7.0, 10.0, 21.0 };
		testArray = SortComparison.mergeSortIterative(testArray);
		assertTrue(Arrays.equals(expectedArray, testArray));

		double[] testArray2 = { 1 };
		double[] expectedArray2 = { 1 };
		testArray2 = SortComparison.mergeSortIterative(testArray2);
		assertTrue(Arrays.equals(expectedArray2, testArray2));

		double[] testArray3 = {};
		double[] expectedArray3 = {};
		testArray3 = SortComparison.mergeSortIterative(testArray3);
		assertTrue(Arrays.equals(expectedArray3, testArray3));

	}

	@Test
	public void testMergeSortRecursive() {
		double[] actual = { 5, 1, 6, 2, 3, 4 };
		double[] expected = { 1, 2, 3, 4, 5, 6 };
		double[] testArray = SortComparison.mergeSortRecursive(actual);
		assertTrue(Arrays.equals(expected, testArray));
	}

	@Test
	public void testSelectionSort() {
		double[] testArray = { 6.0, 7.0, 10.0, 3.0, 21.0, 5.0 };
		double[] expectedArray = { 3.0, 5.0, 6.0, 7.0, 10.0, 21.0 };
		testArray = SortComparison.selectionSort(testArray);
		assertTrue(Arrays.equals(expectedArray, testArray));
	}

	/*
	 * @Test public void testMain() { fail("Not yet implemented"); }
	 */
	/*@Test
	public void testReadFiles() {
		double[] testArray;
		double[] expectedArray = { 2377.88, 2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83,
				1518.63 };
		testArray = SortComparison.readFiles("numbers10");
		assertTrue(Arrays.equals(expectedArray, testArray));

	}*/

	public static void main(String[] args) {
		// TODO: implement this method
		// Insertion Sort
		double[] data = SortComparison.readFiles("numbers10");
		double[] data2 = SortComparison.readFiles("numbers100");
		double[] data3 = SortComparison.readFiles("numbers1000");
		double[] data4 = SortComparison.readFiles("numbers1000Duplicates");
		double[] data5 = SortComparison.readFiles("numbersNearlyOrdered1000");
		double[] data6 = SortComparison.readFiles("numbersReverse1000");
		double[] data7 = SortComparison.readFiles("numbersSorted1000");
		// numbers10
		long startTime = System.currentTimeMillis();
		data = SortComparison.insertionSort(data);
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution of insertionSort with numbers10 time in milliseconds: " + timeElapsed);
		// numbers100
		long startTime2 = System.currentTimeMillis();
		data2 = SortComparison.insertionSort(data2);
		long endTime2 = System.currentTimeMillis();
		long timeElapsed2 = endTime2 - startTime2;
		System.out.println("Execution of insertionSort with numbers100 time in milliseconds: " + timeElapsed2);
		// numbers1000
		long startTime3 = System.currentTimeMillis();
		data3 = SortComparison.insertionSort(data3);
		long endTime3 = System.currentTimeMillis();
		long timeElapsed3 = endTime3 - startTime3;
		System.out.println("Execution of insertionSort with numbers1000 time in milliseconds: " + timeElapsed3);
		// numbers1000Duplicates
		long startTime4 = System.currentTimeMillis();
		data4 = SortComparison.insertionSort(data4);
		long endTime4 = System.currentTimeMillis();
		long timeElapsed4 = endTime4 - startTime4;
		System.out
				.println("Execution of insertionSort with numbers1000Duplicates time in milliseconds: " + timeElapsed4);
		// numbersNearlyOrdered1000
		long startTime5 = System.currentTimeMillis();
		data5 = SortComparison.insertionSort(data5);
		long endTime5 = System.currentTimeMillis();
		long timeElapsed5 = endTime5 - startTime5;
		System.out.println(
				"Execution of insertionSort with numbersNearlyOrdered1000 time in milliseconds: " + timeElapsed5);
		// numbersReverse1000
		long startTime6 = System.currentTimeMillis();
		data6 = SortComparison.insertionSort(data6);
		long endTime6 = System.currentTimeMillis();
		long timeElapsed6 = endTime6 - startTime6;
		System.out.println("Execution of insertionSort with numbersReverse1000 time in milliseconds: " + timeElapsed6);
		// numbersSorted1000
		long startTime7 = System.currentTimeMillis();
		data7 = SortComparison.insertionSort(data7);
		long endTime7 = System.currentTimeMillis();
		long timeElapsed7 = endTime7 - startTime7;
		System.out.println("Execution of insertionSort with numbersSorted1000 time in milliseconds: " + timeElapsed7);

		// QuickSort
		double[] dataQ1 = SortComparison.readFiles("numbers10");
		double[] dataQ2 = SortComparison.readFiles("numbers100");
		double[] dataQ3 = SortComparison.readFiles("numbers1000");
		double[] dataQ4 = SortComparison.readFiles("numbers1000Duplicates");
		double[] dataQ5 = SortComparison.readFiles("numbersNearlyOrdered1000");
		double[] dataQ6 = SortComparison.readFiles("numbersReverse1000");
		double[] dataQ7 = SortComparison.readFiles("numbersSorted1000");
		// numbers10
		long startTimeQ1 = System.currentTimeMillis();
		dataQ1 = SortComparison.quickSort(dataQ1);
		long endTimeQ1 = System.currentTimeMillis();
		long timeElapsedQ1 = endTimeQ1 - startTimeQ1;
		System.out.println("Execution of quickSort with numbers10 time in milliseconds: " + timeElapsedQ1);
		// numbers100
		long startTimeQ2 = System.currentTimeMillis();
		dataQ2 = SortComparison.quickSort(dataQ2);
		long endTimeQ2 = System.currentTimeMillis();
		long timeElapsedQ2 = endTimeQ2 - startTimeQ2;
		System.out.println("Execution of quickSort with numbers100 time in milliseconds: " + timeElapsedQ2);
		// numbers1000
		long startTimeQ3 = System.currentTimeMillis();
		dataQ3 = SortComparison.quickSort(dataQ3);
		long endTimeQ3 = System.currentTimeMillis();
		long timeElapsedQ3 = endTimeQ3 - startTimeQ3;
		System.out.println("Execution of quickSort with numbers1000 time in milliseconds: " + timeElapsedQ3);
		// numbers1000Duplicates
		long startTimeQ4 = System.currentTimeMillis();
		dataQ4 = SortComparison.quickSort(dataQ4);
		long endTimeQ4 = System.currentTimeMillis();
		long timeElapsedQ4 = endTimeQ4 - startTimeQ4;
		System.out.println("Execution of quickSort with numbers1000Duplicates time in milliseconds: " + timeElapsedQ4);
		// numbersNearlyOrdered1000
		long startTimeQ5 = System.currentTimeMillis();
		dataQ5 = SortComparison.quickSort(data5);
		long endTimeQ5 = System.currentTimeMillis();
		long timeElapsedQ5 = endTimeQ5 - startTimeQ5;
		System.out
				.println("Execution of quickSort with numbersNearlyOrdered1000 time in milliseconds: " + timeElapsedQ5);
		// numbersReverse1000
		long startTimeQ6 = System.currentTimeMillis();
		dataQ6 = SortComparison.quickSort(dataQ6);
		long endTimeQ6 = System.currentTimeMillis();
		long timeElapsedQ6 = endTimeQ6 - startTimeQ6;
		System.out.println("Execution of quickSort with numbersReverse1000 time in milliseconds: " + timeElapsedQ6);
		// numbersSorted1000
		long startTimeQ7 = System.currentTimeMillis();
		dataQ7 = SortComparison.quickSort(dataQ7);
		long endTimeQ7 = System.currentTimeMillis();
		long timeElapsedQ7 = endTimeQ7 - startTimeQ7;
		System.out.println("Execution of quickSort with numbersSorted1000 time in milliseconds: " + timeElapsedQ7);

		// Selection Sort
		double[] dataS1 = SortComparison.readFiles("numbers10");
		double[] dataS2 = SortComparison.readFiles("numbers100");
		double[] dataS3 = SortComparison.readFiles("numbers1000");
		double[] dataS4 = SortComparison.readFiles("numbers1000Duplicates");
		double[] dataS5 = SortComparison.readFiles("numbersNearlyOrdered1000");
		double[] dataS6 = SortComparison.readFiles("numbersReverse1000");
		double[] dataS7 = SortComparison.readFiles("numbersSorted1000");
		// numbers10
		long startTimeS1 = System.currentTimeMillis();
		dataS1 = SortComparison.selectionSort(dataS1);
		long endTimeS1 = System.currentTimeMillis();
		long timeElapsedS1 = endTimeS1 - startTimeS1;
		System.out.println("Execution of selectionSort with numbers10 time in milliseconds: " + timeElapsedS1);
		// numbers100
		long startTimeS2 = System.currentTimeMillis();
		dataS2 = SortComparison.selectionSort(dataS2);
		long endTimeS2 = System.currentTimeMillis();
		long timeElapsedS2 = endTimeS2 - startTimeS2;
		System.out.println("Execution of selectionSort with numbers100 time in milliseconds: " + timeElapsedS2);
		// numbers1000
		long startTimeS3 = System.currentTimeMillis();
		dataS3 = SortComparison.selectionSort(dataS3);
		long endTimeS3 = System.currentTimeMillis();
		long timeElapsedS3 = endTimeS3 - startTimeS3;
		System.out.println("Execution of selectionSort with numbers1000 time in milliseconds: " + timeElapsedS3);
		// numbers1000Duplicates
		long startTimeS4 = System.currentTimeMillis();
		dataS4 = SortComparison.selectionSort(dataS4);
		long endTimeS4 = System.currentTimeMillis();
		long timeElapsedS4 = endTimeS4 - startTimeS4;
		System.out.println(
				"Execution of selectionSort with numbers1000Duplicates time in milliseconds: " + timeElapsedS4);
		// numbersNearlyOrdered1000
		long startTimeS5 = System.currentTimeMillis();
		dataS5 = SortComparison.selectionSort(dataS5);
		long endTimeS5 = System.currentTimeMillis();
		long timeElapsedS5 = endTimeS5 - startTimeS5;
		System.out.println(
				"Execution of selectionSort with numbersNearlyOrdered1000 time in milliseconds: " + timeElapsedS5);
		// numbersReverse1000
		long startTimeS6 = System.currentTimeMillis();
		dataS6 = SortComparison.selectionSort(dataS6);
		long endTimeS6 = System.currentTimeMillis();
		long timeElapsedS6 = endTimeS6 - startTimeS6;
		System.out.println("Execution of selectionSort with numbersReverse1000 time in milliseconds: " + timeElapsedS6);
		// numbersSorted1000
		long startTimeS7 = System.currentTimeMillis();
		dataS7 = SortComparison.selectionSort(dataS7);
		long endTimeS7 = System.currentTimeMillis();
		long timeElapsedS7 = endTimeS7 - startTimeS7;
		System.out.println("Execution of selectionSort with numbersSorted1000 time in milliseconds: " + timeElapsedS7);

		// mergeSortIterative
		double[] dataM1 = SortComparison.readFiles("numbers10");
		double[] dataM2 = SortComparison.readFiles("numbers100");
		double[] dataM3 = SortComparison.readFiles("numbers1000");
		double[] dataM4 = SortComparison.readFiles("numbers1000Duplicates");
		double[] dataM5 = SortComparison.readFiles("numbersNearlyOrdered1000");
		double[] dataM6 = SortComparison.readFiles("numbersReverse1000");
		double[] dataM7 = SortComparison.readFiles("numbersSorted1000");
		// numbers10
		long startTimeM1 = System.currentTimeMillis();
		dataM1 = SortComparison.mergeSortIterative(dataM1);
		long endTimeM1 = System.currentTimeMillis();
		long timeElapsedM1 = endTimeM1 - startTimeM1;
		System.out.println("Execution of mergeSortIterative with numbers10 time in milliseconds: " + timeElapsedM1);
		// numbers100
		long startTimeM2 = System.currentTimeMillis();
		dataM2 = SortComparison.mergeSortIterative(dataM2);
		long endTimeM2 = System.currentTimeMillis();
		long timeElapsedM2 = endTimeM2 - startTimeM2;
		System.out.println("Execution of mergeSortIterative with numbers100 time in milliseconds: " + timeElapsedM2);
		// numbers1000
		long startTimeM3 = System.currentTimeMillis();
		dataM3 = SortComparison.mergeSortIterative(dataM3);
		long endTimeM3 = System.currentTimeMillis();
		long timeElapsedM3 = endTimeM3 - startTimeM3;
		System.out.println("Execution of mergeSortIterative with numbers1000 time in milliseconds: " + timeElapsedM3);
		// numbers1000Duplicates
		long startTimeM4 = System.currentTimeMillis();
		dataM4 = SortComparison.mergeSortIterative(dataM4);
		long endTimeM4 = System.currentTimeMillis();
		long timeElapsedM4 = endTimeM4 - startTimeM4;
		System.out.println(
				"Execution of mergeSortIterative with numbers1000Duplicates time in milliseconds: " + timeElapsedM4);
		// numbersNearlyOrdered1000
		long startTimeM5 = System.currentTimeMillis();
		dataM5 = SortComparison.mergeSortIterative(dataM5);
		long endTimeM5 = System.currentTimeMillis();
		long timeElapsedM5 = endTimeM5 - startTimeM5;
		System.out.println(
				"Execution of mergeSortIterative with numbersNearlyOrdered1000 time in milliseconds: " + timeElapsedM5);
		// numbersReverse1000
		long startTimeM6 = System.currentTimeMillis();
		dataM6 = SortComparison.mergeSortIterative(dataM6);
		long endTimeM6 = System.currentTimeMillis();
		long timeElapsedM6 = endTimeM6 - startTimeM6;
		System.out.println(
				"Execution of mergeSortIterative with numbersReverse1000 time in milliseconds: " + timeElapsedM6);
		// numbersSorted1000
		long startTimeM7 = System.currentTimeMillis();
		dataM7 = SortComparison.mergeSortIterative(dataM7);
		long endTimeM7 = System.currentTimeMillis();
		long timeElapsedM7 = endTimeM7 - startTimeM7;
		System.out.println(
				"Execution of mergeSortIterative with numbersSorted1000 time in milliseconds: " + timeElapsedM7);

		// mergeSortRecursive
		double[] dataR1 = SortComparison.readFiles("numbers10");
		double[] dataR2 = SortComparison.readFiles("numbers100");
		double[] dataR3 = SortComparison.readFiles("numbers1000");
		double[] dataR4 = SortComparison.readFiles("numbers1000Duplicates");
		double[] dataR5 = SortComparison.readFiles("numbersNearlyOrdered1000");
		double[] dataR6 = SortComparison.readFiles("numbersReverse1000");
		double[] dataR7 = SortComparison.readFiles("numbersSorted1000");
		// numbers10
		long startTimeR1 = System.currentTimeMillis();
		dataR1 = SortComparison.mergeSortRecursive(dataR1);
		long endTimeR1 = System.currentTimeMillis();
		long timeElapsedR1 = endTimeR1 - startTimeR1;
		System.out.println("Execution of mergeSortRecursive with numbers10 time in milliseconds: " + timeElapsedR1);
		// numbers100
		long startTimeR2 = System.currentTimeMillis();
		dataR2 = SortComparison.mergeSortRecursive(dataR2);
		long endTimeR2 = System.currentTimeMillis();
		long timeElapsedR2 = endTimeR2 - startTimeR2;
		System.out.println("Execution of mergeSortRecursive with numbers100 time in milliseconds: " + timeElapsedR2);
		// numbers1000
		long startTimeR3 = System.currentTimeMillis();
		dataR3 = SortComparison.mergeSortRecursive(dataR3);
		long endTimeR3 = System.currentTimeMillis();
		long timeElapsedR3 = endTimeR3 - startTimeR3;
		System.out.println("Execution of mergeSortRecursive with numbers1000 time in milliseconds: " + timeElapsedR3);
		// numbers1000Duplicates
		long startTimeR4 = System.currentTimeMillis();
		dataR4 = SortComparison.mergeSortRecursive(dataR4);
		long endTimeR4 = System.currentTimeMillis();
		long timeElapsedR4 = endTimeR4 - startTimeR4;
		System.out.println(
				"Execution of mergeSortRecursive with numbers1000Duplicates time in milliseconds: " + timeElapsedR4);
		// numbersNearlyOrdered1000
		long startTimeR5 = System.currentTimeMillis();
		dataR5 = SortComparison.mergeSortRecursive(dataR5);
		long endTimeR5 = System.currentTimeMillis();
		long timeElapsedR5 = endTimeR5 - startTimeR5;
		System.out.println(
				"Execution of mergeSortRecursive with numbersNearlyOrdered1000 time in milliseconds: " + timeElapsedR5);
		// numbersReverse1000
		long startTimeR6 = System.currentTimeMillis();
		dataR6 = SortComparison.mergeSortRecursive(dataR6);
		long endTimeR6 = System.currentTimeMillis();
		long timeElapsedR6 = endTimeR6 - startTimeR6;
		System.out.println(
				"Execution of mergeSortRecursive with numbersReverse1000 time in milliseconds: " + timeElapsedR6);
		// numbersSorted1000
		long startTimeR7 = System.currentTimeMillis();
		dataR7 = SortComparison.mergeSortRecursive(dataR7);
		long endTimeR7 = System.currentTimeMillis();
		long timeElapsedR7 = endTimeR7 - startTimeR7;
		System.out.println(
				"Execution of mergeSortRecursive with numbersSorted1000 time in milliseconds: " + timeElapsedR7);
	}

}
