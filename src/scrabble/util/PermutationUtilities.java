package scrabble.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

public class PermutationUtilities {

    static byte[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	/**
	 * creates a set with all subsets of the input string
	 * 
	 * @param str
	 * @return
	 */
	public static Set<String> getSubSets(String str) {
		return null;
	}

	public static String createPermutation(int length) {
		StringBuilder sb = new StringBuilder();
        Random rand = new Random();

	    for (int i = 0; i < length; i++){
			sb.append(chars[rand.nextInt(chars.length)]);
		}
        System.out.println(sb.toString());
        return sb.toString();
	}

	public static String createPermutation(String p) {
	    byte[] theseLetters = p.getBytes();
        StringBuilder sb = new StringBuilder();

        Collections.shuffle(Arrays.asList(theseLetters));
        byte[] newPermutation = new byte[theseLetters.length];

        for (int i = 0; i < newPermutation.length; i++){
            newPermutation[i] = theseLetters[i];
        }

        for (byte b : newPermutation){
            sb.append(b);
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
