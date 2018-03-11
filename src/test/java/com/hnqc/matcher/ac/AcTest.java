package com.hnqc.matcher.ac;

import com.hnqc.matcher.MatcherResult;
import com.hnqc.matcher.ac.lk.Ac;
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
        Assert.assertTrue(result.size() > 0);
    }
    @Test
    public void testFindAll2(){
        List<String> modes = new ArrayList<>();
        modes.add("abc");
        modes.add("c");
        modes.add("bc");
        Ac ac = new Ac(modes);
        List<MatcherResult> result = ac.findAll("cabc");
        Assert.assertTrue(result.size() > 0);
    }
}
