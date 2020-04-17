package cham.Lab_2;

public class Node {
	
	private int value_node; 
	
	private Node left_node = null;
	private Node rigth_node = null;
	
	public Node() {
		
	}
	
	public Node(int value) {
		value_node = value;
	}
	
	public void setLeftNode(Node node) {
		left_node = node;
	}
	
	public void setRigthNode(Node node) {
		rigth_node = node;
	}
	
	public Node getLeftNode() {
		return left_node;
	}
	
	public Node getRigthNode() {
		return rigth_node;
	}
	
	public int getValue() {
		return value_node;
	}
	
	public void add(int value) {
		//Если вес узла больше добавляемого
		if(value_node > value)
			//Если есть левый дочерний узел - рекурсивно переходим в добавление к нему
			if(left_node != null) 
				left_node.add(value);
		
			//Если нету - создаем левый дочерний узел
			else 
				left_node = new Node(value);
		
		//Если вес узла меньше или равен
		else
			//Если есть правый дочерний узел - рекурсивно переходим в добавление к нему
			if(rigth_node != null) 
				rigth_node.add(value);
		
			//Если нету - создаем правый дочерний узел
			else
				rigth_node = new Node(value);
	}
	
	public boolean search(int value) {
		//Найдено значение
		if(value_node == value)
			return true;
		
		//Рекурсивный поиск слева
		else if(value_node > value)
			if(left_node != null)
				return left_node.search(value);
		
			//Если дочернего элемента слева нет возвращаем false
			else
				return false;
		
		//Рекурсивный поиск справа
		else if(value_node < value)
			if(rigth_node != null)
				return rigth_node.search(value);
		
			//Если дочернего элемента слева нет возвращаем false
			else
				return false;
		
		else 
			return false;
	}
	
	//Метод поиска крайнего левого узла в правом дочернем объекте при удалении
	private int removeNode(boolean start, Node mother) {
		//Если есть левый узел переходим в метод левого узла
		if(left_node != null)
			return left_node.removeNode(false, this);
		
		else 
			//Если левого узла нет, но есть правый - возвращаем значение и смещаем правый узел на место материнского
			if(rigth_node != null) {
				int value = value_node;
				value_node = rigth_node.getValue();
				left_node = rigth_node.getLeftNode();
				rigth_node = rigth_node.getRigthNode();
				return value;
				
			//Если узлов нет, то проверяем первый ли это переход и производим свертку
			}else {
				if(start)
					mother.setRigthNode(null);
				
				else 
					mother.setLeftNode(null);
				
				return value_node;
			
			}
		
	}
	
	public void remove(int value, Node mother) {
		//Искомый узел найден, производим удаление
		if(value_node == value) 
			//Если оба дочерних узла есть
			if(left_node != null && rigth_node != null)
				value_node = rigth_node.removeNode(true, this);
				
			//Если есть только левый дочерний узел	
			else if(left_node != null) {
				value_node = left_node.getValue();
				rigth_node = left_node.getRigthNode();
				left_node = left_node.getLeftNode();
				
			//Если есть только правый дочерний узел	
			}else if(rigth_node != null) {
				value_node = rigth_node.getValue();
				left_node = rigth_node.getLeftNode();
				rigth_node = rigth_node.getRigthNode();
			
			//Если нет дочерних узлов	
			}else
				if(mother != null)
					if(mother.getValue() > value)
						mother.setLeftNode(null);
						
					else
						mother.setRigthNode(null);
			
		//Искомый узел находится левее точки	
		else if(value_node > value)
			left_node.remove(value, this);
			
		//Искомый узел находится правее точки
		else if(value_node < value) 
			rigth_node.remove(value, this);
		
	}
	
	//Вывод дерева по срединному методу
	public void print() {
		if(left_node != null)
			left_node.print();
		
		System.out.print(value_node + " ");
			
		if(rigth_node != null) 
			rigth_node.print();
		
		
	}
}
