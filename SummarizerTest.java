import java.util.Collection;

import org.junit.Test;

public class SummarizerTest {

    private NumberRangeSummarizer numSum = new Summarizer();
    @Test
    public void testEmptyInput(){
        Collection<Integer> input = numSum.collect("");
        String summarized = numSum.summarizeCollection(input);
        Assert.assertEquals("",summarized);
    }
    
}
