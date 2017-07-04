package scrabble.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Set;

public class SimpleWordList implements WordList {

	public static void main(String[] args){
		System.out.println("Hi");
		SimpleWordList test = new SimpleWordList();
		test.initFromFile("sowpods.txt");
	}

	@Override
	public Set<String> permutations(String tileRackPart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> words(String tileRack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<String> words) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WordList initFromFile(String fileName) {
		String path = "wordlists/" + fileName;
		System.out.println(System.getProperty("user.dir"));
		WordList test = new SimpleWordList();
		try {
			FileReader fr = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return test;

	}

}
