
import com.epam.perkovdenys.task1.part1.Food;
import com.epam.perkovdenys.task1.part2.ProductContainer;
import com.sun.deploy.util.OrderedHashSet;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TestProductContainer {

    private ProductContainer obj;

    @Before
    public void initContainer() {
        obj = new ProductContainer();
        obj.add(new Food(10));
        obj.add(new Food(55));
        obj.add(new Food(101));
    }


    @Test
    public void testAdd() {

        Food food = new Food(123);
        Food food2 = new Food(100);
        obj.add(food);

        Assert.assertTrue(obj.contains(food));
        Assert.assertFalse(obj.contains(food2));

        obj.add(0, food2);
        Assert.assertEquals(obj.toArray()[0], food2);
    }

    @Test
    public void testAddWithIndexParametr() {
        int cost = 123;
        Food food = new Food(cost);
        obj.add(1, food);

        Assert.assertTrue(obj.contains(food));
        Assert.assertEquals(obj.get(1).getCost(), cost);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddShouldException() {
        Food food = new Food(123);
        obj.add(6, food);

        Assert.assertEquals(obj.toArray()[6], food);
    }


    @Test
    public void testGet() {
        int cost = 25;
        int index = 3;
        obj.add(new Food(cost));

        Assert.assertEquals(obj.get(index).getCost(), cost);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetShouldException() {
        int index = 55;
        int cost = 100;
        obj.add(new Food(cost));

        Assert.assertEquals(obj.get(index).getCost(), cost);
    }

    @Test
    public void testRemove() {
        Food food = new Food(99);
        obj.add(food);

        Assert.assertTrue(obj.contains(food));
        obj.remove(food);
        Assert.assertTrue(!obj.contains(food));
    }

    @Test
    public void testRemoveWithIndexParamentr() {
        int cost = obj.get(0).getCost();
        obj.remove(0);
        Assert.assertNotEquals(obj.get(0).getCost(), cost);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveShouldException() {
        int index = 55;
        obj.remove(index);

        Assert.assertTrue(obj.remove(index) == obj.get(index));
    }
}
