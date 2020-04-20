import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Start {

	private static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Запрашиваем команду
		System.out.println("Введите команду: f - задать путь для файла; q - завершить программу");
		String command = scn.nextLine();
		
		//Обрабатываем команду выхода
		while(!command.equals("q")) {
			//Обрабатываем команду считывания файла
			if(command.equals("f")) { 
				file();
			}
			
			
			//Запрашиваем команду пользователя
			System.out.print("Введите команду: ");
			command = scn.nextLine();
		}
	}
	
	private static void file() {
		//Получаем путь к файлу
		System.out.print("Введите путь к файлу: ");
		String path = scn.nextLine();
		//Инициализируем дек
		Deck deck = new Deck();
		
		//Инициализируем чтение файла
		try(FileInputStream fin = new FileInputStream(path)){
			int sumbol = -1;
			String number = "";
			
			//Считываем файл посимвольно
			while((sumbol = fin.read()) != -1) {
				//Инициализируем буффер числа
				if(((char)sumbol >= '0' && (char)sumbol <= '9') || ((char)sumbol == '-')) {
					number += (char)sumbol;
					
				//Инициализируем запосление дека	
				}else {
					//Если число есть
					if(!number.equals("")) {
						//Если больше нуля, то в конец дека
						if(Integer.parseInt(number) > 0) {
							deck.addEnd(Integer.parseInt(number));
							
						//Если меньше нуля, то в начало дека	
						}else if(Integer.parseInt(number) < 0){
							deck.addStart(Integer.parseInt(number));
						}
					}
					//Обнуляем буффер
					number = "";
				}
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		//Инициализируем строки с отрицательными и положительными числами
		String negative = "";
		String positive = "";
		
		//Реверсивно записываем отричательные числа в строку
		while(!deck.emptyStart()) {
			negative =  deck.removeStart() + " " + negative;
		}
		
		//Реверсивно записываем положительные числа в строку
		while(!deck.emptyEnd()) {
			positive = deck.removeEnd() + " " + positive;
		}
		
		//Выводим результат
		System.out.println("Отрицательные: " + negative);
		System.out.println("Положительные: " + positive);
	}
}
