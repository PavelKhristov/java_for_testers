import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CollectionTests {


    //Множества
    @Test
    void setTests(){
        var set = new HashSet<>(List.of("a", "b", "c", "a"));
        Assertions.assertEquals(3, set.size());   //дублирующиеся значения не учитываются в множествах

        set.add("d");
        Assertions.assertEquals(4, set.size());
    }

    //Словари
    @Test
    void testMap(){
        var digits = new HashMap<Character, String>();
        digits.put('1', "one");
        digits.put('2', "two");
        digits.put('3', "three");
        Assertions.assertEquals("one", digits.get('1'));
        digits.put('1', "один");
        Assertions.assertEquals("один", digits.get('1'));
    }
}
