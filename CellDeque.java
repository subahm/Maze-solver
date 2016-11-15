public class CellDeque{
	
	CellNode head;
	CellNode tail;
	int count = 0;
	
	public void CellDeque(){
		head = null;
		tail = null;
		count = 0;
	}
	
	// First cell
	public Cell first(){														
		return head.item;
	}
	
	// Last cell
	public Cell last(){                                                  	
		return tail.item; 
	}
	
	// Insert a new cell at the beginig of the queue
	public void insertFirst(Cell p){		
		
		CellNode temp = new CellNode(p);
		if (head == null && tail == null){
			head = temp;
			tail = temp;
		} 
		else{
			temp.next = head;
			head.prev = temp;
			head = head.prev;
		}
		count++;
	}
	
	// Insert a new cell at the end of the queue
	public void insertLast(Cell p){		
	
		CellNode temp = new CellNode(p);
		if (head == null && tail == null){
			head = temp;
			tail = temp;
		}
		else{
			tail.next = temp;
			temp.prev = tail;
			tail = tail.next;
		}
		count++;
	}
	
	public boolean 	isEmpty() {
		if(count==0){
			return true;
		}
		return false;
	}
	
	// Making the queue empty
	public void makeEmpty(){												
		head = null;
		tail = null;
	}
	
	// Removing the first cell in the queue
	public Cell removeFirst() throws NullPointerException {
		if(!isEmpty()){
		Cell temp = head.item;
		head = head.next;
		count--;                                           
		return temp;
		}
		
		return null;
	}
	
	// Removing the last cell in the queue
	public Cell removeLast(){
	if(!isEmpty()){
		Cell temp = tail.item;
		tail = tail.prev;
		tail.next = null;
		count--;	                                           
		return temp;
		}
		return null;
	}
	
	// Printing the queue
	public String toString(){
		String details = "";
		
		CellNode temp = head;
		
		while(temp!=null){
			
			details = details + temp.item;
			temp = temp.next;
		}
		return details;
		
	}
	
	// Main for internal testing 
	public static void main(java.lang.String[] args){	                   
		Cell a = new Cell(17,2);
		Cell b = new Cell(9,5);
		Cell c = new Cell(2,4);
		Cell d = new Cell(4,6);
		Cell e = new Cell(1,7);
		
		CellDeque path = new CellDeque();
		
		path.insertFirst(a);
		path.insertFirst(b);
		path.insertFirst(c);
		path.insertLast(e);
		path.insertFirst(d);
		System.out.println(path);
		System.out.println("First cell removed: "+path.removeFirst());
		System.out.println("Last cell removed: "+path.removeLast());
		System.out.println(path);
		System.out.println("First cell of the list: "+path.first());
		System.out.println("Last cell of the list: "+path.last());
		path.makeEmpty();
		System.out.println("Empty List: "+path);
		
	}
	
}
