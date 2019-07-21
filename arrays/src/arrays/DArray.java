package arrays;

class Main {
	public static void main(String[] args) {
		
		DArray array = new DArray();
		
		array.push(3);
		array.push(2);
		array.push(5);
		array.push(2);
		array.push(7);
		array.push(2);
		array.push(5);
		array.push(2);
		array.push(7);
		array.push(2);
		
		array.remove(2);
		array.delete(1);
		array.pop();

		System.out.println(array.toString());
		
	}
}

class DArray {

	private int[] array;
	private int capacity;
	private int size;
	
	public DArray() {
		this.size = 0;
		this.capacity = 4;
		this.array = new int[capacity];
	}

	
	public int at(int position) {
		
		if(position > this.capacity) {
			throw new IndexOutOfBoundsException();
		}
		
		return array[position];
	}
	
	public void push(int value) {
		
		if(this.isFull()) {
			this.resize(this.capacity*2);
		}
		
		array[this.size] = value;
		this.size++;
	}
	
	public void set(int position, int value) {
		
		if(this.isFull()) {
			this.resize(this.capacity*2);
		}
		
		for(int i = this.size-1; i >= position; i--) {
			this.array[i+1] = this.array[i];
		}
		
		array[position] = value;
		size++;
	}
	
	public void prepend(int value) {
		if(this.isFull()) {
			this.resize(this.capacity*2);
		}
		
		for(int i = this.size-1; i >= 0; i--) {
			this.array[i+1] = this.array[i];
		}
		
		array[0] = value;
		size++;
	}
	
	public int pop() {
		
		if(this.size <= (this.capacity/4)) {
			this.resize(this.capacity/2);
		}
		
		int value = this.array[this.size-1];
		this.array[this.size-1] = 0;
		this.size--;
		return value;
	}
	
	public void delete(int position) {
		for(int i = position; i < this.size; i++) {
			this.array[i] = this.array[i+1];
		}
		this.size--;
	}
	
	public void remove(int value) {
		for(int i = 0; i < this.size; i++) {
			if(array[i]==value) {
				this.delete(i);
			}
		}
	}
	
	public int find(int value) {
		for(int i = 0; i < this.size; i++) {
			if(array[i]==value) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int size() {
		return this.size;
	}
	
	public int capacity() {
		return this.capacity;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	private boolean isFull() {
		return this.capacity == this.size;
	}

	private void resize(int newCapacity) {
		this.capacity = newCapacity;
		int[] newArray = new int[this.capacity];
		for(int i = 0; i < this.size; i++) {
			newArray[i] = this.array[i]; 
		}
		
		this.array = newArray;
	}
	
	public String toString() {
		String display = "Array: [";
		
		for(int i = 0; i < this.size; i++) {
			
			display = display + this.array[i];
			
			if(i!=size-1) {
				display = display + ", ";	
			}
			
		}
		
		display = display + "]";
		
		display = display + " - Capacity: " + this.capacity + " - Size: " + this.size;
		
		return display;
	}
}
