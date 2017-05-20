package scrabbleCombinations;

import java.lang.Character;

/**
 * @author Klaas Govaerts
 * Anagram generator.
 */
public class Application {
	/**
	 * @param args The characters in your inventory, each as a seperate array element.
	 * Will print the word with highest value, and a list of all valid anagrams.
	 */
	public static void main(String[] args){
		char[] unusedCharacters=new char[args.length];
		for(int i=0;i<args.length;i++){
			unusedCharacters[i]=Character.toLowerCase(args[i].charAt(0));
		}
		System.out.print("Anagrams for:");
		for(char c:unusedCharacters){
			System.out.print(c);
		}
		System.out.println("");
		new TreeElement("",unusedCharacters);
		System.out.print("Highest value: ");
		String bestWord=GeneralMethods.findBestWord(TreeElement.getFoundWords());
		System.out.print(bestWord);
		System.out.println(" ("+GeneralMethods.getScrabbleValue(bestWord)+")");
		for(String s:TreeElement.getFoundWords()){
			System.out.println(s);
		}
	}
}
