package scrabble;

import scrabble.data.SimpleWordList;
import java.util.Scanner;

/**
 * Created by dennis on 10.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        boolean stay = true;
        SimpleWordList list = new SimpleWordList();
        list.initFromFile("wordlists/sowpods.txt");
        System.out.println("Willkommen zum Scrabble-Cheater!");
        do {
            System.out.println("Bitte gib die Buchstaben ein, um Lösungen zu finden:");
            Scanner sc = new Scanner(System.in);
            String word = sc.next();
            System.out.println("Antwort:");
            System.out.println(list.validWordsUsingAllTiles(word).toString());
            System.out.println("Möchten Sie ein weiteres Wort eingeben (y|n)?");
            if (sc.next().equals("n"))
                stay = false;
        }
        while (stay);
        System.out.println("Danke für's Spielen.");
        System.exit(0);
    }
}
