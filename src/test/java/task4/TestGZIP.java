package task4;

import com.epam.perkovdenys.task4.dao.impl.ProductsListDAOImpl;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

public class TestGZIP {

    @Test
    public void test(){
        try{
            int count = 10_000;
            FileOutputStream fos = new FileOutputStream("E:\\workspace\\25_denys_perkov\\productsgzip.gz");
            GZIPOutputStream gz = new GZIPOutputStream(fos);

            ObjectOutputStream oos = new ObjectOutputStream(gz);
            while (count > 0) {
                oos.writeObject(ProductsListDAOImpl.getInstance().getAllFood());
                count--;
            }
            oos.close();

            System.out.println("Done");

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
