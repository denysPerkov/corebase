package task2;

import com.epam.perkovdenys.task1.part1.Potatoes;
import com.epam.perkovdenys.task2.part2.HashcodeLength;
import com.epam.perkovdenys.task2.part2.HashcodeSum;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestHashcodeLengthAndLength {

    @Test
    public void checkOutputOrderHashcodeSum(){
        HashcodeSum obj1 = new HashcodeSum("AAAA");
        HashcodeSum obj2 = new HashcodeSum("b");
        HashcodeSum obj3 = new HashcodeSum("a");

        Potatoes potatoes1 = new Potatoes(50, 35, 300, "Fried potatoes");
        Potatoes potatoes2 = new Potatoes(33, 15, 150, "Chips");
        Potatoes potatoes3 = new Potatoes(15, 50, 120, "Boiled potatoes");

        Map<HashcodeSum, Potatoes> map = new HashMap<>();
        map.put(obj1, potatoes1);
        map.put(obj2, potatoes2);
        map.put(obj3, potatoes3);

        for(Map.Entry<HashcodeSum, Potatoes> entry : map.entrySet()){
            System.out.println(entry);
        }

        Map<HashcodeSum, Potatoes> linkedMap = new LinkedHashMap<>();
        linkedMap.put(obj1, potatoes1);
        linkedMap.put(obj2, potatoes2);
        linkedMap.put(obj3, potatoes3);

        for(Map.Entry<HashcodeSum, Potatoes> entry : linkedMap.entrySet()){
            System.out.println(entry);
        }
    }

    @Test
    public void checkOutputOrderHashcodeLength(){
        HashcodeLength obj1 = new HashcodeLength("AAAA");
        HashcodeLength obj2 = new HashcodeLength("b");
        HashcodeLength obj3 = new HashcodeLength("a");

        Potatoes potatoes1 = new Potatoes(50, 35, 300, "Fried potatoes");
        Potatoes potatoes2 = new Potatoes(33, 15, 150, "Chips");
        Potatoes potatoes3 = new Potatoes(15, 50, 120, "Boiled potatoes");

        Map<HashcodeLength, Potatoes> map = new HashMap<>();
        map.put(obj1, potatoes1);
        map.put(obj2, potatoes2);
        map.put(obj3, potatoes3);

        for(Map.Entry<HashcodeLength, Potatoes> entry : map.entrySet()){
            System.out.println(entry);
        }

        Map<HashcodeLength, Potatoes> linkedMap = new LinkedHashMap<>();
        linkedMap.put(obj1, potatoes1);
        linkedMap.put(obj2, potatoes2);
        linkedMap.put(obj3, potatoes3);

        for(Map.Entry<HashcodeLength, Potatoes> entry : linkedMap.entrySet()){
            System.out.println(entry);
        }
    }
}
