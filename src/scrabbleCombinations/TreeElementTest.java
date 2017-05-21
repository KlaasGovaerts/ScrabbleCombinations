/**
 * 
 */
package scrabbleCombinations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * @author Klaas Govaerts
 *
 */
public class TreeElementTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link scrabbleCombinations.TreeElement#generateAnagrams(char[])}.
	 */
	@Test
	public void testGenerateAnagrams() {
		char[] charArray={'w','o','r','l','d'};
		String[] anagramsArray=TreeElement.generateAnagrams(charArray);
		String[] expectedWords={"WORLD","WORD","WOLD","DOW","LOW","OWL","ROW","WO","OW","LORD","ROD","OLD","DOR","DOL","OD","DO","OR","LO"};
		//words were verified using http://www.anagram-solver.org/?letters=world
		List<String> anagramsList=Arrays.asList(anagramsArray);
		for(String s:expectedWords){
			s=s.toLowerCase();
			assertTrue(anagramsList.contains(s));
		}
		assertFalse(anagramsList.contains("worl"));
		//http://stackoverflow.com/questions/1128723/how-can-i-test-if-an-array-contains-a-certain-value
	}

}
