
public class Deck {
	
	private int[] deck = new int[1];
	private int middle = 0;
	
	public void addStart(int value) {
		//Перезаписываем массив с учетом нового элемента в начале и смещаем середину
		int[] newDeck = new int[deck.length + 1];
		
		newDeck[0] = value;
		
		for(int i = 0; i < deck.length; i++) 
			newDeck[i + 1] = deck[i];
		
		deck = newDeck;
		middle++;
	}
	
	public void addEnd(int value) {
		//Перезаписываем массив с учетом нового элемента в конце
		int[] newDeck = new int[deck.length + 1];
		
		newDeck[newDeck.length - 1] = value;
		
		for(int i = 0; i < deck.length; i++) 
			newDeck[i] = deck[i];
		
		deck = newDeck;
	}
	
	public int removeStart() {
		//Если начало дека не пустое
		//Перезаписываем массив без первого элемента
		if(!emptyStart()) {
			int[] newDeck = new int[deck.length - 1];
			
			int value = deck[0];
			
			for(int i = 1; i < deck.length; i++) 
				newDeck[i - 1] = deck[i];
			
			deck = newDeck;
			
			middle--;
			return value;
		}
		
		return 0;
	}
	
	public int removeEnd() {
		//Если начало дека не пустое
		//Перезаписываем массив без последнего элемента
		if(!emptyEnd()) {
			int[] newDeck = new int[deck.length - 1];
			
			int value = deck[deck.length - 1];
			
			for(int i = 0; i < deck.length - 1; i++) 
				newDeck[i] = deck[i];
			
			deck = newDeck;
			
			return value;
		}
		
		return 0;
	}
	
	//Проверка на пустоту начала дека
	public boolean emptyStart() {
		return middle == 0;
	}
	
	//Проверка на пустоту конца дека
	public boolean emptyEnd() {
		return middle == deck.length - 1;
	}
}
