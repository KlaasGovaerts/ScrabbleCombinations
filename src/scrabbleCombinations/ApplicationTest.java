/**
 * 
 */
package scrabbleCombinations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author klaas
 *
 */
public class ApplicationTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link scrabbleCombinations.Application#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
		String[] args={"h","e","l","l","o"};
		Application.main(args);
	}

}
