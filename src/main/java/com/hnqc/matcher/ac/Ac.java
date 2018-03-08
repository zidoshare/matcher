package com.hnqc.matcher.ac;

import java.util.List;

public class Ac {
    private int lastState = 0;
    /**
     * 状态机根节点
     */
    private AcNode root = new AcNode(0);

    public Ac(List<String> modes) {
        buildTree(modes);
    }

    private void buildTree(List<String> modes) {
        for (String mode : modes) {
            buildTree(mode);
        }
    }

    private void buildTree(String mode) {
        char[] chs = mode.toCharArray();
        AcNode last = root;
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (i == chs.length - 1) {
                last = last.next(ch, new AcNode(++lastState));
            } else {
                last.next(ch, new AcNode(++lastState, mode));
                return;
            }
        }
    }
}
