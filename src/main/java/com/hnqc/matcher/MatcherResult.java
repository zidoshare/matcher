package com.hnqc.matcher;

public class MatcherResult {
    private int start;
    private int end;
    private CharSequence keyword;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public CharSequence getKeyword() {
        return keyword;
    }

    public void setKeyword(CharSequence keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "result{" +
                "start=" + start +
                ", end=" + end +
                ", keyword=" + keyword +
                '}';
    }
}
