package com.hnqc.matcher.ac;

import com.hnqc.matcher.MatcherResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * com.hnqc.matcher.ac
 *
 * @author zido
 */
public class AcTest {
    @Test
    public void testFindFirst() {
        List<String> modes = new ArrayList<>();
        modes.add("bcf");
        modes.add("cf");
        modes.add("abc");
        modes.add("gb");
        modes.add("oj");
        Ac ac = new Ac(modes);
        MatcherResult result = ac.findFirst("habcducbisoubv");
        Assert.assertTrue("abc".equals(result.getKeyword()));
        Assert.assertEquals(1,result.getStart());
    }

    @Test
    public void testFindAll(){
        List<String> modes = new ArrayList<>();
        modes.add("bc");
        modes.add("cf");
        modes.add("abc");
        modes.add("oj");
        modes.add("c");
        Ac ac = new Ac(modes);
        List<MatcherResult> result = ac.findAll("bcabcfcnfgh");
        Assert.assertEquals(6,result.size());
    }
    @Test
    public void testFindAll2(){
        List<String> modes = new ArrayList<>();
        modes.add("一个人");
        modes.add("人");
        modes.add("一个");
        Ac ac = new Ac(modes);
        List<MatcherResult> result = ac.findAll("人一个人");
        Assert.assertEquals(4,result.size());
    }
}
