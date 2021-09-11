package jdk8;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * describe:
 *
 * @author syh
 * @date 2020/08/22
 */
public class StreamExample {


    @Test
    public void test() {
        List<String> strings = Arrays.asList("c++", "java", "python", "yiyuyan", "sun", "sout", "java", "andr");
        //过滤函数
        List<String> collect = strings.stream().filter(value -> StringUtils.isNotBlank(value)).collect(Collectors.toList());
        System.out.println(collect.toString());


        //排序
        List<String> collect1 = strings.stream().filter(value -> StringUtils.isNotBlank(value)).sorted((value1, value2) -> {
            return value1.compareTo(value2);
        }).collect(Collectors.toList());
        System.out.println(collect1.toString());

        //映射
        List<String> collect2 = strings.stream().map(value -> value.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect2.toString());

        //限流
        List<String> collect3 = strings.stream().limit(3).collect(Collectors.toList());
        System.out.println(collect3.toString());

        //忽略，skip和limit 可以实现分页的效果
        List<String> collect4 = strings.stream().skip(3).limit(3).collect(Collectors.toList());
        System.out.println(collect4.toString());

        //清除重复的元素
        String collect5 = strings.stream().distinct().collect(Collectors.joining(","));
        System.out.println(collect5);

        //allMatch----检查是否匹配所有元素
        boolean b = strings.stream().allMatch(value -> {
            return value.length() > 10;
        });
        System.out.println(b);


        //max
        Optional<String> max = strings.stream().max((value1, valu2) -> {
            return value1.length() - valu2.length();
        });
        String s = max.get();
        System.out.println(s);


        //foreach 遍历
        strings.stream().forEach((value) -> {
            System.out.println(value);
        });


        //获取流中的元素总数
        long count = strings.stream().count();
        System.out.println(count+"：元素");
    }
}
