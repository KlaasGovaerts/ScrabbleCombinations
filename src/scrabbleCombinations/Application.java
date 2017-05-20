package scrabbleCombinations;

import java.lang.Character;

public class Application {
	/**
	 * Will print possible words to console
	 * @param args The characters in your inventory, each as a seperate array element.
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
		for(String s:TreeElement.getFoundWords()){
			System.out.println(s);
		}
	}
}
