package interview4.javase;

import java.util.Arrays;
import java.util.List;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/22 21:08
 * @Description:
 */
public class Arrays_BugDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        list.add(6);

        list.forEach(System.out::println);
    }
}
