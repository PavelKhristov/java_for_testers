package common;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonFunctions {
    //rnd.nextInt(26) будет генерировать рандомное число от 0 до 26, итого в result генерируется строка из латинских букв с длинной = n

//    public static String randomString(int n){
//        var rnd = new Random();
//        var result = "";
//        for (int i = 0; i < n; i++){
//            result = result + (char)('a' + rnd.nextInt(26));
//        }
//        return result;
//    }

    //Написание метода в функциональном стиле
    public static String randomString(int n){
        var rnd = new Random();
        Supplier<Integer> randomNumbers = () -> rnd.nextInt(26);
        var result = Stream.generate(randomNumbers)
                .limit(n)
                .map(i -> 'a' + i)
                .map(Character::toString)
                .collect(Collectors.joining());
        return result;
    }
}
