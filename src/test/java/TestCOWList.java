import com.epam.perkovdenys.task1.part3.COWList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;



public class TestCOWList {

    private COWList cow;

    @Before
    public void initCOWList(){
        cow = new COWList();
        cow.add(11);
        cow.add(22);
        cow.add(33);
        cow.add(44);
    }

    @Test
    public void add(){
        int var = 1_000;
        int lastIterElement = -1;
        int lastElement = 44;
        Iterator it = cow.iterator();

        while (it.hasNext()){
            lastIterElement = (int) it.next();
        }
        Assert.assertEquals(lastIterElement, lastElement);

        cow.add(var);
        lastElement = var;
        Iterator it2 = cow.iterator();
        while (it2.hasNext()){
            lastIterElement = (int) it2.next();
        }
        lastElement = var;
        Assert.assertEquals(lastIterElement, lastElement);
    }

    @Test
    public void remove(){
        int lastIterElement = -1;
        int lastElement = 44;
        Iterator it = cow.iterator();

        while (it.hasNext()){
            lastIterElement = (int) it.next();
        }
        Assert.assertEquals(lastIterElement, lastElement);

        cow.remove(new Integer(lastIterElement));
        Iterator it2 = cow.iterator();
        while (it2.hasNext()){
            lastIterElement = (int) it2.next();
        }
        lastElement = 33;
        Assert.assertEquals(lastIterElement, lastElement);
    }

    @Test
    public void removeByIndex(){
        int index = 2;
        int removedElement = 33;
        cow.remove(index);
        Iterator it = cow.iterator();

        while (it.hasNext()){
            if(removedElement == (int) it.next()) {
                Assert.fail();
            }
        }
    }

    @Test
    public void get(){
        int expected1 = 11;
        int expected2 = 44;
        Assert.assertEquals(expected1, cow.get(0));
        Assert.assertEquals(expected2, cow.get(3));
    }

    @Test
    public void setWithIndex(){
        int index = 2;
        int var = 9_999;
        cow.set(index, var);
        Assert.assertEquals(cow.get(2), var);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWithIndexShouldException(){
        int index = 10;
        int var = 9_999;
        cow.set(index, var);
    }
}
