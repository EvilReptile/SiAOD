package cham.Lab_1;

public class QuickSort {
	
	private int[] matrix;
	
	public QuickSort(int[] matrix) {
		this.matrix = matrix;
	}
	
	private int partition(int begin, int end) {  
	    int pivot = end;

	    int counter = begin;
	    for (int i = begin; i < end; i++) {
	        if (matrix[i] < matrix[pivot]) {
	            int temp = matrix[counter];
	            matrix[counter] = matrix[i];
	            matrix[i] = temp;
	            counter++;
	        }
	    }
	    int temp = matrix[pivot];
	    matrix[pivot] = matrix[counter];
	    matrix[counter] = temp;

	    return counter;
	}

	public void sort(int begin, int end) {  
	    if (end <= begin) return;
	    int pivot = partition(begin, end);
	    sort(begin, pivot-1);
	    sort(pivot+1, end);
	}
	
	public void sort1(int start, int end) {
		// завершить выполнение если длина массива равна 0
		if (matrix.length == 0)
			return;
	 
		// завершить выполнение если уже нечего делить
		if (start >= end)
	        return;
	 
		// выбрать опорный элемент
		int middle = start + (end - start) / 2;
	 
	    // разделить на подмассивы, который больше и меньше опорного элемента
		int left = start, right = end;
	    while (left <= right) {
	    	// сдвиг вправо левой части подмассива
	    	while (matrix[left] < matrix[middle]) {
	    		left++;
	    	}
	 
	    	// сдвиг влево правой части подмассива
	        while (matrix[right] > matrix[middle]) {
	          	right--;
	        }
	 
	        // меняем местами элементы массива
	        if (left <= right) {
	        	int temp = matrix[left];
	            matrix[left] = matrix[right];
	            matrix[right] = temp;
	            left++;
	            right--;
	        }
	    }
	 
	    // вызов рекурсии для сортировки левой и правой части
	    if (start < right)
	    	sort(start, right);
	 
	    if (end > left)
	    	sort(left, end);
	   
	}
	
	public void getMatrix() {
		System.out.println("Результат работы алгоритма быстрой сортировки");
		
		for(int i = 0; i < matrix.length; i++)
			System.out.println(matrix[i]);
	}
	
}
