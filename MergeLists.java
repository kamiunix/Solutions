import java.util.*;

/*  
 * A class to merge two lists and delete a third list and duplicates from the result
 *
 * Example:
 * originalList = ['one', 'two', 'three'] 
 * addList = ['one', 'two', 'five', 'six] 
 * deleteList = ['two', 'five'] 
 * resultList = ['three', 'six', 'one']
 *
 * @author Samule Champagne  
 * @version 1.0 
 * @since 2020-05-20  */
public class MergeLists {
	/* This function returns a merged list of orignialList and addList and removes deleteList and
	 * duplicates from the result. The function also returns a sorted list according to the following
	 * principles: 
	 * 	- Most character count to least character count 
	 * 	- In the event of a tie, reverse alphabetical
	 * runtime complexity is O(n log(n) because of the sorting requirement from the priority queue
	 * space complexity is O(n)
	 *
	 * @param orignalList the list to modify
	 * @param addList the to add to orignalList
	 * @param deleteList the list of elements to remove from addList+originalList
	 * @result String[] returns a resultList fitting above requirements
	 */
	public static String[] mergeLists(String[] originalList, String[]  addList, String[] deleteList) {
		HashSet<String> deleteSet = new HashSet<String>(Arrays.asList(deleteList));
		HashSet<String> resultSet = new HashSet<String>();

		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() > s2.length()) {
					return -1;
				} if (s1.length() < s2.length()) {
					return 1;
				}
				return -s1.compareToIgnoreCase(s2);
			}
		});

		// add elements which are not duplicates and are not to be deleted
		for (String s : originalList) {
			if (!deleteSet.contains(s) && !resultSet.contains(s)) {
				pq.add(s);
				resultSet.add(s);
			}
		}

		// add elements which are not duplicates and are not to be deleted
		for (String s : addList) {
			if (!deleteSet.contains(s) && !resultSet.contains(s)) {
				pq.add(s);
				resultSet.add(s);
			}
		}

		String[] result = new String[pq.size()];

		// add all elements in required ordering to a String array 
		int i = 0;
		while (pq.size() > 0) {
			result[i] = pq.poll();
			i++;
		}

		return result;
	}

	/* 
	 * This function tests the mergeLists api for basic functionality
	 */
	public static void main(String[] args) {
		String[] originalList = {"one", "two", "three"};
		String[] addList = {"one", "two", "five", "six"};
		String[] deleteList = {"two", "five"};
		String[] resultList = mergeLists(originalList, addList, deleteList);

		System.out.println(Arrays.toString(resultList));
	}
}
