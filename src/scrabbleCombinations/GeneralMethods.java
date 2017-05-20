package scrabbleCombinations;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class GeneralMethods{
	private static String[] wordList;
	/**
	 * 
	 * @param list	A list of words (should be sorted alphabetically)
	 * @param word The word you want to find
	 * @return The location of the word (if found)
	 * @return -1 if word is not found
	 * @return -2 if word is not found AND the word is contained within another word
	 */
	
	public static int binarySearch(String[] list,String word){
		int border1=0;
		int border2=list.length-1;
		boolean ready=false;
		boolean isContained=false;
		
		while(!ready){
			int average=(int) Math.ceil((border1+border2)/2.0);
			String currentWord=list[average];
			int location=alphabetOrder(word,currentWord);
			//Read the documentation of AlphabetOrder to see the meaning of those numbers
			switch(location){
			case 0:
				return average;
				
			case 3:
				isContained=true;
			case 1:
				border2=average-1;
			break;
			
			case 4:
			case 2:
				border1=average+1;
			break;
			
			}
			
			if(border1>border2){
				ready=true;
			}
		}
		
		if(isContained){
			return -2;
		}
		return -1;
		//TODO empty list, border1=border2 use 3 & 4
	}
	
	/**
	 * 
	 * @return 0 if exactly same 
	 * @return 1 if word1 comes first
	 * @return 2 if word2 comes first
	 * @return 3 if word1 comes first AND is contained within word2;
	 * @return 4 if word2 comes first AND is contained within word1;
	 */
	public static int alphabetOrder(String word1,String word2){
		int minSize;
		
		if(word1.equals(word2)){
			return 0;
		}
		
		
		if(word1.length()<word2.length()){
			minSize=word1.length();
		} else {
			minSize=word2.length();
		}
		
		for(int i=0;i<minSize;i++){
			char char1=word1.charAt(i);
			char char2=word2.charAt(i);
				if(char1!=char2){
					if(char1<char2){
						return 1;
					} else {
						return 2;
				}
			}
		}
		if(word1.length()<word2.length()){
			return 3;
		} else {
			return 4;
		}
	}
	
	/**
	 * 
	 * @param Array
	 * @param index
	 * @return Copy of the array but without the element at the given index
	 */
	public static char[] arrayWithoutElement(char[] array,int index){
		char[] newArray=new char[array.length-1];
		for(int i=0;i<index;i++){
			newArray[i]=array[i];
		}
		for(int i=index;i<newArray.length;i++){
			newArray[i]=array[i+1];
		}
		return newArray;
	}
	//TODO null exception
	
	/*
	Source used:
	http://stackoverflow.com/questions/14209085/how-to-define-a-relative-path-in-java
	*/
	
	public static String[] generateWordList(){
		ArrayList<String> wordList=new ArrayList<String>();
			try {
				String filePath = new File("").getAbsolutePath();
				//System.out.println(filePath);
				filePath+="\\words.txt";
				File file = new File(filePath);
				Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					wordList.add(sc.nextLine());
				}
				//wordList.add(sc.next());
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			String[] wordlist2=new String[wordList.size()];
			for(int i=0;i<wordList.size();i++){
				wordlist2[i]=wordList.get(i);
			}
			return wordlist2;
	}
	
	public static String[] getWordList(){
		if(wordList==null){
			wordList=generateWordList();
		}
		return wordList;
	}
	
	public static int getScrabbleValue(String word){
		int value=0;
		char[] charArray=word.toCharArray();
		for(char c:charArray){
				value+=GeneralMethods.getLetterValue(c);
			}
		return value;
		}
	
	private static int getLetterValue(char c){
		String[] lettersByScore={"","eaionrtlsu","dg","bcmp","fhvwy","k","","","jx","","qz"};
		for(int i=0;i<lettersByScore.length;i++){
			if(lettersByScore[i].contains(""+c)){
				return i;
			}
		}
		return 0;
	}
	
	public static String findBestWord(String[] foundWords){
		int highestValue=0;
		String bestWord="";
		for (String s:foundWords){
			int currentValue=GeneralMethods.getScrabbleValue(s);
			if(currentValue>highestValue){
				highestValue=currentValue;
				bestWord=s;
			}
		}
		return bestWord;
	}
}
