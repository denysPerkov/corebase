package task5;


import com.epam.perkovdenys.task5.part2.Potatoes;
import com.epam.perkovdenys.task5.part2.PotatoesImpl;
import com.epam.perkovdenys.task5.part2.ProxyFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestProxyFactory {

    @Test
    public void proxyFactory(){
        int expected = 777;
        PotatoesImpl potatoes = new PotatoesImpl();
        potatoes.setCost(expected);
        Potatoes food = (Potatoes) ProxyFactory.newInstance(potatoes);
        Assert.assertEquals(food.getCost(), expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void proxyFactoryShouldException(){
        int cost = 100;
        PotatoesImpl potatoes = new PotatoesImpl();
        Potatoes food = (Potatoes) ProxyFactory.newInstance(potatoes);
        food.setCost(555);
    }
}
