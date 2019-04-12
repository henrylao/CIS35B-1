/*
A string tokenizer is a class in java that you can use to basically parse
string and extract the different values inside it.
for example, you could put together a string that has value of different data types,
and you can extract each of them. So you need to have kind of like 
a separator. 
*/
import java.util.*;
public class Driver {
    public static void main(String [] args){
        String example = "Jackson; 39217, true";
        // if the delimiter is just a blank space, the compile
        // automatically handle it
        // else, we have to state it. 
        // if there is a delimiter with a blank space,
        // "Jackson, " then you have to include the blank space
        StringTokenizer stk = new StringTokenizer(example, ",; ");

        String string1 = stk.nextToken();
        int zipcode = Integer.parseInt(stk.nextToken());
        boolean validity = Boolean.parseBoolean(stk.nextToken());

        if(validity) {
            System.out.println(string1);
            System.out.println(zipcode);
        }
        else 
            System.out.println("invalid string..");
    }
}