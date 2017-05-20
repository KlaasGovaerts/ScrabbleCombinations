package scrabbleCombinations;

public class Application {
	/**
	 * Will print possible words to console
	 * @param args The characters in your inventory
	 */
	public static void main(String[] args){
		char[] unusedCharacters=new char[args.length];
		for(int i=0;i<args.length;i++){
			unusedCharacters[i]=args[i].charAt(0);
		}
		new TreeElement("",'0',unusedCharacters);
		for(String s:TreeElement.getWordList()){
			System.out.println(s);
		}
		
	}
}
