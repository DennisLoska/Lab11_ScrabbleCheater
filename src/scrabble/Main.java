package scrabble;

import scrabble.data.SimpleWordList;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by dennis on 10.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        boolean stay = true;
        SimpleWordList list = new SimpleWordList();
        System.out.println("Willkommen zum Scrabble-Cheater!");
        do {
            System.out.println("Bitte gib die Buchstaben ein, um Lösungen zu finden:");
            Scanner sc = new Scanner(System.in);
            String word = sc.next();
            list.add(word);
            System.out.println("Antwort:");
            Set<String> set = list.validWordsUsingAllTiles(word);
            for (String s : set) {
                System.out.println(s);
            }
            System.out.println("Möchten Sie ein weiteres Wort eingeben (y|n)?");
            if (sc.next().equals("n"))
                stay = false;
        }
        while (stay);
        System.out.println("Danke für's Spielen.");
        System.exit(0);
    }
}
