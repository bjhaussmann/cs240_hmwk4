/**
 * 
 */
package cs240_hmwk4;

/**
 * @author bjhau
 *
 */
public class ListFixedSize<T> implements ListInterface<T> {

	protected T list[];
	protected static int defaultSize = 10;
	protected int count = 0;

	public ListFixedSize() {
		this(defaultSize);
	}

	public ListFixedSize(int size) {
		@SuppressWarnings("unchecked")
		T temp[] = (T[]) new Object[size];
		list = temp;
	}

	@Override
	public void add(T newEntry) {
		list[count] = newEntry;
		count++;
	}

	@Override
	public void add(int newPosition, T newEntry) {
		if (newPosition < count && newPosition >= 0){
			for (int i = count; i < newPosition; i--) {
				list[i] = list[i - 1];
			}
			list[newPosition] = newEntry;
			count++;
		} else if (newPosition >= count && newPosition < list.length) {
			list[count] = newEntry;
			count++;
		}
		else if(newPosition < 0 || newPosition > list.length)
		{
			throw new IndexOutOfBoundsException();
		}
		
	}

	@Override
	public T remove(int givenPosition) {
		if (givenPosition <= list.length && !isEmpty())
		{
			T temp = list[givenPosition];
	
			for (int i = count - 1; i > givenPosition; i--) {
				list[i - 1] = list[i];
			}
			count --;
			
			return temp;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void clear() {
		if (!isEmpty())
		{
			for (int i = 0; i < count; i++)
			{
				list[i] = null;
			}
			count = 0;
		}
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if(givenPosition < list.length && !isEmpty())
		{
			T temp = list[givenPosition];
			list[givenPosition] = newEntry;
			return temp;
		}
		else
		{
			return null;
		}
	}

	@Override
	public T getEntry(int givenPosition) {
		if ( !isEmpty())
		{
			return list[givenPosition];
		}
		else
		{
			return null;
		}
	}

	@Override
	public T[] toArray() {
		if(!isEmpty())
		{
			@SuppressWarnings("unchecked")
			T array[] = (T[]) new Object[count];
			for (int i = 0; i < count; i ++)
			{
				array[i] = list[i];
			}
			return array;
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean contains(T anEntry) {
		if (!isEmpty())
		{
			int counter = 0;
			while (counter < count)
			{
				if(list[counter] == anEntry)
				{
					return true;
				}
				counter ++;
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
		if (count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
