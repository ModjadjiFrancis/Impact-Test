/* ASSUMPTIONS
 * 
 * Input entered will always be ordered. Assumption based on the ordered input example provided
 * 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Summarizer implements NumberRangeSummarizer {
    
    public static void main (String args[]){
        
        //using the interface 
        NumberRangeSummarizer numSum = new Summarizer();
        System.out.println(numSum.collect("1,2,3,4,5,6"));
        System.out.println(numSum.summarizeCollection(numSum.collect("1,2,3,4,5,6")));
        
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
        //An exception needs to be caught!
    }

    @Override
    public  String summarizeCollection(Collection<Integer> input){
        
        //Method to take input and summarise the collection

        //Check for empty input 

        if (input.isEmpty()){
            return "Input is empty. Please enter valid input";
        }

        //Sorting the input 

        ArrayList<Integer> sortedInput = new ArrayList<>(input);
        Collections.sort(sortedInput);

        //Seperating the input into ranges. Each range has a start and end number
        ArrayList<String> inputRanges = new ArrayList<>();
        int start = sortedInput.get(0); //first number in sorted starts the first range
        int end = start; //Assuming start - start is first range

        //for loop to populate a range, to start at 1

        for (int i = 1; i < sortedInput.size(); i++){
            int workingInput = sortedInput.get(i); //input being looped

            //checking if working input is in range
             if (workingInput == end + 1){
                end = workingInput;
             } //if 4 = 3 + 1; then end = 4 instead of 3
             else{
                //if not start - start is the range
                String singleRange = workingInput+"";
                inputRanges.add(singleRange);
                start = workingInput;
                end = workingInput;
             }

            //adding ranges to arrayList

        }

        String completeRange = start + "-" + end;
        inputRanges.add(completeRange);
        
        return String.join(",", inputRanges);
    }
    
}
