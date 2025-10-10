// CSI2110 Fall 2015 Laboratory 1.5: Algorithm Runtimes
// ==========================================================================
// (C)opyright:
//
//   Lachlan Plant
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: lplant (Lachlan Plant)
// Email:   lplan053@uottawa.ca
// ==========================================================================
// $Log: Unique1.java,v $
// Revision 1.0  2015/09/14 01:20:40  lplant
// ==========================================================================

public class Unique1 {

	public static boolean unique1(int[] input) {
		for (int i = 0; i < input.length - 1; i++) { // iterate thru array, take i
			for (int j = i + 1; j < input.length; j++) { // iterate all elements after i, take j 
				if (input[i] == input[j]) // if there exists and element j, occuring after and element i, and both elements match, return false;
					return false;
			}
		}

		return true; // return true if there is no such case
	}
}

//* FINDS DUPLICATES */

/** WORSE CASE
 * [a, b, c, ..., a] => ensure that element a appears at the start and at the end, nowhere else
 */

 /** BEST CASE
  *  [a, a] => array of size 2 with 2 equal elements (any size is still fastest for its size)
  */ 