package task3;

import com.epam.perkovdenys.task3.part1.LineReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class TestLineReader {

    private LineReader reader;
    private Iterator iterator;

    @Before
    public void init(){
        String fileName = "testLineReader.txt";
        reader = new LineReader(fileName);
        iterator = reader.iterator();
    }

    @Test
    public void iteratorHasNext(){
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorNext(){
        String expectedFirstLine1 = "a1a2a3a4 a5a6 a1";
        String expectedFirstLine2 = "100_000 0001!,.";
        String expectedFirstLine3 = new String("Abcd Кириллица");

        Assert.assertEquals(expectedFirstLine1, iterator.next());
        Assert.assertEquals(expectedFirstLine2, iterator.next());
        Assert.assertEquals(expectedFirstLine3, iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNextShouldException(){
        while (true){
            iterator.next();
        }
    }
}
