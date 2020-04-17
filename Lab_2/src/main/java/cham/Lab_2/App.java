package cham.Lab_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
	private static Scanner scn = new Scanner(System.in);
	
    public static void main(String[] args) {
    	
    	//Запрос размера массива
    	System.out.print("Введите размер массива для поиска: ");
    	int score = scn.nextInt();
    	
    	//Запрос данных массива
    	System.out.println("Введите массив данных:");
    	int data[] = new int[score];
    	for(int i = 0; i < score; i++)
    		data[i] = scn.nextInt();

    	//Создание дерева бинарного поиска
    	Node start_node = new Node(data[0]);
    	
    	for(int i = 1; i < data.length; i++)
    		start_node.add(data[i]);
   
    	//Запрос команды работы с алгоритмом бинарного поиска
    	System.out.println("Завершить - q\nДобавить - a\nНайти - s\nУдалить - r\nВывести -p\nПровести тесты производительности - t");
    	String command = scn.next();
    	while(!command.equals("q")) {
    		
    		//Вызов метода добавления
    		if(command.equals("a")) {
    			System.out.print("Введите значение для добавления: ");
    			start_node.add(scn.nextInt());
    			
    		//Вызов метода поиска	
    		}else if(command.equals("s")) {
    	    	System.out.print("Введите значение для поиска: ");
    	    	if(start_node.search(scn.nextInt()))
    	    		System.out.println("Искомое значение найдено");
    	    	else
    	    		System.out.println("Искомое значение не найдено");
    	    	
    	    //Вызов метода удаления	
    		}else if(command.equals("r")) {
    	    	System.out.print("Введите значение для удаления: ");
    	    	start_node.remove(scn.nextInt(), null);
    	    	
    	    //Вызов метода печати бинарного дерева	
    		}else if(command.equals("p")) {
    			start_node.print();
    			System.out.println();
    			
    		//Вызов метода тестирования производительности	
    		}else if(command.equals("t")) 
    			test();
    		
    		//Повторный запрос команды
        	System.out.println("Завершить - q\nДобавить - a\nНайти - s\nУдалить - r\nВывести -p\nПровести тесты производительности - t");
        	command = scn.next();
    	}
    	
    }
    
    private static void test() {
		Random random = new Random();
		
		//Запрос размера тестового массива
		System.out.println("Тестовый размер массива: ");
		int size = scn.nextInt();
		
		int[] testMas = new int[size];
		
		//Создание массива рандомных значений
		for(int i = 0; i < size; i++) 
			testMas[i] = random.nextInt(100000);
		
		//Создание бинарного дерева поиска
		Node node = new Node(testMas[0]);
    	
    	for(int i = 1; i < testMas.length; i++)
    		node.add(testMas[i]);
		
    	//Сортировка массива для встроенного метода поиска
		Arrays.sort(testMas);
		
		//Запрос искомого числа
		System.out.print("Введите число для поиска: ");
		int value = scn.nextInt();
		
		int result;
		boolean resul;
		long start;
		long end;
		
		//Время теста самописного метода
		start = System.nanoTime();
		resul = node.search(value);
    	end = System.nanoTime();
    	System.out.println("Время работы поиска бинарного дерева: " + ((end - start) / 1000));
		
		//Результат поиска самописного метода
		if(resul) 
			System.out.println("Число найдено");
		else 
			System.out.println("Число не найдено");
		
		//Время теста встроенного метода
		start = System.nanoTime();
		result = Arrays.binarySearch(testMas, value);
		end = System.nanoTime();
		System.out.println("Время работы стандартного поиска: " + ((end - start) / 1000));
		
		//Результат поиска встроенного метода
		if(result >= 0)
			System.out.println("Число найдено");
		else 
			System.out.println("Число не найдено");
		
	}
        
}
