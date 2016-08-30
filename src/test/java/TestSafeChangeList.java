import com.epam.perkovdenys.task1.part4.SafeChangeList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TestSafeChangeList {

    private SafeChangeList safeList;
    private List intgers;

    @Before
    public void initLists(){
        List<Integer> unmodif = new ArrayList();
        unmodif.add(5);
        unmodif.add(100);
        unmodif.add(333);
        safeList = new SafeChangeList(unmodif);

        intgers = new ArrayList<>();
        intgers.add(22);
        intgers.add(777);
        safeList.addAll(intgers);
    }

    @Test
    public void addWithIndex(){
        safeList.add(3, 444);
        Assert.assertTrue(safeList.contains(444));
    }

    @Test
    public void toArray(){
        Object []arr = safeList.toArray();
        Assert.assertArrayEquals(arr, safeList.toArray());

        Object []arr2 = new Object[]{5, 100, 333, 22, 777};
        Assert.assertArrayEquals(arr2, safeList.toArray());
        Assert.assertArrayEquals(arr2, safeList.toArray(arr2));
    }

    @Test
    public void remove(){
        safeList.add("Str1");
        safeList.remove("Str1");
        Assert.assertFalse(safeList.contains("Str1"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeShouldException(){
        safeList.remove(new Integer(333));
    }

    @Test
    public void containsAll(){
        Assert.assertTrue(safeList.containsAll(intgers));
        intgers.add(1_000);
        Assert.assertFalse(safeList.containsAll(intgers));
    }

    @Test
    public void addAll(){
        int index = 3;
        safeList.addAll(index, intgers);
        Assert.assertTrue(safeList.containsAll(intgers));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAllShouldException(){
        int index = 1;
        safeList.addAll(index, intgers);
        Assert.assertTrue(safeList.containsAll(intgers));
    }

    @Test
    public void removeAll(){
        safeList.removeAll(intgers);
        Assert.assertFalse(safeList.containsAll(intgers));

    }

    @Test
    public void retainAll(){
        Assert.assertFalse(safeList.retainAll(intgers));
    }

    @Test
    public void get(){
        int indexUnmod = 1;
        int indexMod = 4;
        int var1 = 100;
        int var2 = 777;
        Assert.assertEquals(safeList.get(indexUnmod), var1);
        Assert.assertEquals(safeList.get(indexMod), var2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getShouldException(){
        int index = safeList.size() + 1;
        safeList.get(index);
    }

    @Test
    public void set(){
        int var = 1_000;
        int index = safeList.size()-1;
        safeList.set(index, var);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setShouldException(){
        int var = 1_000;
        int index = safeList.size() + 1;
        safeList.set(index, var);
    }

    @Test
    public void indexOf(){
        int expectedIndex1 = 2;
        int expectedIndex2 = 3;
        Assert.assertEquals(safeList.indexOf(333), expectedIndex1);
        Assert.assertEquals(safeList.indexOf(22), expectedIndex2);
    }

    @Test
    public void lastIndexOff(){
        int expectedIndex1 = 2;
        int expectedIndex2 = 3;
        int expectedIndex3 = 5;
        safeList.add(314);
        safeList.add(314);
        Assert.assertEquals(safeList.indexOf(333), expectedIndex1);
        Assert.assertEquals(safeList.indexOf(22), expectedIndex2);
        Assert.assertEquals(safeList.indexOf(314), expectedIndex3);
    }

    @Test
    public void iterator(){
        Iterator it = safeList.iterator();
        int expected = 5;
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(it.next(), expected);
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorSholdException(){
        Iterator it = safeList.iterator();
        while(true) {
            it.next();
        }
    }
}


