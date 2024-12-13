[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/UwftmGRb)
# CS230X-lab0-F24
# Hashing

Goals:
* Practice with Hashtables
* Explore Java API
* Make use of interfaces
* Experiment with command-line arguments

### Practice with hash tables: writing a spell checker
In this lab we will implement a program to do spell checking of text
documents against a dictionary of words.  

A **hash table** is a very good data structure to hold
a dictionary of words against which documents will be checked, because
it provides for an efficient way to look elements up in it.  

Once the dictionary words are loaded into a hash table, the program will be
reading consecutive words from the document to be checked. Each word
will be looked up in the dictionary.  If a word is not found in the
dictionary, the word is considered a spelling error.

The dictionary will be read from a text file (on disk) into a hash
table (in memory).  Each word in the file serves as a key as we insert
entries into the hash table. In this application, the object
associated with the key is of no importance to us, so in your
implementation it can be whatever you choose, but null. For example, it can be
the same object as the key itself, or a number, or anything else.

Our program will provide the user with the flexibility to choose the file of words
they want to use to build their dictionary.
In addition, we will structure this application in such a way that it is easy to
replace the hash table holding the dictionary with some other suitable
data structure in the future.

In particular, we will separate the task of creating
the dictionary from the task of spell checking the document. Implement
the first task in a class named **EnglishHashDictionary.java** and
the second task in a class named **Speller.java**.  The
Speller class should require minimal changes when a dictionary other
than the EnglishHashDictionary is used.

The material here provides a starting point for your work. This starter code contains the following files:

1. Dictionary.java (the complete interface)
2. EnglishHashDictionary.java (an incomplete implementation of the Dictionary interface)
3. Speller.java (an incomplete client)
4. three "EnglishWordsX.txt" files to use in building your English Language Dictionary
5. several text files (end in .txt) to use for spell checking.

In particular:

* **Dictionary.java**: Any class that defines a dictionary should
implement this interface.  In particular, any such class should
provide a way to add a word to the dictionary, search the
dictionary for a given word, and remove a word from it.
Our *EnglishHashDictionary* class
will, indeed, be no exception.  Using this interface, the client code,
 like the *Speller* in our
application, (see further down) becomes independent of the specifics
in such implementation.  
+ The file **EnglishWords.txt** contains about 25,000 words that make up
the dictionary we will use today
(**EnglishWords1.txt** contains about 40,000 words; **EnglishWords2.txt** contains about
80,000 words -- you can use any of these files, or try them all and see if you notice a speed difference).

 Notice that all text files contain some, but
not all variations of a given word (e.g. plural, *-ing* or
*-ed* forms of the words). Anything not in our dictionary file is
considered a misspelling. This is clearly not ideal, but this is a
preliminary spell-check program (think version 1.0).  

+ The **RomeoAndJuliet.txt** and the rest .txt files contain English text to be spell checked. Of course, feel free to create your own text files for testing purposes!


### Task 0

Look at the [Java's Hashtable API](https://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html). Inside the starter code for this lab, add a class called **HashDriver.java**, and inside, add a main() method. Create a Hashtable with values and keys of your choice. Now explore some of the functionalities this class offers you:
* Add a few entries.
* Print the table.
* Look for an entry which exists in the table and for anogther one that doesn't exist.
* Print the results in an informative way.
  
```
 import java.util.*;

 Hashtable<String, String> dates = new Hashtable<String, String>(10); // 10 initial spots
 // populate the table
 dates.put("Commencement", "6/01/2021");
 dates.put("Last Day of Classes", "5/11/2021");
 dates.put("Marathon Monday", "4/16/2021");
```

What happens if you execute the following lines of code?

**Task 1: EnglishHashDictionary.java**
Finish the implementation of the class  **EnglishHashDictionary**.

In particular, the **EnglishHashDictionary.java** should **implement the
Dictionary Interface**, specified in the *Dictionary.java* file.
This program will read a text file containing the dictionary (a word per line)
into a *Hashtable* object. Use Java's *Hashtable<K,V>*  in this assignment. Since for this lab we only need to keep track of the keys K (the words in the dictionary), we do not need to worry much about the values V. We can use the words (String) both as keys (K) and as values (V).

Pay attention to the provided *main()* method to your file to test your code, and make sure it works well,
before you proceed to the next step.

<table border =1>
  <th>main() </th>
<tr>
<td>
<pre>
public static void main(String[] args) {
 EnglishHashDictionary ehd = new EnglishHashDictionary("EnglishWords.txt");
 System.out.println("******Testing searchWord() *****");
 System.out.println("donut: " + ehd.searchWord("donut"));
 System.out.println("Adding donut to dictionary");
 ehd.addWord("donut");
 System.out.println("donut: " + ehd.searchWord("donut"));
 System.out.println("data: " + ehd.searchWord("data"));
 System.out.println("booger: " + ehd.searchWord("booger"));
 System.out.println("  ");
 }
</pre>
</td>
</tr>
</table>


Below is some sample **output** from the **main()** method in EnglishHashDictionary:

<table border =1>
  <th>output </th>
<tr>
<td>
<pre>
*************************
Dictionary EnglishWords.txt loaded containing 45427 words
*************************

******Testing searchWord() *****
donut: false
Adding donut to dictionary
donut: true
data: true
booger: false

</pre>
</td>
</tr>
</table>

### Task 2: Speller.java
Finish the implementation of the **Speller** class.

In particular, provide a method, **checkSpelling()**, which takes as an argument
the name of a text file to be spell-checked. As spell-checking proceeds, any misspelled words should be added to some kind of "container". What kind of container could be suitable?
Provide the means of printing the results on the standard output.

Write a *main()* method, that creates a dictionary and a speller, and spell-check a few text documents.

Note that our spell-checker has a hard time handling punctuation. Many of our provided .txt documents highlight flaws in our spell-checker.
There is not much we can do about this in this lab, but we mention it just as food for thought for future versions of your spell checker...

#### Ideas for improvements:
If you have time, use **command-line arguments** in your program:
* arrange so that the user can provide the *name of the document to be checked* as a command-line argument.
* provide a version where the user can provide the *name of the file containing the dictionary words* as a second command line input.
* What would it take to make the second argument above *optional*? (That it, if the user does not enter a second command-line argument, the program uses a default one, otherwise it uses what is specified by the user.)
* Can you provide the way for the user to input multiple files names for spell-checking as command-line arguments?
* How can you ignore punctuation in the words as they get checked for belonging in the Dictionary or not?

## SAVING YOUR WORK ON GITHUB
As we have discussed in class, it is important to work on labs and assignments regularly and save frequently. You should test your work incrementally, which will require you to save your file before compiling/running it. In addition to saving your work on your local machine, you should also frequently push your work to this Github repository. You can refer to Lab0 and the [Git and Github tutorial](https://github.com/CS230X-F24/github-starter-course) for a refresher on using these tools. 

## SUBMITTING TO GRADESCOPE
Turn in your work submitting files EnglishHashDictionary.java, Speller.java, HashDriver.java to your Gradescope account for Lab9. You will receive full credit for this lab if you submit a reasonable attempt at completing the lab by the deadline. [Click here for Gradescope instructions.](https://docs.google.com/document/d/1zGAJrbdAhfPZVlyDP9N3MmdKXWvNo7rQqehKNM5Q0_M/edit) 

## AUTOGRADER
When you submit your lab to Gradecope, you will immediately see some feedback through the autograder. You are welcome to resubmit as many times as you wish until the deadline. The autograder will check for accuracy, style, and documentation. Make sure there are no remaining `TODO` comments in your submission code. Click here for 230X instructions on: [testing your code](https://docs.google.com/document/d/19cKOyolT8UtSfMNrVw8MGgVWS-lYgHpBs8g2Cf_8Vvc/edit#heading=h.rt39ohf1jp6s), [styling your code](https://docs.google.com/document/d/14uwj9HAjNKfFBm0ZjUpWR7jdqKSj13rudIEJaG74mPk/edit), and [documenting your code](https://docs.google.com/document/d/15uqs_NH8y2sAuLLpiZuSxlI0UsL6a8CHuWY_qcvF4B4/edit). 

## LAB SOLUTIONS
Lab solutions will be added to this repository after the lab deadline. 
