package ru.moskalets.twoArrays;
/**
 * TwoArrays - The solution of the problem of the addition of two sorted arrays.
 * @author Igor Moskalets
 * @since 09.02.2017
 */
public class TwoArrays{
	/**
	 * The method adds two sorted array.
	 * @param first - The first sorted array.
	 * @param second - The second sorted array.
	 * @return The sum of two sorted arrays.
	 */
	public int[] sumTwoArrays(int[] first, int[] second){
		int[] result = new int[first.length + second.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (first.length > i & second.length > j){
			if (first[i] <= second[j]) {
				result[k] = first[i];
				i++;
				k++;
			} else {
				result[k] = second[j];
				j++;
				k++;
			}	
		}
		if (first.length == i ) {
			while (j != second.length){
				result[k] = second[j];
				k++;
				j++;
			}
		}
		if (second.length == j) {
			while (i != first.length) {
				result[k] = first[i];
				k++;
				i++;
			}
		}
		return result;
	}
}

