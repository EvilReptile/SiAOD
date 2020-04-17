package cham.Lab_1;

public class ShellSort {

	private int[] matrix;
	
	public ShellSort(int[] matrix) {
		this.matrix = matrix;
	}
	
    public void sort (){
    	int step, i, j, tmp;
    	
    	// Выбор шага
    	for (step = matrix.length / 2; step > 0; step /= 2)
    		
    	    // Перечисление элементов, которые сортируются на определённом шаге
    		for (i = step; i < matrix.length; i++) 
    			
    		    // Перестановка элементов внутри подсписка, пока i-тый не будет отсортирован
    			for (j = i - step; j >= 0 && matrix[j] > matrix[j + step]; j -= step)
    			{
    				tmp = matrix[j];
    				matrix[j] = matrix[j + step];
    				matrix[j + step] = tmp;
    			}
    }
	
    public void getmatrix() {
    	System.out.println("Результат работы алгоритма сортировки Шелла");
    	
    	for(int i  = 0; i < matrix.length; i++)
    		System.out.println(matrix[i]);
    }
}
