import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * Represents a finite language.
 *
 * @author Dr. Jody Paul
 * @author Noel Corrales
 * @author
 * @author
 * @author
 * @version 1.3.TODO_YOURVERSION
 */
public final class Language implements Iterable<String>, java.io.Serializable {
    /** The empty string. */
    private static final String EMPTY_STRING = "";
    /** The empty set. */
    private static final Set<String> EMPTY_SET = new TreeSet<String>();

    /** The set of strings in this language, initially empty. */
    private Set<String> strings;

    /**
     * Create a language with no strings.
     */
    public Language() {
        //TODO
        // the resource i used to lear about TreeSet https://www.geeksforgeeks.org/treeset-in-java-with-examples/
        this.strings = new TreeSet<String>();
    }

    /**
     * Indicates if this language has no strings.
     * @return true if the language is equivalent to the empty set;
     *         false otherwise
     */
    public boolean isEmpty() {
        //TODO
        if(strings.size()==0){      //if statement checks the size of the set
            return true;            //if the value is 0 then the set is empty
        }

           
        return false;               //if the size is not 0, isEmpty is false 
        
    }

    /**
     * Accesses the number of strings (cardinality) in this language.
     * @return the cardinality of the language
     */
    public int cardinality() {
        //TODO
        int card = strings.size();      // becasue we are using a tree set we know that no values repeat
                                        //the .size() method returns the tree sets number of elements 
        return card;
    }

    /**
     * Determines if a specified string is in this language.
     * @param candidate the string to check
     * @return true if the string is in the language,
     *         false if not in the language or the parameter is null
     */
    public boolean includes(final String candidate) {
        //TODO
        //We need to compare the candidate string to the language alphabet 
        //if the string is not there, then we return false
        if(strings.contains(candidate)){
            return true;
        }

        return false;
    }

    /**
     * Ensures that this language includes the given string
     * (adds it if necessary).
     * @param memberString the string to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addString(final String memberString) {
        //TODO
        //we need to check if the string is not already in the set
        // if it is not we add it and return true 
        //if it is repeated then return false and dont try to add it
        if(memberString== null || this.strings.contains(memberString)){
            return false;
        }
        else{
            this.strings.add(memberString);
        }
        return false;
    }

    /**
     * Ensures that this language includes all of the strings
     * in the given parameter (adds any as necessary).
     * @param memberStrings the strings to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addAllStrings(final Collection<String> memberStrings) {
        //TODO
        //this method was done with the collaboration of William Nordsiek 
        // I did not know there was an addAll method that returns a boolean 
        // and also checks the collection and makes the union of the two sets
        
        return this.strings.addAll(memberStrings);
    }

    /**
     * Provides an iterator over the strings in this language.
     * @return an iterator over the strings in this language in ascending order
     */
    public Iterator<String> iterator() {
        //TODO
        TreeSet<String> nTreeSet = new TreeSet<String>(strings);
        return nTreeSet.iterator();
    }

    /**
     * Creates a language that is the concatenation of this language
     * with another language.
     * @param language the language to be concatenated to this language
     * @return the concatenation of this language with the parameter language
     */
    public Language concatenate(final Language language) {
        //TODO
        Language concLang = new Language();

        //iterate through every element in the set strings
        for(String og: this.strings){
            //iterate through every element in language
            for(String si: language.strings){
                concLang.addString(og+si);
            }
        }
        return concLang;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Language) {
            //TODO
            return strings.equals(((Language) obj).strings);
        }
        return false;
    }
    @Override
    public int hashCode() {
        //TODO
        return strings.hashCode();
    }
}