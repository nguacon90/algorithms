package com.nguacon.textprocessing.util;

public class MatchStringObj {
    private String text;
    private String pattern;
    private boolean isMatch;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "MatchStringObj{" +
                "text='" + text + '\'' +
                ", pattern='" + pattern + '\'' +
                ", match='" + isMatch + '\'' +
                '}';
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }
}
