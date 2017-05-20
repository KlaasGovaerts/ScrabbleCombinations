package scrabbleCombinations;

import java.util.ArrayList;

public class TreeElement {
	private String word;
	private char character;
	private char[] unusedCharacters;
	private boolean hasChildren;
	private ArrayList<TreeElement> children;
	
	
	//private boolean isWord;
	private static ArrayList<String> foundWords=new ArrayList<String>();
	//private static Tree tree=new Tree<TreeElement>();
	private static String[] wordList=GeneralMethods.generateWordList();
	
	
	public TreeElement(String word,char character, char[] unusedCharacters){
		this.word=word;
		this.character=character;
		this.unusedCharacters=unusedCharacters;
		this.foundWords=foundWords;
		
		for(int i=0;i<unusedCharacters.length;i++){
			String newWord=word+unusedCharacters[i];
			int result=GeneralMethods.binarySearch(wordList,word);
			if(unusedCharacters.length!=0){
				switch(result){
				case -1:
					
				break;
				case -2:
					children.add(new TreeElement(newWord,unusedCharacters[i],GeneralMethods.ArrayWithoutElement(unusedCharacters,i)));
				break;
				default:
					foundWords.add(newWord);
					children.add(new TreeElement(newWord,unusedCharacters[i],GeneralMethods.ArrayWithoutElement(unusedCharacters,i)));
				break;
				}
			}
		}
	}
	
	public static String[] getWordList(){
		return wordList;
	}
}
