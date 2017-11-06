/**
 * 
 */
package cs240_hmwk4;

/**
 * @author bjhau
 *
 */
public class SortedListDoubleLinked<T extends Comparable<? super T>> extends ListLinked<T>
		implements SortedListInterface<T> {

	private Node<T> front;
	private Node<T> back;
	private int count = 0;

	public SortedListDoubleLinked() {
		super();
	}

	@Override
	public void add(T newEntry) {
		if (!isEmpty()) {
			Node<T> temp = back;
			for (int i = 0; i < count; i++) {
				if (temp.getFLink().getData().compareTo(newEntry) < 0 && temp.getData().compareTo(newEntry) >= 0) {
					Node<T> newNode = new Node<T>(temp.getFLink(), newEntry, temp);
					count++;
				}
				temp = temp.getLink();
			}
		}
	}

	@Override
	public boolean remove(T anEntry) {
		if (!isEmpty()) {
			Node<T> temp = back;
			for (int i = 0; i < count; i++) {
				if (temp.getData() == anEntry) {
					temp.setData(null);
					temp.getFLink().setBLink(temp.getBLink());
					temp.getBLink().setFLink(temp.getFLink());
					temp.setBLink(null);
					temp.setFLink(null);
					return true;
				}
				temp = temp.getFLink();
			}
		}
		return false;
	}

	@Override
	public int getPosition(T anEntry) {
		if (!isEmpty()) {
			Node<T> temp = back;
			for (int i = 0; i < count; i++) {
				if (temp.getFLink().getData().compareTo(anEntry) < 0
						&& temp.getBLink().getData().compareTo(anEntry) > 0) {
					if (temp.getData() == anEntry) {
						return i;
					} else {
						return -i;
					}
				}
				temp = temp.getLink();
			}
		}
		return 1;
	}

	@Override
	public T remove(int givenPosition) {
		if (!isEmpty()) {
			Node<T> temp = back;
			if (givenPosition >= 0 && givenPosition < count) {
				for (int i = 0; i < givenPosition; i++) {
					temp = temp.getFLink();
				}
				T tempD = temp.getData();
				temp.setLink(temp.getFLink());
				count--;
				return tempD;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		if (!isEmpty()) {
			Node<T> temp = back.getFLink();
			for (int i = 0; i < count; i++) {
				temp = back.getFLink();
				back.setData(null);
				back.setFLink(null);
				back.setBLink(null);
				back = temp;
			}
			count = 0;
		}
	}

	@Override
	public T getEntry(int givenPosition) {
		if (!isEmpty()) {
			Node<T> temp = back;
			if (givenPosition >= 0 && givenPosition < count) {
				for (int i = 0; i < givenPosition; i++) {
					temp = temp.getFLink();
				}
				return temp.getData();
			}
		}
		return null;
	}

	@Override
	public T[] toArray() {
		if (!isEmpty()) {
			@SuppressWarnings("unchecked")
			T array[] = (T[]) new Object[count];
			Node<T> temp = back;

			for (int i = 0; i < count; i++) {
				array[i] = temp.getData();
				temp = temp.getFLink();
			}
			return array;
		}
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		if (!isEmpty()) {
			Node<T> temp = back;
			while (temp.getFLink() != null) {
				if (temp.getData() == anEntry) {
					return true;
				}
				temp = temp.getFLink();
			}
		}
		return false;
	}

	@Override
	public int getLength() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		if (count == 0 && back == front) {
			return true;
		} else {
			return false;
		}
	}
}
