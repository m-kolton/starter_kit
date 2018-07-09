package datastructure.list;

/**
 * Component of linked list that stores a value and reference to the next
 * element.
 */
public class Node {
	//TODO QUESTIONS: Czy nie powinien tutaj byc typ generyczny Node<T>?
	/**
	 * Value of object stored in CustomLinkedList
	 */
	private Object data;
	
	/**
	 * Pointer to next object
	 */
	private Node next;

	//TODO QUESTIONS: Czy potrzeba dwóch róznych konstruktorów?
	/**
	 * Constructor sets argument as an element; inserting at the beggining of list
	 * @param data
	 */
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}

	/**
	 * Constructor sets the value of element and indicates the next node; inserting in the middle of list
	 * @param data
	 * @param next
	 */
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
