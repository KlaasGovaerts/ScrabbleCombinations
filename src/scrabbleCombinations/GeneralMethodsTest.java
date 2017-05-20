/**
 * 
 */
package scrabbleCombinations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Klaas Govaerts
 *
 */
public class GeneralMethodsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link scrabbleCombinations.GeneralMethods#binarySearch(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testBinarySearch() {
		assertEquals(1/2.0,0.5,0.000001);
		String[] words={"abaisse","abaissed","abaka","abakas","abalation","abalienate","abalienated","abalienating","abalienation","abalone","abalones","abamp","abampere","abamperes","abamps","aband","abandon","abandonable","abandoned","abandonedly","abandonee","abandoner","abandoners"};
		assertEquals(GeneralMethods.binarySearch(words,"abakas"),3);
		assertEquals(GeneralMethods.binarySearch(words,"abalienating"),7);
		assertEquals(GeneralMethods.binarySearch(words,"hjdfgkjdsf"),-1);
		assertEquals(GeneralMethods.binarySearch(words,"abalien"),-2);
		assertEquals(GeneralMethods.binarySearch(words,"abandonabl"),-2);
		assertEquals(GeneralMethods.binarySearch(words,"abandone"),-2);
		assertEquals(GeneralMethods.binarySearch(words,"abalatio"),-2);
	}

	/**
	 * Test method for {@link scrabbleCombinations.GeneralMethods#AlphabetOrder(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAlphabetOrder() {
		assertEquals(GeneralMethods.alphabetOrder("helloworld","helloworld"),0);
		assertEquals(GeneralMethods.alphabetOrder("ape","banana"),1);
		assertEquals(GeneralMethods.alphabetOrder("banana","ape"),2);
		assertEquals(GeneralMethods.alphabetOrder("key","keyboard"),3);
		assertEquals(GeneralMethods.alphabetOrder("mousepad","mouse"),4);
		//Read the documentation of AlphabetOrder see the meaning of these numbers.
	}

	/**
	 * Test method for {@link scrabbleCombinations.GeneralMethods#ArrayWithoutElement(char[], int)}.
	 */
	@Test
	public void testArrayWithoutElement() {
		char[] array={'0','1','2','3','4','5'};
		char[] array2=GeneralMethods.arrayWithoutElement(array,3);
		char[] expectedArray={'0','1','2','4','5'};
		for(int i=0;i<expectedArray.length;i++){
			assertEquals(array2[i],expectedArray[i]);
		}
	}

	/**
	 * Test method for {@link scrabbleCombinations.GeneralMethods#generateWordList()}.
	 */
	@Test
	public void testGenerateWordList() {
		String[] wordlist=GeneralMethods.generateWordList();
		assertTrue(wordlist[98].equals("abacuses"));
	}

}
