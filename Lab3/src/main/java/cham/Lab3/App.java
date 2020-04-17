package cham.Lab3;

import java.util.Scanner;

public class App {
	private static Scanner scn = new Scanner(System.in);
	
    public static void main( String[] args ) {   
    	//Запрос команд работы с программой
    	String com = command();
    	
    	//Если q - заканчиваем работы
    	while(!com.equals("q")) {
    		//Если t - запускаем функцию для тестирования
    		if(com.equals("t")) 
    			test();
    		
    		//Запрос команд  работы с программой
    		com = command();
    	}
    }
    
    //Метод получения дальнейшей команды действия
    private static String command() {
    	System.out.println("Проведение тестов - t\nЗавершить работу - q");
    	return scn.nextLine();
    }
    
    
    //Метод тестирования
    private static void test() {
    	//Запрашиваем действие с программой
    	System.out.print("Производить чувствительный - h или нечувствительный поиск - l: ");
    	String search = scn.nextLine();
    	
    	//Запрашиваем строку в которой будем осуществлять поиск
    	System.out.print("Введите строку для поиска: ");
    	String text = scn.nextLine();
    	
    	//Запрашиваем слово, которое будем искать
    	System.out.print("Введите искомое слово: ");
    	String word = scn.nextLine();
    	
    	//Выравнивание регистра
    	if(search.equals("l")) {
    		text = text.toUpperCase();
    		word = word.toUpperCase();
    	}	
    	
    	//Инициализируем переменные для замера скорости работы
    	long start;
    	long end;
    	
    	System.out.println("Результат тестирования алгоритма поиcка Кнута-Морриса-Пратта");
    	
    	String line = word + "@" + text;
    	//Замер времени работы алгоритма
    	start = System.nanoTime();
    	kmpSearch(line, word.length());
    	end = System.nanoTime();
    	
    	System.out.println("Время работы алгоритма Кнута-Морриса-Пратта: " + (end - start));
    	
    	System.out.println("Результат тестирования алгоритма поиcка встроенного алгоритма поиска IndexOf");
    	
    	//Замер времени работы алгоритма
    	start = System.nanoTime();
    	standartSearchIndexOf(text, word);
    	end = System.nanoTime();
    	
    	System.out.println("Время работы встроенного алгоритма IndexOf: " + (end - start));
    	
    	System.out.println("Результат тестирования алгоритма поиcка встроенного алгоритма поиска Contains");
    	
    	//Замер времени работы алгоритма
    	start = System.nanoTime();
    	standartSearchContains(text, word);
    	end = System.nanoTime();
    	
    	System.out.println("Время работы встроенного алгоритма Contains: " + (end - start));
    	
    	System.out.println("Результат тестирования алгоритма поиcка встроенного алгоритма поиска Matcher");
    	
    	//Замер времени работы алгоритма
    	start = System.nanoTime();
    	standartSearchMatcher(text, word);
    	end = System.nanoTime();
    	
    	System.out.println("Время работы встроенного алгоритма Matcher: " + (end - start));
    	
    }
    
    //Стандартный алгоритм поиска подстроки IndexOf
    private static void standartSearchIndexOf(String text, String word) {
    	
    	//Получаем результат работы алгоритма
    	int result = text.indexOf(word) + 1;
    	
    	//Проверяем результат работы алгоритма
    	if(result > 0)
    		//Если подстрока найдена выводим сообщение и завершаем работу алгоритма
    		System.out.println("Слово найдено, индекс начала слова: " + result);
    	
    	else
    		//Если подстрока не найдена выводим сообщение
    		System.out.println("Искомое слово не найдено");
    }
    
  //Стандартный алгоритм поиска подстроки Contains
    private static void standartSearchContains(String text, String word) {
    	
    	//Получаем результат работы алгоритма
    	boolean result = text.contains(word);
    	
    	//Проверяем результат работы алгоритма
    	if(result)
    		//Если подстрока найдена выводим сообщение и завершаем работу алгоритма
    		System.out.println("Слово найдено");
    	
    	else
    		//Если подстрока не найдена выводим сообщение
    		System.out.println("Искомое слово не найдено");
    }
    
  //Стандартный алгоритм поиска подстроки
    private static void standartSearchMatcher(String text, String word) {
    	
    	//Получаем результат работы алгоритма
    	boolean result = text.matches(word);
    	
    	//Проверяем результат работы алгоритма
    	if(result)
    		//Если подстрока найдена выводим сообщение и завершаем работу алгоритма
    		System.out.println("Слово найдено");
    	
    	else
    		//Если подстрока не найдена выводим сообщение
    		System.out.println("Искомое слово не найдено");
    }
    
    //Алгоритм поиска подстроки Кнута-Морриса-Пратта
    private static void kmpSearch(String line, int word_length) {    	
    	//Массив коэффициентов для префикс-функции
    	int[] index = new int[line.length()];
    	
    	//Префик-функция
    	for(int i = 1; i < line.length(); i++) {
    		
    		//Получаем индекс префикса для предыдущего символа
    		int j = index[i-1];
    		
    		//Ищем индекс префикса для данного элемента строки
            while ((j > 0) && (line.charAt(i) != line.charAt(j)))
                j = index[j-1];  

            //Увеличиваем значение индекса префикса на единицу если нашли
            if (line.charAt(i) == line.charAt(j)) 
                j++;  
            
            //Записываем значение индекса префикла в массив
            index[i] = j;
            
            //Проверяем не найдено ли искомое слово
            if(j == word_length - 1) {
            	//Если подстрока найдена выводим сообщение и завершаем работу алгоритма
            	System.out.println("Слово найдено, индекс начала слова: " + (i - (word_length * 2 - 1) + 1));
            	return;
            }
            
    	}
    	
    	//Если подстрока не найдена выводим сообщение
    	System.out.println("Искомое слово не найдено");
    }
}
