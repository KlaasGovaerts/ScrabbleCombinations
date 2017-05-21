package scrabbleCombinations;

import java.lang.Character;

/**
 * @author Klaas Govaerts
 * Anagram generator.
 */
public class Application {
	/**
	 * @param args The characters in your inventory (either as a single argument or different arguments)
	 * Will print the word with highest value, and a list of all valid anagrams.
	 */
	public static void main(String[] args){
		String inventoryCharactersAsString="";
		for(String argument:args){
			inventoryCharactersAsString+=argument.toLowerCase();
		}
		char[] inventoryCharacters=inventoryCharactersAsString.toCharArray();
		
		
		System.out.print("Anagrams for:");
		for(char c:inventoryCharacters){
			System.out.print(c);
		}
		System.out.println("");
		String[] foundWords=TreeElement.generateAnagrams(inventoryCharacters);
		System.out.print("Highest value: ");
		String bestWord=GeneralMethods.findBestWord(foundWords);
		System.out.print(bestWord);
		System.out.println(" ("+GeneralMethods.getScrabbleValue(bestWord)+")");
		for(String s:foundWords){
			System.out.println(s);
		}
	}
}
