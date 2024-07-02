import java.util.ArrayList;
import java.util.Collection;


public class Summarizer implements NumberRangeSummarizer {
    
    public static void main (String args[]){
        System.out.println("Hello");
        
        //using the interface 

        NumberRangeSummarizer numSum = new Summarizer();

        System.out.println(numSum.collect("1,2,3,4,5,6"));

        
    }

    @Override
    //method to collect input of integers
    public Collection<Integer> collect (String input){

        String[] arrInput = input.split(","); //Splitting input 
        Collection<Integer> inputCol = new ArrayList<Integer>();

        for (int i=0; i< arrInput.length; i++){
            inputCol.add(Integer.parseInt(arrInput[i]));
        }
        return inputCol;

    }

    @Override
    public  String summarizeCollection(Collection<Integer> input){
        return "Hello";
    }
    
}
