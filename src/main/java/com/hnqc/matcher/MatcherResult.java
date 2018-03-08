package com.hnqc.matcher;

public class MatcherResult {
    private int start;
    private String keyword;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "result{" +
                "start=" + start +
                ", keyword=" + keyword +
                '}';
    }
}
