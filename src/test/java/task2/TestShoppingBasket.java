package task2;

import com.epam.perkovdenys.task4.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task4.model.Food;
import com.epam.perkovdenys.task4.model.Potatoes;
import com.epam.perkovdenys.task4.model.ShoppingBasket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class TestShoppingBasket {

    private ShoppingBasket basket;

    @Before
    public void init(){
        basket = new ShoppingBasket();
        ProductsListDAOImpl.getInstance().addProduct(new Potatoes(75, 30, 400, "Fried potatoes"));
        ProductsListDAOImpl.getInstance().addProduct(new Potatoes(40, 40, 600, "Chips"));
        ProductsListDAOImpl.getInstance().addProduct(new Potatoes(100, 50, 400, "Boil potatoes"));
    }

    @Test
    public void addProductToBasket(){
        int number = 2;
        int expectedCount = 5;
        basket.addProduct(number, 3);
        basket.addProduct(number, 2);
        for (Map.Entry<Food, Integer> entry : basket.getBasket().entrySet())
        {
            Assert.assertEquals(entry.getValue().intValue(), expectedCount);
        }
    }

    @Test
    public void removeProduct(){
        int number = 2;
        basket.addProduct(number, 2);
        basket.removeProduct(number);
        Assert.assertTrue(basket.getBasket().isEmpty());
    }
}
