package scrabble.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

class PermutationUtilities {

    private static byte[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * creates a set with all subsets of the input string
     *
     * @param str
     * @return
     */
    static Set<String> getSubSets(String str) {
        return null;
    }

    static String createPermutation(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            sb.append((char) chars[rand.nextInt(chars.length)]);
        }
        return sb.toString();
    }

    static String createPermutation(String p) {
        byte[] theseLetters = p.getBytes();
        ArrayList<Byte> bytes = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (byte b : theseLetters) {
            bytes.add(b);
        }

        Collections.shuffle(bytes);

        for (byte b : bytes) {
            sb.append((char) b);
        }

        return sb.toString();
    }
}
