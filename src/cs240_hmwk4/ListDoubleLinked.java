/**
 * 
 */
package cs240_hmwk4;

/**
 * @author bjhau
 *
 */
public class ListDoubleLinked<T> implements ListInterface<T> {
	private Node<T> front;
	private Node<T> back;
	private int count = 0;
	
	public ListDoubleLinked()
	{
		front = null;
		back = front;
	}
	
	@Override
	public void add(T newEntry) {
		Node<T> newNode = new Node<T>(null, newEntry, front);
		front.setFLink(newNode);
		front = newNode;
		count ++;
	}

	@Override
	public void add(int newPosition, T newEntry) {
		Node<T> temp = back;
		for(int i =0; i < newPosition; i++)
		{
			if (temp.getFLink() != null)
			{
				temp = temp.getFLink();

			}
		}
		Node<T> newNode = new Node<T>(temp.getFLink(), newEntry, temp);
		temp.setFLink(newNode);
		count ++;
	}

	@Override
	public T remove(int givenPosition) {
		if (!isEmpty())
		{
			Node<T> temp = back;
			if (givenPosition >= 0 && givenPosition < count)
			{
				for(int i =0; i < givenPosition; i++)
				{
					temp = temp.getFLink();
				}
			T tempD = temp.getData();
			temp.setLink(temp.getFLink());
			count --;
			return tempD;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		if(!isEmpty())
		{
			Node<T> temp = back.getFLink();
			for (int i = 0; i < count; i++)
			{
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
	public T replace(int givenPosition, T newEntry) {
		if (!isEmpty())
		{
			Node<T> temp = back;
			T tempD = null;
			if (givenPosition >=0 && givenPosition < count)
			{
				for (int i = 0; i < givenPosition; i++)
				{
					temp = temp.getFLink();
				}
				tempD = temp.getData();
				temp.setData(newEntry);
				return tempD;
			}
		}
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		if (!isEmpty())
		{
			Node<T> temp = back;
			if (givenPosition >=0 && givenPosition < count)
			{
				for (int i = 0; i < givenPosition; i++)
				{
					temp = temp.getFLink();
				}
				return temp.getData();
			}
		}
		return null;
	}

	@Override
	public T[] toArray() {
		if (!isEmpty())
		{
			@SuppressWarnings("unchecked")
			T array[] = (T[]) new Object[count];
			Node<T> temp = back;
			
			for (int i = 0; i < count; i++)
			{
				array[i] = temp.getData();
				temp = temp.getFLink();
			}
			return array;
		}
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		if(!isEmpty())
		{
			Node<T> temp = back;
			while ( temp.getFLink()!= null)
			{
				if (temp.getData()==anEntry)
				{
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
		if (count == 0 && back == front)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
