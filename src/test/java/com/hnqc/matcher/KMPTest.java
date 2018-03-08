package com.hnqc.matcher;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class KMPTest {
    @Test
    public void testFindFirst() {
        KMP kmp = new KMP("abafabcdabc");
        int index = kmp.findFirst("dawabafabcdabcdwyjuftgf");
        Assert.assertEquals(3, index);
    }
    @Test
    public void testFindAll() {
        KMP kmp = new KMP("abafabcdabc");
        List<Integer> result = kmp.findAll("dawabafabcdabcdwyjuabafabcdabctabafabcdabcgf");
        Assert.assertEquals(3, result.size());
    }
}
