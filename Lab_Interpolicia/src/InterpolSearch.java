
public class InterpolSearch {
	
	private int[] mas;
	
	public InterpolSearch() {
		this.mas = new int[0];
	}

	public int search(int value) {
		int min = 0;
		int max = mas.length - 1;
		int middle;
		
		while(mas[min] < value && mas[max] > value) {
			middle = Math.abs(min + (value - mas[min]) * (max - min) / (mas[max] - mas[min]));
			
			if(mas[middle] > value) 
				max = middle - 1;
				
			else if(mas[middle] < value) 
				min = middle + 1;
				
			else if(mas[middle] == value) 
				return middle;
			
		}
		
		if(mas[min] == value)
			return min;
		else if(mas[max] == value)
			return max;
		else
			return -1;
	}
	
	public void add(int value) {
		int[] newMas = new int[mas.length + 1];
		boolean val = false;
		
		if(mas.length == 0)
			newMas[0] = value;
		
		else
			for(int i = 0; i < mas.length; i++) {
				if(mas[i] > value) 
					if(!val) {
						newMas[i] = value;
						newMas[i + 1] = mas[i];
						val = true;
						
					}else {
						newMas[i + 1] = mas[i];
					}
				else 
					newMas[i] = mas[i];
				
			}
		
		if(!val) 
			newMas[newMas.length - 1] = value;
		
		mas = newMas;
	}
	
	public boolean remove(int value) {
		int[] newMas = new int[mas.length - 1];
		int position = search(value);
		
		if(position < 0)
			return false;
		
		for(int i = 0; i < position; i++)
			newMas[i] = mas[i];
		
		for(int i = position + 1; i < mas.length; i ++)
			newMas[i - 1] = mas[i];
		
		mas = newMas;
		return true;
	}
	
	public void print() {
		for(int i : mas)
			System.out.print(i + " ");
		
		System.out.println();
	}
}
