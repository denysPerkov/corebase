package task5;


import com.epam.perkovdenys.task5.part2.MapProxyFactory;
import com.epam.perkovdenys.task5.part2.Potatoes;
import com.epam.perkovdenys.task5.part2.PotatoesImpl;
import org.junit.Assert;
import org.junit.Test;

public class TestMapProxyFactory {

    @Test
    public void mapProxyFactory(){
        int expectedCost = 100;
        PotatoesImpl potatoes = new PotatoesImpl();
        potatoes.setCost(expectedCost);
        Potatoes food = (Potatoes) MapProxyFactory.newInstance(potatoes);
        Assert.assertEquals(food.getCost(), expectedCost);

        int newExpectedCost = 100;
        food.setCost(newExpectedCost);
        Assert.assertEquals(newExpectedCost, food.getCost());
    }
}
