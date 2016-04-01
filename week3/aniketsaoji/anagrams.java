package anagrams;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class anagrams {
	
	public static ArrayList<Character> returnList(String word) {
		ArrayList<Character> wordList = new ArrayList<Character>();
		for (int i = 0; i < word.length(); i++) {
			wordList.add(word.charAt(i));
		}
		return wordList;
	}
	
	public static void printAnagram(String word) throws FileNotFoundException {

		File file = new File("wordsEn.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String comparedWord = scan.nextLine();
			ArrayList<Character> comparedList = returnList(word);
			if (word.length() != comparedWord.length()) 
				continue;
			else {
				for (Character c : comparedWord.toCharArray()) {
					comparedList.remove(c);
				}
				if (comparedList.isEmpty()) {
					System.out.println(comparedWord);
				}
			}
		}
	}
	
	public static void main(String [] args) throws FileNotFoundException {
		String word = args[0];
		printAnagram(word);
		
		
	}

}
