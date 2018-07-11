package datastructure.list;

/**
 * Component of linked list that stores a value and reference to the next
 * element.
 */
public class Node {

	/**
	 * Value of object stored in CustomLinkedList
	 */
	private Object data;

	/**
	 * Pointer to next object
	 */
	private Node next;

	/**
	 * Constructor sets argument as an element; inserting at the beginning of
	 * list
	 * 
	 * @param data
	 *            object to be stored id node
	 */
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}

	/**
	 * Constructor sets the value of element and indicates the next node;
	 * inserting in the middle of list
	 * 
	 * @param data
	 *            object to be stored id node
	 * @param next
	 *            pointer to next node
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
