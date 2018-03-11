package com.hnqc.matcher;

import com.hnqc.matcher.ac.Ac;

import java.util.List;

/**
 * 匹配工具类
 *
 * @author zido
 */
public class Matcher {
    public static KMP create(String mode) {
        return new KMP(mode);
    }

    public static Ac create(List<String> modes) {
        return new Ac(modes);
    }
}
