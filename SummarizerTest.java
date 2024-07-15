import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class SummarizerTest {

    private NumberRangeSummarizer numSum = new Summarizer();
    @Test
    public void testEmptyInput(){
        Collection<Integer> input = numSum.collect("");
        String summarized = numSum.summarizeCollection(input);
        Assert.assertEquals(null, summarized);
    }

    @Test
    public void testSumCollection(){
        Collection<Integer> col = numSum.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String sum = numSum.summarizeCollection(col);
        Assert.assertEquals("1,3,6-8,12-15,21-24,31", sum);
    }

    @Test
    public void testSingleRange(){
        Collection<Integer> col = numSum.collect("2");
        String sum = numSum.summarizeCollection(col);
        Assert.assertEquals("5", sum);
    }
    
    @Test
    public void testNoRange(){
        Collection<Integer> col = numSum.collect("1,3,5,7");
        String sum = numSum.summarizeCollection(col);
        Assert.assertEquals("1,3,5,7", sum);
    }
}
