/**
 * CSC 331 Programming Assignment 2
 * This is the driver class that will create instances of
 * the 3 method classes to test them.
 *
 * @author Scott Spurlock
 * @version 9/8/20
 */

//import java.util.Arrays;
import java.util.Arrays;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;

public class PA2 {
	public static Random randGen = new Random();

	public static void main(String[] args) {
		Method1 method1 = new Method1();
		Method2 method2 = new Method2();
		Method3 method3 = new Method3();

		// -----------------------------------------------------
		// Functionality Tests
		// Test each method on the provided test data, which consists of
		// 100 integers (one per line). Use k = 10. Include the output from
		// each method in your readme file.
		System.out.println("Functionality Tests...");
		
		String inputFilename = "pa2_input.txt";
		System.out.println("Opening " + inputFilename + "...");
		File inFile = new File(inputFilename);
				
		String line;
		int k = 10;

		// Loop through the file
		try (
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
				)
		{
		while ((line = reader.readLine()) != null) {
			int n =  Integer.parseInt(line);
			
			if(n>0) {
				// Making 3 identical arrays
				int[] arr1 = new int[n];
				for(int i=0; i<arr1.length; i++) {
					arr1[i] =  0 + (int)(Math.random() * ((100 - 0) + 1));
				}
				
				int arr2[] = new int[arr1.length];
				arr2 = arr1;
		        arr2[0]++;
		        
		        int arr3[] = new int[arr1.length];
		        arr3 = arr1;
		        arr3[0]++;
		        
		        
		      System.out.println("\nMethod 1 : " + Arrays.toString(method1.findTopK(arr1, k)));
		      System.out.println("Method 2 : " + Arrays.toString(method2.findTopK(arr2, k)));
		      System.out.println("Method 3 : " + Arrays.toString(method2.findTopK(arr3, k)));
		        
			}
			
		}
		}
		catch (FileNotFoundException e) {
			System.out.println("Could not locate " + inputFilename + ". Please make sure"
					+ " it is located in the root directory and try again.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Something went wrong when parsing the file.");
			e.printStackTrace();
	}

		
		
		// A. Read test data from file into array
		
		// B. Test each method with the same test data. 
		// (!! Make sure to clone the array for testing each method so the original isn't changed !!)
		
		// -----------------------------------------------------
		// Timing Tests
		// Use a random number generator to generate 10,000 elements and run 
		// the three different algorithms to find the 500 largest elements. 
		// Take the average over 10 experiments for each algorithm and compare the results.
		System.out.println();
		System.out.println("Timing Tests...");
		int K = 10;
		
		long method1AddTime = 0;
        long method2AddTime = 0;
        long method3AddTime = 0;
		
		// Loop through the file
				try (
				BufferedReader reader = new BufferedReader(new FileReader(inFile));
						)
				{
				while ((line = reader.readLine()) != null) {
					int n =  Integer.parseInt(line);
					
					if(n>0) {
						// Making 3 identical arrays
						int[] arr4 = new int[n];
						for(int i=0; i<arr4.length; i++) {
							arr4[i] =  0 + (int)(Math.random() * ((100 - 0) + 1));
						}
						
						int arr5[] = new int[arr4.length];
						arr5 = arr4;
						arr5[0]++;
				        
				        int arr6[] = new int[arr4.length];
				        arr6 = arr4;
				        arr6[0]++;
				        

				        
				        long startTime = System.nanoTime();
				        
				        //System.out.println("\nMethod 1 : " + Arrays.toString(method1.findTopK(arr4, k)));
				        method1.findTopK(arr4, K);
				        long time1 = System.nanoTime();
				        method1AddTime += (time1-startTime);
				        //System.out.println("\nMethod 1 Time: " + (time1 - startTime));
				        
				        //System.out.println("Method 2 : " + Arrays.toString(method2.findTopK(arr5, k)));
				        method2.findTopK(arr5, K);
				        long time2 = System.nanoTime();
				        method2AddTime += (time2 - time1);
				        //System.out.println("Method 2 Time: " + (time2 - time1));
				        
				        //System.out.println("Method 3 : " + Arrays.toString(method3.findTopK(arr6, k)));
				        method3.findTopK(arr6, K);
				        long time3 = System.nanoTime();
				        method3AddTime += (time3 - time2);
				        //System.out.println("Method 3 Time: " + (time3 - time2));
				        
				        
					}
					
				}
				}
				catch (FileNotFoundException e) {
					System.out.println("Could not locate " + inputFilename + ". Please make sure"
							+ " it is located in the root directory and try again.");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Something went wrong when parsing the file.");
					e.printStackTrace();
			}
				
				System.out.println("Method 1 Avg Time: " + (method1AddTime / 100));
				System.out.println("Method 2 Avg Time: " + (method2AddTime / 100));
				System.out.println("Method 3 Avg Time: " + (method3AddTime / 100));

		// Run tests to time each method on random data

		// A. For each experiment, create an array of 10,000 random integers
		// !! Make sure to clone the array for testing each method so the original isn't changed !!
		// Use System.nanoTime() to get the runtime for each method.
		// E.g., 
		//			int[] output = new int[K];
		//			long start = System.nanoTime();
		//			output = method1.findTopK(testData1, K);
		//			long end = System.nanoTime();
		//			long timeResults1 = end - start;

	} // end main
}
