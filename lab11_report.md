# Lab Report - Exercise 11: Scrabble Cheater - Basic Edition
_Authors: Dennis Loska, Bernhard Zaborniak, Tony Dorfmeister, 03.07.2017_
<!--  PRELAB not requiered -->
## Assignment

### 1. Implement initFromFile in SimpleWordList that initializes the ScrabbleCheater from a given file. For now, simply store the words in a suitable Collection of the Java Collections Framework.

We have used a HashSet to store every line of the given text file. 

```java
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
```



### 2. Implement the getNormalized() and equals() methods in Permutation. Two Permutations should be equal if one is a permutation of the other - regardless of the actual words they represent. Having a look at the provided test cases and making them run might help with the implementation.

For `getNormalized()` we used a byte array that we get through the parameter `word` in the constructor and then sorted it with the command `Arrays.sort()`. 

```java
public String getNormalized() {
        Arrays.sort(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append((char) b);
        }
        return sb.toString();
    }
```

For the `equals()` method we first cast the input object of type `Object` into an object of type `Permutation`. This way we can use the implemented method `hashCode()` of the Permutation class to compare the two objects.

```java
public boolean equals(Object obj) {
        Permutation casted = (Permutation) obj;
        return this.hashCode() == casted.hashCode();
    }
```



### 3. To make the tests for Permutation work, also implement the methods that create Permutations in PermutationUtilities

First of all we have built a byte array containing all upper and lowercase characters. For `createPermutation(int length)` we have then used a Random object to get random characters that will be appended for the output string.

```java
public static String createPermutation(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            sb.append((char) chars[rand.nextInt(chars.length)]);
        }
        return sb.toString();
    }
```

For `createPermutation(String p)` we also generate a byte array from the input and then shuffle this array by using `Collections.shuffle()`. The shuffled array will then be appended to the output string.

```java
public static String createPermutation(String p) {
        byte[] theseLetters = p.getBytes();
        ArrayList<Byte> bytes = new ArrayList<Byte>();
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
```





### 4. Now implement the validWordsUsingAllTiles() method in SimpleWordList that returns a Set of all the Words that are permutations of a given tile rack. That is, all words of the same length of the tile rack that can be build with it and that are in the word list, thus valid scrabble words.

For this exercise we generate the normalized version of an input string, iterate through the collection of scrabble word and compare if an entries normalized version is equal to the input string. If this is the case this word will be saved into a hashSet which will be returned.

```java
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
```



### 5. How can you use the Permutation class to make looking up the validWordsUsingAllTiles() more efficient? (Hint: how often will normalize() be called a) for initialisation and b) for a lookup in your WordList?)

Maybe we could have made `validWordsUsingAllTiles()` more efficient by storing objects of type `Permutation` inside of the two HashSets instead of Strings.



### 6. Now, provide a second implementation of WordList using a HashMap as the underlying collection for storing the words. Note that you need to make sure that equals() and hashCode() work correctly on permutations in order to store Permutations at the same place in the HashMap.

```java
public Set<String> validWordsUsingAllTiles(String tileRackPart) {
        HashSet<String> foundPerms = new HashSet<>();
        Permutation permToBeChecked = new Permutation(tileRackPart);
        for (Map.Entry<String, String> entry : scrabbleWords.entrySet()){
            if (entry.getKey().equals(permToBeChecked.getNormalized())){
                foundPerms.add(entry.getValue());
            }
        }
        return foundPerms;
    }
```

This method is partly functioning because some test cases are failing.

### 7. You might want to add a main method or some sort of interface to input words that should be looked up by your scrabble cheater. (e.g. taking a parameter or reading in tile racks from standard in)
