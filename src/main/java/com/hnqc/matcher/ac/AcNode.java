package com.hnqc.matcher.ac;

import java.util.HashMap;
import java.util.Map;

public class AcNode {
    private boolean finish = false;
    private int state = 0;
    private String mode;
    private Map<Character, AcNode> nextMap;

    AcNode(int state) {
        this.state = state;
    }

    public AcNode(int state, String mode) {
        this.state = state;
        this.mode = mode;
    }

    public int getState() {
        return state;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public AcNode next(char ch, AcNode node) {
        if (nextMap == null)
            nextMap = new HashMap<>();
        nextMap.put(ch, node);
        return this;
    }
}
