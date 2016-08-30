import com.epam.perkovdenys.task1.part1.AppleJuce;
import com.epam.perkovdenys.task1.part1.Food;

import com.epam.perkovdenys.task1.part1.Potatoes;
import com.epam.perkovdenys.task1.part2.Filter;
import com.epam.perkovdenys.task1.part2.ProductContainer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestIterator {

    private ProductContainer obj;
    private Filter filter;

    @Before
    public void initFilterIterator(){
        obj = new ProductContainer();
        obj.add(new Food(3));
        obj.add(new Food(100));
        obj.add(new Food(10));
        obj.add(new Food(11));
        obj.add(new AppleJuce(50, false, 300, "Fresh apple"));
        obj.add(new Potatoes(75, 30, 700, "Fried potatoes"));


        filter = new Filter() {
            @Override
            public boolean apply(Object type) {
                Food f = (Food) type;
                return (f.getCost() > 10) ? true : false;
            }
        };
    }

    @Test
    public void testFilterHasNext(){

        Iterator FilterItr = obj.iterator(filter);

        Assert.assertTrue(FilterItr.hasNext());
        FilterItr.next();
        Assert.assertTrue(FilterItr.hasNext());
        FilterItr.next();

    }

    @Test
    public void testFilterNext(){

        Iterator FilterItr = obj.iterator(filter);
        Object o1 = FilterItr.next();
        Object o2 = FilterItr.next();

        Assert.assertNotEquals(o1, o2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemoveShouldException(){
        obj.iterator(filter).remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testFilterShouldException(){
        int iteration = 0;
        Iterator FilterItr = obj.iterator(filter);

        while(iteration < 5)
            FilterItr.next();
    }

    @Test
    public void testVariousFilters(){

        Filter f1 = new Filter() {
            @Override
            public boolean apply(Object type) {
                Food f = (Food) type;
                return (f.getCost() > 50) ? true : false;
            }
        };
        Iterator itr = obj.iterator(f1);

        Assert.assertTrue(itr.hasNext());
        itr.next();
        Assert.assertTrue(itr.hasNext());

    }

}
