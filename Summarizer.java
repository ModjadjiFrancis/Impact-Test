/* ASSUMPTIONS
 * 
 * Input entered will always be ordered. Assumption based on the ordered input example provided
 * 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Summarizer implements NumberRangeSummarizer {
    
    public static void main (String args[]){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your list of numbers.");
        String numList = input.nextLine(); 
        
        NumberRangeSummarizer numSum = new Summarizer();

        System.out.println("Your summarised and ordered list is below:");
        System.out.println(numSum.summarizeCollection(numSum.collect(numList)));
        
    }

    @Override
    //method to collect input of integers
    public Collection<Integer> collect (String input){

        //checking input
        if (input.isEmpty()){
            return null;
        }

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
                // String singleRange = workingInput+"";
                // inputRanges.add(singleRange);
                // start = workingInput;
                // end = workingInput;
                inputRanges.add(ranges(start, end));
                start = workingInput;
                end = workingInput;
             }
        }

        inputRanges.add(ranges(start, end));
        
        return String.join(",", inputRanges);
    }

    public String ranges(int start, int end){
        if (start == end){
            return String.format("%d", start);
        }else{
            return String.format("%d-%d",start,end);
        }
    }
    
}
