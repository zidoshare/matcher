package com.hnqc.matcher;

import java.util.ArrayList;
import java.util.List;

/**
 * kmp算法
 *
 * @author zido
 */
public class KMP {

    //回文串数组，纪录移动位置
    private int[] next;
    //关键字
    private CharSequence keyword;

    KMP(CharSequence str) {
        int len = str.length();
        next = new int[len];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < len; i++) {
            while (j > -1 && str.charAt(j + 1) != str.charAt(i)) {
                j = next[j];
            }
            if (str.charAt(j + 1) == str.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        this.keyword = str;
    }

    public int findFirst(CharSequence target) {
        int j = -1;
        int targetLen = target.length();
        int keyLen = keyword.length();
        for (int i = 1; i < targetLen; i++) {
            while (j > -1 && keyword.charAt(j + 1) != target.charAt(i))
                j = next[j];
            if (keyword.charAt(j + 1) == target.charAt(i)) {
                j++;
            }
            if (j == keyLen - 1) return i - keyLen + 1;//匹配成功，返回匹配位置s
        }
        return -1;//匹配失败
    }

    public List<Integer> findAll(CharSequence target) {
        List<Integer> result = new ArrayList<>();
        int j = -1;
        int targetLen = target.length();
        int keyLen = keyword.length();
        for (int i = 1; i < targetLen; i++) {
            while (j > -1 && keyword.charAt(j + 1) != target.charAt(i))
                j = next[j];
            if (keyword.charAt(j + 1) == target.charAt(i)) {
                j++;
            }
            if (j == keyLen - 1) {
                result.add(i - keyLen + 1);
                j = -1;
            }
        }
        return result;
    }

}
