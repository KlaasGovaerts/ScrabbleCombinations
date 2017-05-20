package scrabbleCombinations;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;

public class GeneralMethods{

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
			int average=(int) Math.ceil(((double) border1+ (double) border2)/2);
			String currentWord=list[average];
			int location=AlphabetOrder(word,currentWord);
			//Read the documentation of AlphabetOrder to see the meaning of those numbers
			switch(location){
			case 0:
				return average;
				
			case 1:
				border2=average-1;
			break;
			case 2:
				border1=average+1;
			break;
			case 3:
				isContained=true;
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
	public static int AlphabetOrder(String word1,String word2){
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
	public static char[] ArrayWithoutElement(char[] array,int index){
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
	
	public static String[] generateWordList(){
		String[] wordList=new String[0]; 
			try {
				int length=0;
				File file = new File("C:\\Users\\klaas\\workspace\\ScrabbleCombinations\\src\\scrabbleCombinations\\english-words.txt");
				//TODO relative
				Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					length++;
					sc.nextLine();
				}
				
				wordList=new String[length];
				Scanner sc2 = new Scanner(file);
				for(int i=0;i<length;i++){
					wordList[i]=sc.nextLine();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return wordList;
	}
}	

