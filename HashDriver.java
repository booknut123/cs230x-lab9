import java.util.Hashtable;
/**
 * Driver method for practicing hashes
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public class HashDriver
{
    /**
     * Exploring hashtable functionalities
     */
    public static void main (String[] args) {
        Hashtable<String, String> dates = new Hashtable<String, String>(10);

        // Populating the Hashtable with key-value pairs
        dates.put("New Year", "01/01/2024");
        dates.put("Halloween", "10/31/2024");
        dates.put("Christmas", "12/25/2024");
        
        System.out.println("Hashtable Contents: " + dates);

        // Checking if certain keys exist in the table
        String keyToSearch1 = "New Year";
        String keyToSearch2 = "Valentine's Day";

        if (dates.containsKey(keyToSearch1)) {
            System.out.println(keyToSearch1 + " exists in the table: " + dates.get(keyToSearch1));
        } else {
            System.out.println(keyToSearch1 + " does NOT exist in the table.");
        }

        if (dates.containsKey(keyToSearch2)) {
            System.out.println(keyToSearch2 + " exists in the table: " + dates.get(keyToSearch2));
        } else {
            System.out.println(keyToSearch2 + " does NOT exist in the table.");
        }
    }
}
