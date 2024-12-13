import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Hashtable;

/**
 * Reads a dictionary from the input file, into a hash table. 
 * Each line in the file contains only one word.
 * 
 * @author Stella, Kailyn
 * 
 */

public class EnglishHashDictionary implements Dictionary {
    private Hashtable<String,String> allWords;

    /**
     * @param  String dictFName  the name of the file that contains 
     * the dictionary words
     */
    public EnglishHashDictionary(String dictFName) {
        allWords = new Hashtable<String, String>();
        loadDictionary(dictFName);
    }

    /**
     * Loads the dictionary file into the Hashtable.
     * @param dictFName the name of the file to read the words from
     */
    private void loadDictionary(String dictFName) {
        try (Scanner scanner = new Scanner(new File(dictFName))) {
            int wordCount = 0;
            while (scanner.hasNext()) {
                String word = scanner.nextLine().trim();
                allWords.put(word, word);  // Use the word as both key and value
                wordCount++;
            }
            System.out.println("*************************");
            System.out.println("Dictionary " + dictFName + " loaded containing " + wordCount + " words");
            System.out.println("*************************");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    /**
     * Adds input String to the dictionary 
     */
    public void addWord(String word) {
        allWords.put(word, word);  // Add the word as both key and value
    }

    /**
     * Searches the dictionary for the input String.
     * Returns true if found, false otherwise.
     */
    public boolean searchWord(String word) {
        return allWords.containsKey(word);  // Check if the word exists as a key in the Hashtable
    } 

    /**
     * Removes from the dictionary for the input String.
     * It does nothing if the input word is not in the dictionary.
     */
    public void removeWord(String word){
        allWords.remove(word);  // Remove the word from the Hashtable
    }

    public static void main(String[] args) {
        EnglishHashDictionary ed = new EnglishHashDictionary("EnglishWords.txt");
        System.out.println("donut: " + ed.searchWord("donut"));
        System.out.println("Adding donut to dictionary");
        ed.addWord("donut");
        System.out.println("donut: " + ed.searchWord("donut"));
        System.out.println("data: " + ed.searchWord("data"));
        System.out.println("booger: " + ed.searchWord("booger"));

        ed.removeWord("donut");
        System.out.println("\nremoved donut");
        System.out.println("donut: " + ed.searchWord("donut"));
    }
}
