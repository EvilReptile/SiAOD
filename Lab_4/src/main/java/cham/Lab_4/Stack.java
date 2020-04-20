package cham.Lab_4;

public class Stack {
	private int value;
	private Stack oldElement = null;
	
	public Stack(int value) {
		this.value = value;
	}
	
	public Stack(int value, Stack oldElement) {
		this.value = value;
		this.oldElement = oldElement;
	}
	
	public Stack removeElement() {
		return oldElement;
	}
	
	public Stack addElement(int value) {
		return new Stack(value, this);
	}
	
	public int checkValue() {
		return value;
	}
	
	public boolean isEmpty() {
		if(oldElement == null)
			return true;
		else 
			return false;
	}
}
