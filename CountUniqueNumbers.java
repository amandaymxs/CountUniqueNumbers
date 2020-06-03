
/*
Question: Absolute Java 5th Edition, Page 421, Chapter 6, Programming Project Question 6.

Write a program that reads numbers from the keyboard into an array of type
int[] . You may assume that there will be 50 or fewer entries in the array. Your
program allows any number of numbers to be entered, up to 50. The output is to
be a two-column list. The first column is a list of the distinct array elements; the
second column is the count of the number of occurrences of each element. The list
should be sorted on entries in the first column, largest to smallest.
For the array
–12 3 –12 4 1 1 –12 1 –1 1 2 3 4 2 3 –12
the output should be
N Count
4 2
3 3
2 2
1 4
–1 1
–12 4
*/

// Solution without use of Arrays.sort();

import java.util.Scanner;

public class CountUniqueNumbers {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Data Entry");
		System.out.println("Enter all the numbers that are required sorting.\n");

		int size = 50;
		int file[] = new int[size];
		int data = 0;

		//////////////////////////////////////
		// DATA ENTRY
		while (data < size) {
			System.out.println(
					"Enter one number and press enter to submit the number to the data file. To exit data entry, enter a character.");
			file[data++] = input.nextInt();
			if (!input.hasNextInt()) {
				System.out.println("Exit data entry.");
				break;
			}
		}
		////////////////////////////////////
		// CREATE NEW ARRAY TO STORE DATA - PARTIAL ARRAY
		int newFile[] = new int[data];
		for (int i = 0; i < newFile.length; i++) {
			newFile[i] = file[i];
		}

		////////////////////////////////////
		// FIND RANGE
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < newFile.length; i++) {
			if (newFile[i] > max) {
				max = newFile[i];
			} else if (newFile[i] < min) {
				min = newFile[i];
			}
		}

		int range = max - min; // range is used for size of new array that counts repeating data entry points

		////////////////////////////////////
		// COUNT REPEATING DATA POINTS
		int dataCount[] = new int[range + 1]; // + 1 because array != start at [0]
		for (int i = 0; i < newFile.length; i++) {
			dataCount[newFile[i] - min] += 1; // shift everything by min to prevent out of bound if newFile[i] is
												// negative.
		}

		////////////////////////////////////
		// PRINT TABLE IN DESCENDING ORDER
		System.out.println("Number\tCount");
		for (int i = dataCount.length - 1; i >= 0; i--) {
			if (dataCount[i] != 0) {
				int shiftBack = i + min;
				System.out.println(shiftBack + "\t" + dataCount[i]);
				shiftBack = 0;
			}
		}
	}
}
