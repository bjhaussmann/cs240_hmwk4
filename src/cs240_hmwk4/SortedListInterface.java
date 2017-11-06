/**
 * 
 */
package cs240_hmwk4;

/**
 * @author bjhau
 *
 */
public interface SortedListInterface<T extends Comparable<? super T>> {

	/**
	 * Adds a new entry to this sorted list in its proper order. The list's size is
	 * increased by 1.
	 * 
	 * @param newEntry
	 *            The object to be added as a new entry.
	 */
	public void add(T newEntry);

	/**
	 * Removes the first or only occurrence of a specified entry from this sorted
	 * list.
	 * 
	 * @param anEntry
	 *            The object to be removed.
	 * @return True if anEntry was located and removed; otherwise returns false.
	 */
	public boolean remove(T anEntry);

	/**
	 * Gets the position of an entry in this sorted list.
	 * 
	 * @param anEntry
	 *            The object to be found.
	 * @return The position of the first or only occurrence of anEntry if it occurs
	 *         in the list; otherwise returns the position where anEntry would occur
	 *         in the list, but as a negative integer.
	 */
	public int getPosition(T anEntry);

	/**
	 * Retrieves the entry at a given position in this list.
	 * 
	 * @param givenPosition
	 *            An integer that indicates the position of the desired entry.
	 * @return A reference to the indicated entry. Null if error is encountered.
	 */
	public T getEntry(int givenPosition);

	/**
	 * Gets the length of this list.
	 * 
	 * @return The integer number of entries currently in the list.
	 */
	public boolean contains(T anEntry);

	/**
	 * Removes the entry at a given position from this list. Entries originally at
	 * positions higher than the given position are at the next lower position
	 * within the list. List's size increased by 1.
	 * 
	 * @param givenPosition
	 *            An integer that indicates the position of the entry to be removed.
	 * @return A reference to the removed entry. Null if error is encountered.
	 */
	public T remove(int givenPosition);

	/**
	 * Removes all entries from this list.
	 */
	public void clear();

	/**
	 * Gets the length of this list.
	 * 
	 * @return The integer number of entries currently in the list.
	 */
	public int getLength();

	/**
	 * Sees whether this list is empty.
	 * 
	 * @return True if the list is empty. False otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Sees whether this list contains a given entry.
	 * 
	 * @param anEntry
	 *            The object that is the desired entry.
	 * @return True if the list contains anEntry. False otherwise.
	 */
	public T[] toArray();
}
