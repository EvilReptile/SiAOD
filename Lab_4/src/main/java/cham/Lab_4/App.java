package cham.Lab_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
	
	private static Scanner scn = new Scanner(System.in);
	private static Stack stack;
	
    public static void main( String[] args ) {
    	//Получение команды от пользователя
    	String com = command();	
    	
    	//Обработка комманды пользователя
    	//Если q - завершаем работу программы
    	while(!com.equals("q")) { 
    		//Если s - производим поиск
    		if(com.equals("s")) 
    			search();
    		
    		//Ожидаем команды пользователя
    		com = command();
    	}
    	
    }
    
    //Метод запроса команды от пользователя
    private static String command() {
    	System.out.println("Завершить работу - q\nПровести проверку скобок - s");
    	String command = scn.nextLine();
    	
    	return command;
    }
    
    private static void search() {
    	//Обнуление стека
    	stack = null;
    	
    	//Получение пути файла
    	System.out.print("Введите имя анализируемого файла: ");
    	String path = scn.nextLine();
    	
    	//Создание объекта для работы с файлом и обработке исключения
    	try(FileInputStream file = new FileInputStream(path)){
    		
    		int i = -1;
    		
    		//Посимвольное считывание файла
    		while((i = file.read()) != -1)
    			//Метод анализа данныз
    			if(!analize(i))
    				return;
    		
    		//Проверка результат анализа
    		result(check());
    		
    	//Обработка исключений
    	}catch(IOException ex) {
    		System.out.println(ex.getMessage());
    	}
    	
    }
    
    //Вывод сообщения о результате работы алгоритма
    private static void result(boolean result) {
    	if(result)
    		System.out.println("Балланс скобок выдержан");
    	else
    		System.out.println("Балланс скобок не выдержан");
    }
    
    
    //Алгоритм анализа символов
    private static boolean analize(int sumbol) {
    	//Если открывающая скобка
    	if((char)sumbol == '(')
    		//И стек уже заполнен - создаем новый элемент стека
    		if(stack != null) 
    			stack = stack.addElement(sumbol);
    		
    		//И стек еще не заполнен - инициализируем стек
    		else 
    			stack = new Stack(sumbol);
    		
    	//Если закрываюшая скобка
    	else if((char)sumbol == ')')
    		//И стек не пустой
    		if(stack !=  null) 
    			//И в стеке не последний элемент - удаляем элемент
    			if(!stack.isEmpty()) 
    				stack = stack.removeElement();
    	
    			//И в стеке последний элемент - обнуляем стек
    			else 
    				stack = null;
    		//И стек пустой - выводим сообщение
    		else {
    			result(false);
    			return false;
    		}
    	
    	return true;
    }
    
    //Проверка стека после окончания работы алгоритма
    private static boolean check() {
    	return stack == null;
    }
}
