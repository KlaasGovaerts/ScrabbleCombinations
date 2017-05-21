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
public class ApplicationDemo {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link scrabbleCombinations.Application#main(java.lang.String[])}.
	 * AssertEquals statements are not useful since the main method doesn't return values.
	 * This should be seen like a demonstration of the code, that will print the anagrams for "hello" to the console.
	 * To see a test of the anagram generator itself, see {@link scrabbleCombinations.TreeElementTest}.
	 */
	@Test
	public void codeDemo() {
		String[] args={"he","l","l","o"};
		Application.main(args);
	}

}
