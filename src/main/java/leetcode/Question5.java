package leetcode;

import java.util.ArrayList;

/**
 * @author ken
 * @date 2019/8/27  22:20
 * @description
 */
public class Question5 {

    public static void main(String[] args) {
        int [] i = new int[]{1,2};
        int [] k = new int[]{3};
        ArrayList<Integer> resultArray = new ArrayList<>();
        int sizei = i.length;
        int sizek = k.length;
        for (int m = 0; m < (sizei > sizek ? sizei : sizek); m++) {
            if (m < sizei)
                resultArray.add(i[m]);
            if (m < sizek)
                resultArray.add(k[m]);
        }
        resultArray.sort((a, b) -> {
            return Float.compare(a, b);
        });
        int yushu = resultArray.size() % 2;
        float result = 0f;
        if (yushu == 0) {

            result =(float) (resultArray.get(resultArray.size() / 2) + (float)resultArray.get(resultArray.size() / 2 - 1)) / 2;
        } else {
            System.out.println(resultArray.size() / 2);
            result = resultArray.indexOf(resultArray.size() / 2);
        }
        System.out.println((int) result);

    }
}
