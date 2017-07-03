# Lab Report - Exercise 11: Scrabble Cheater - Basic Edition
_Authors: Dennis Loska, Bernhard Zaborniak, Tony Dorfmeister, 03.07.2017_
<!--  PRELAB not requiered -->
## Assignment

### 1. Implement initFromFile in SimpleWordList that initializes the ScrabbleCheater from a given file. For now, simply store the words in a suitable Collection of the Java Collections Framework.

### 2. Implement the getNormalized() and equals() methods in Permutation. Two Permutations should be equal if one is a permutation of the other - regardless of the actual words they represent. Having a look at the provided test cases and making them run might help with the implementation.

### 3. To make the tests for Permutation work, also implement the methods that create Permutations in PermutationUtilities

### 4. Now implement the validWordsUsingAllTiles() method in SimpleWordList that returns a Set of all the Words that are permutations of a given tile rack. That is, all words of the same length of the tile rack that can be build with it and that are in the word list, thus valid scrabble words.

### 5. How can you use the Permutation class to make looking up the validWordsUsingAllTiles() more efficient? (Hint: how often will normalize() be called a) for initialisation and b) for a lookup in your WordList?)

### 6. Now, provide a second implementation of WordList using a HashMap as the underlying collection for storing the words. Note that you need to make sure that equals() and hashCode() work correctly on permutations in order to store Permutations at the same place in the HashMap.

### 7. You might want to add a main method or some sort of interface to input words that should be looked up by your scrabble cheater. (e.g. taking a parameter or reading in tile racks from standard in)
