package scrabbleCombinations;

import java.util.ArrayList;

public class TreeElement {
	private String word;
	private char[] unusedCharacters;
	private ArrayList<TreeElement> children;
	
	private static ArrayList<String> foundWords=new ArrayList<String>();
	private static String[] wordList=GeneralMethods.generateWordList();
	
	
	public TreeElement(String word, char[] unusedCharacters){
		this.word=word;
		this.unusedCharacters=unusedCharacters;
		
		for(int i=0;i<unusedCharacters.length;i++){
			String newWord=word+unusedCharacters[i];
			int result=GeneralMethods.binarySearch(wordList,word);
			
			switch(result){
			case -1:
				
			break;
			case -2:
				if(unusedCharacters.length>1){
				children.add(new TreeElement(newWord,GeneralMethods.arrayWithoutElement(unusedCharacters,i)));
				}
			break;
			default:
				foundWords.add(newWord);
				System.out.println(newWord);
				if(unusedCharacters.length>1){
				children.add(new TreeElement(newWord,GeneralMethods.arrayWithoutElement(unusedCharacters,i)));
				}
			break;
			}
		}
	}
	
	public static String[] getFoundWords(){
		String[] foundWordsArray=new String[foundWords.size()];
		return foundWords.toArray(foundWordsArray);
	}
}
