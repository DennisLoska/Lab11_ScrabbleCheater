package scrabble.data;

import scrabble.util.Permutation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SimpleWordList implements WordList {

    HashSet<String> words = new HashSet<>();

    @Override
    public Set<String> validWordsUsingAllTiles(String tileRackPart) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> allValidWords(String tileRack) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(String word) {
        if (word == null) {
            return false;
        } else {
            words.add(word);
            return true;
        }
    }

    @Override
    public boolean addAll(Collection<String> words) {
        if (words.size() == 0) {
            return false;
        } else {
            for (String word : words) {
                add(word);
            }
            return true;
        }
    }

    @Override
    public int size() {
        return words.size();
    }

    @Override
    public WordList initFromFile(String fileName) {
        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("This file is not found!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There is an IO error!");
        }
        return this;
    }

}
