package scrabble.util;


import java.util.Arrays;

public class Permutation {

    private String word;
    private byte[] bytes;

    public Permutation(String word) {
        this.word = word;
        bytes = word.getBytes();
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (Byte b : bytes) {
            sum += b;
        }
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Permutation)) return false;
        Permutation casted = (Permutation) obj;
        return this.hashCode() == casted.hashCode();
    }

    @Override
    public String toString() {
        return getWord() + " / " + getNormalized();
    }

    public String getNormalized() {
        Arrays.sort(bytes);
        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append((char) b);
        }

        return sb.toString();
    }

    public String getWord() {
        return word;
    }

    public int length() {
        // TBD: implement this method
        return bytes.length;
    }

}
