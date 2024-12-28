package binarySearchTree;

/**
 * Contact Class
 * @author Navanit Krishna Satish Kumar
 * @version 12.06.2024
 */
public class Contact implements Comparable<Contact> {
    
    private String firstName;
    private String lastName;
    private int number;
    
    /**
     * Constructor for Contact Object
     * @param first first name
     * @param last last name
     * @param num number
     */
    public Contact(String first, String last, int num) {
        this.firstName = first;
        this.lastName = last;
        this.number = num;
    }
    
    /**
     * Compares two contact objects
     * @param o Contact to compare with
     * @return negative, positive depending on comparing cases
     */
    @Override
    public int compareTo(Contact o) {
        if (o == null) {
            return 1;
        }
        if (this == o) {
            return 0;
        }
        int comp = this.firstName.compareTo(o.firstName);
        if (comp != 0) {
            return comp;
        }
        comp = this.lastName.compareTo(o.lastName);
        if (comp != 0) {
            return comp;
        }
        if (this.number > o.number) {
            return 1;
        }
        if (this.number < o.number) {
            return -1;
        }
        return 0;
    }
}
