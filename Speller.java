import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Speller.java 
 * CS230 Lab on hash tables
 * To check a text file against a dictionary of english words, 
 * which is constructed from an other text file.
 *
 * @author cs230 staff (SK), Kailyn Lau
 * @version 
 **/

public class Speller  {
    private EnglishHashDictionary dictionary;
    private LinkedList<String> misspelledWords;  // Container to store misspelled words

    /**
     * Creates a Dictionary based on the input file
     * Creates a container to hold the misspelled words found
     * 
     * @param The name of the file on which the Dictionary is built on
     */
    public Speller(String dictFName) {
        dictionary = new EnglishHashDictionary(dictFName);
        misspelledWords = new LinkedList<String>();
    }

    /**  
     * Reads in the file to be spell-checked 
     * 
     * @param String documentName the name of the text file to be spell-checked
     */
    public void checkSpelling(String docName)  {
        try (Scanner scanner = new Scanner(new File(docName))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();  // Convert word to lowercase for case-insensitivity

                // Remove any punctuation using a regular expression
                word = word.replaceAll("[^a-zA-Z]", "");

                // Check if the word is in the dictionary
                if (!dictionary.searchWord(word) && !word.isEmpty()) {
                    misspelledWords.add(word);  // Add to the list of misspelled words
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the document: " + e.getMessage());
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Misspelled words in the document:\n");
        result.append("Total misspelled words: " + misspelledWords.size() + "\n");

        if (misspelledWords.size() > 0) {
            for (String word : misspelledWords) {
                result.append(word + "\n");
            }
        } else {
            result.append("No misspelled words found.\n");
        }
        return result.toString();
    }

    public static void main (String[] args) throws IOException {
        Speller speller = new Speller("EnglishWords.txt");
        speller.checkSpelling("EnglishWords1.txt");
        System.out.println("Text 1:");
        System.out.println(speller);
        
        Speller speller2 = new Speller("EnglishWords.txt");
        speller.checkSpelling("EnglishWords2.txt");
        System.out.println("Text 2:");
        System.out.println(speller);
    }
}   
