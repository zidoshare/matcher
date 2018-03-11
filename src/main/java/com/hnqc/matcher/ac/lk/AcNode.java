package com.hnqc.matcher.ac.lk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AcNode {
    private boolean finish = false;
    private int state = 0;
    private String mode;
    private Map<Character, AcNode> nextMap;
    private AcNode root;

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

    public void next(char ch, AcNode node) {
        if (nextMap == null)
            nextMap = new HashMap<>();
        nextMap.put(ch, node);
    }

    public AcNode next(char ch) {
        return nextMap == null ? null : nextMap.get(ch);
    }

    public Set<Character> nextChars() {
        return nextMap != null ? nextMap.keySet() : new HashSet<>();
    }

    public AcNode getRoot() {
        return root;
    }

    public void setRoot(AcNode root) {
        this.root = root;
    }
}
