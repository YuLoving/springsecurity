package cn.nj.springsecurity.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ZTY
 * @date 2019/9/30 10:13
 * 描述：
 */
public class Test01 {

    public static void main(String[] args) {
        String[] strings = {"a", "bb", "cc", "dd", "ee"};

        String s = Arrays.stream(strings).map(c -> c.toString()).collect(Collectors.joining("-"));
        System.out.println(s);
    }
}
