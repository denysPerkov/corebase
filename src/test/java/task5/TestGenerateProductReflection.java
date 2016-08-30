package task5;


import com.epam.perkovdenys.task5.part1.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task5.part1.service.GenerateProductReflection;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;


public class TestGenerateProductReflection {

    @Test
    public void generatePotatoes() {
        GenerateProductReflection generateProductReflection = new GenerateProductReflection();
        int lastIndex = ProductsListDAOImpl.getInstance().getLastElement();
        String inputData = "Potatoes";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        generateProductReflection.selectStrategy();

        Assert.assertNotEquals(lastIndex, ProductsListDAOImpl.getInstance().getLastElement());
        Assert.assertEquals(lastIndex + 1, ProductsListDAOImpl.getInstance().getLastElement());
    }

}
