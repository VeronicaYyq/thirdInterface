import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.UUID;

/**
 * @Author: yyq
 * @Date 1:20 下午 2020/12/11
 * @Description:
 */
public class Test02 {
    public static void test(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] % 2 == 0) {
                    throw new NullPointerException();
                } else {
                    System.out.println(i);
                }
            } finally {
                System.out.println("e");
            }
        }
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 6;

        byte s = (byte) 129;
        System.out.println(s);

        //a -= b++ % 5;
        //a -= ++b % 5;
        a %= b + b % 5;
        //a %= ++ b % 10;
        System.out.println(a);
        System.out.println(b);

        System.out.println(UUID.randomUUID().toString().replace("-", "").substring(0, 32));
    }
}

