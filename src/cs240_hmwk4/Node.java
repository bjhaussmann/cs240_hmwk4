/**
 * 
 */
package cs240_hmwk4;

import cs240_hmwk3.Node;

/**
 * @author bjhau
 *
 */
public class Node <T>{
	private Node<T> link;
	private T data;
	
	public Node (Node<T> address, T data)
	{
		this.link = address;
		this.data = data;
	}

	public Node<T> getLink() {
		return link;
	}

	public void setLink(Node<T> address) {
		this.link = address;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
