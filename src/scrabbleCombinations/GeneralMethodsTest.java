/**
 * 
 */
package scrabbleCombinations;

import static org.junit.Assert.*;
import java.util.ArrayList;

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
	 * Test method for {@link scrabbleCombinations.GeneralMethods#getWordList()}.
	 */
	@Test
	public void testGetWordList() {
		String[] wordlist=GeneralMethods.getWordList();
		assertTrue(wordlist[98].equals("abacuses"));
	}

	/**
	 * Test method for {@link scrabbleCombinations.GeneralMethods#getScrabbleValue(java.lang.String)}.
	 */
	@Test
	public void testGetScrabbleValue() {
		assertEquals(GeneralMethods.getScrabbleValue("hello"),8);
		assertEquals(GeneralMethods.getScrabbleValue("azertyuiopqsdfghjklmwxcvbn"),87);	
		//Values were verified using http://www.dvorkin.com/scrabscor.php
	}

	/**
	 * Test method for {@link scrabbleCombinations.GeneralMethods#findBestWord(java.lang.String[])}.
	 */
	@Test
	public void testFindBestWord() {
		//https://www.randomlists.com/random-words
		String[] words={"copper","explain","truck","neat","unite","branch"};
		assertTrue(GeneralMethods.findBestWord(words).equals("explain"));
	}

}
