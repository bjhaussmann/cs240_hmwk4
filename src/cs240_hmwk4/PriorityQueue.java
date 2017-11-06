/**
 * 
 */
package cs240_hmwk4;

/**
 * @author bjhau
 * @param <T>
 *
 */
public class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {

	private Node<T> front;
	private Node<T> back;

	public PriorityQueue() {
		front = null;
		back = front;
	}

	/**
	 * Adds a new entry to this priority queue.
	 * 
	 * @param newEntry
	 *            An object to be added.
	 */
	@Override
	public void add(T newEntry) {
		Node<T> current = back;
		boolean placed = false;
		while (current.getLink() != null && placed == false) {
			if (newEntry.compareTo(current.getData()) < 0 && newEntry.compareTo(current.getLink().getData()) > 0) {
				Node<T> newNode = new Node<T>(current.getLink(), newEntry);
				current.setLink(newNode);
				placed = true;
			}
			if (newEntry.compareTo(current.getData()) == 0) {
				Node<T> newNode = new Node<T>(current.getLink(), newEntry);
				current.setLink(newNode);
				placed = true;
			}
			if (placed == false) {
				back = new Node<T>(back.getLink(), newEntry);
			}
		}
	}

	/**
	 * Removes and returns the entry having the highest priority.
	 * 
	 * @return Either the object having the highest priority or, if the priority
	 *         queue is empty before the operation, null.
	 */
	@Override
	public T remove() {
		if (isEmpty()) {
			return null;
		} else {
			T temp = front.getData();
			Node<T> nextFront = back;
			while (nextFront.getLink() != front) {
				nextFront = nextFront.getLink();
			}
			front.setData(null);
			nextFront.setLink(null);

			return temp;
		}
	}

	/**
	 * Retrieves the entry having the highest priority.
	 * 
	 * @return Either the object having the highest priority or, if the priority
	 *         queue is empty, null.
	 */
	@Override
	public T peek() {
		if (isEmpty())
		{
			return null;
		}
		else {
			return front.getData();
		}
	}

	/**
	 * Detects whether this priority queue is empty.
	 * 
	 * @return True if the priority queue is empty, or false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if ( back.getLink() == front)
		{
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Gets the size of this priority queue.
	 * 
	 * @return The number of entries currently in the priority queue.
	 */
	@Override
	public int getSize() {
		Node<T> current = back;
		int counter = 0;
		while (current.getLink() != front)
		{
			current = current.getLink();
			counter++;
		}
		return counter;
	}

	/** Removes all entries from this priority queue. */
	@Override
	public void clear() {
		Node<T> current = back;
		Node<T> next = current;
		while ( current.getLink() != null)
		{
			next = current.getLink();
			current.setData(null);
			current.setLink(null);
			current = next;
		}
		back = front;
	}
}
