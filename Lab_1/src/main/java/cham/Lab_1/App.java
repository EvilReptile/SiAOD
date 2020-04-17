package cham.Lab_1;

import java.util.Arrays;
import java.util.Random;

public class App 
{    
    public static void main(String[] args) 
    {
    	
    	int[] matrix = new int[10000];
    	Random random = new Random();
    	
    	for(int i = 0; i < matrix.length; i++) {
    		matrix[i] = random.nextInt();
    	}
    	
    	int[] matrix1 = new int[10000];
    	
    	for(int i = 0; i < matrix1.length; i++) {
    		matrix1[i] = random.nextInt();
    	}
    	
    	int[] matrix2 = new int[10000];
    	
    	for(int i = 0; i < matrix2.length; i++) {
    		matrix2[i] = random.nextInt();
    	}
    	
    	System.out.println("10000");
    	QuickSort qs = new QuickSort(matrix);
    	ShellSort ss = new ShellSort(matrix);
    	
    	long start = System.nanoTime();
    	qs.sort(0, matrix.length - 1);
    	long end = System.nanoTime();
    	System.out.println("Время работы алгоритма быстрой сортировки: " + ((end - start) / 1000));
    	
    	qs = new QuickSort(matrix);
    	start = System.nanoTime();
    	qs.sort1(0, matrix.length - 1);
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма быстрой сортировки: " + ((end - start) / 1000));
    	
    	start = System.nanoTime();
    	ss.sort();
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма сортировки Шелла: " + ((end - start) / 1000));
    	
    	start = System.nanoTime();
    	Arrays.sort(matrix);
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма встроенной сортировки: " + ((end - start) / 1000));
    	
    	System.out.println("100000");
    	
    	qs = new QuickSort(matrix1);
    	ss = new ShellSort(matrix1);
    	
    	start = System.nanoTime();
    	qs.sort(0, matrix1.length - 1);
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма быстрой сортировки: " + ((end - start) / 1000));
    	
    	qs = new QuickSort(matrix1);
    	start = System.nanoTime();
    	qs.sort1(0, matrix1.length - 1);
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма быстрой сортировки: " + ((end - start) / 1000));
    	
    	
    	start = System.nanoTime();
    	ss.sort();
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма сортировки Шелла: " + ((end - start) / 1000));
    	
    	start = System.nanoTime();
    	Arrays.sort(matrix1);
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма встроенной сортировки: " + ((end - start) / 1000));
    	
    	System.out.println("1000000");
    	
    	qs = new QuickSort(matrix2);
    	ss = new ShellSort(matrix2);
    	
    	start = System.nanoTime();
    	qs.sort(0, matrix2.length - 1);
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма быстрой сортировки: " + ((end - start) / 1000));
    	
    	qs = new QuickSort(matrix2);
    	start = System.nanoTime();
    	qs.sort1(0, matrix2.length - 1);
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма быстрой сортировки: " + ((end - start) / 1000));
    	
    	
    	start = System.nanoTime();
    	ss.sort();
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма сортировки Шелла: " + ((end - start) / 1000));
    	
    	start = System.nanoTime();
    	Arrays.sort(matrix2);
    	end = System.nanoTime();
    	System.out.println("Время работы алгоритма встроенной сортировки: " + ((end - start) / 1000));
    	
    }
}
