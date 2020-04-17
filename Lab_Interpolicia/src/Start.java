import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Start {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
    	InterpolSearch is = new InterpolSearch();
   
    	System.out.println("Завершить - q\nДобавить - a\nНайти - s\nУдалить - r\nВывести -p\nПровести тесты производительности - t");
    	String command = scn.next();
    	while(!command.equals("q")) {
    		if(command.equals("a")) {
    			System.out.print("Введите значение для добавления: ");
    			is.add(scn.nextInt());
    		}else if(command.equals("s")) {
    	    	System.out.print("Введите значение для поиска: ");
    	    	if(is.search(scn.nextInt()) >= 0)
    	    		System.out.println("Искомое значение найдено");
    	    	else
    	    		System.out.println("Искомое значение не найдено");
    	    	
    		}else if(command.equals("r")) {
    	    	System.out.print("Введите значение для удаления: ");
    	    	is.remove(scn.nextInt());
    	    	
    		}else if(command.equals("p")) {
    			is.print();
    			System.out.println();
    		}else if(command.equals("t")) {
    			test();
    		}
    		System.out.println("Завершить - q\nДобавить - a\nНайти - s\nУдалить - r\nВывести -p\nПровести тесты производительности - t");
        	command = scn.next();
    	}
    	
    	scn.close();
	}
	
	private static void test() {
		Random random = new Random();
		Scanner scn = new Scanner(System.in);
		InterpolSearch is = new InterpolSearch();
		
		System.out.println("Тестовый размер массива: ");
		int size = scn.nextInt();
		
		int[] testMas = new int[size];
		
		for(int i = 0; i < size; i++) {
			testMas[i] = random.nextInt(1000);
			is.add(testMas[i]);
		}
		
		Arrays.sort(testMas);
		
		System.out.print("Введите число для поиска: ");
		int value = scn.nextInt();
		
		int result;
		long start;
		long end;
		
		start = System.nanoTime();
		result = is.search(value);
    	end = System.nanoTime();
    	System.out.println("Время работы интерполяционного поиска: " + ((end - start) / 1000));
		
		
		if(result >= 0) {
			System.out.println("Число найдено");
		}else {
			System.out.println("Число не найдено");
		}
		
		start = System.nanoTime();
		result = Arrays.binarySearch(testMas, value);
		end = System.nanoTime();
		System.out.println("Время работы стандартного поиска: " + ((end - start) / 1000));
		
		
		if(result >= 0) {
			System.out.println("Число найдено");
		}else {
			System.out.println("Число не найдено");
		}
		
	}
	
}
