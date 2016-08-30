package task2;

import com.epam.perkovdenys.task2.part1.UniqueObjectList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denys_Perkov on 12-Apr-16.
 */
public class TestUniqueObjectList {

    private UniqueObjectList arr;
    private List<Integer> integers;

    @Before
    public void itin(){
        arr = new UniqueObjectList();
        arr.add(11);
        arr.add(22);
        arr.add(33);
        integers = new ArrayList<>();
    }

    @Test
    public void add(){
        arr.add(44);
        arr.add(new String("ABC"));
        Assert.assertTrue(arr.contains(44));
        Assert.assertTrue(arr.contains("ABC"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldException(){
        arr.add(11);
        arr.add(22);
    }

    @Test
    public void addAll(){
        integers.add(1_000);
        integers.add(2_000);
        Assert.assertTrue(arr.addAll(integers));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAllShouldException(){
        integers.add(11);
        integers.add(22);
        Assert.assertTrue(arr.addAll(integers));
    }

    @Test
    public void addAllWithIndex(){
        int index = 1;
        integers.add(1_000);
        integers.add(25_000);
        Assert.assertTrue(arr.addAll(index, integers));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAllWithIndexShouldException(){
        int index = 1;
        int data = 22;
        integers.add(data);
        arr.addAll(index, integers);
    }

    @Test
    public void set(){
        int index = 2;
        int data = 111;
        arr.set(index, data);
        Assert.assertEquals(arr.get(index), data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setShouldException(){
        int index = 1;
        int data = 22;
        arr.set(index, data);
    }

    @Test
    public void addWithIndex(){
        int index = 1;
        int data = 1_000;
        arr.add(index, data);
        Assert.assertEquals(arr.get(index), data);
    }





}
