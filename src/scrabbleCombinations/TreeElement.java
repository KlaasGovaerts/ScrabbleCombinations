package scrabbleCombinations;

import java.util.ArrayList;

/**
 * 
 * @author Klaas Govaerts
 * Either a valid word, or a word contained within another valid word.
 *
 */
public class TreeElement {
	private String word;
	private char[] unusedCharacters;
	private ArrayList<TreeElement> children=new ArrayList<TreeElement>();
	
	private static ArrayList<String> foundWords=new ArrayList<String>();
	private static String[] wordList=GeneralMethods.getWordList();
	
	/**
	 * 
	 * @param word The word of this tree element. Should be an empty String if it is the root.
	 * @param unusedCharacters The characters that weren't used yet to form the word.
	 * Will create the tree recursively. 
	 */
	public TreeElement(String word, char[] unusedCharacters){
		this.word=word;
		this.unusedCharacters=unusedCharacters;
		if(GeneralMethods.binarySearch(wordList,word)>=0){
			foundWords.add(word);
		};
		
		if(unusedCharacters.length>0){
			for(int i=0;i<unusedCharacters.length;i++){
				String newWord=word+unusedCharacters[i];
				int result=GeneralMethods.binarySearch(wordList,word);
				
				switch(result){
				case -1:
				break;
				
				case -2:
				default:
					children.add(new TreeElement(newWord,GeneralMethods.arrayWithoutElement(unusedCharacters,i)));
				}
			}
		}
		
	}
	
	/**
	 * 
	 * @return The list of words anagrams that were found. Will be empty if tree root isn't created.
	 */
	public static String[] getFoundWords(){
		String[] foundWordsArray=new String[foundWords.size()];
		return foundWords.toArray(foundWordsArray);
	}
}
