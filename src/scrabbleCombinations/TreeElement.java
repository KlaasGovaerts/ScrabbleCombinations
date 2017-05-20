package scrabbleCombinations;

import java.util.ArrayList;

public class TreeElement {
	private String word;
	private char[] unusedCharacters;
	private ArrayList<TreeElement> children=new ArrayList<TreeElement>();
	
	private static ArrayList<String> foundWords=new ArrayList<String>();
	private static String[] wordList=GeneralMethods.generateWordList();
	
	
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
	
	public static String[] getFoundWords(){
		String[] foundWordsArray=new String[foundWords.size()];
		return foundWords.toArray(foundWordsArray);
	}
}
