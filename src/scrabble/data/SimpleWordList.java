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

    private HashSet<String> scrabbleWords = new HashSet<>();

    @Override
    public Set<String> validWordsUsingAllTiles(String tileRackPart) {

        HashSet<String> foundPerms = new HashSet<>();

        Permutation permToBeChecked = new Permutation(tileRackPart);
        String permToBeCheckedString = permToBeChecked.getNormalized();
        for (String scrabbleWord : scrabbleWords) {
            Permutation temp = new Permutation(scrabbleWord);
            String scrabbleString = temp.getNormalized();

            if (scrabbleString.equals(permToBeCheckedString)) {
                foundPerms.add(temp.getWord());
            }
        }

        return foundPerms;
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
            scrabbleWords.add(word);
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
        return scrabbleWords.size();
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
