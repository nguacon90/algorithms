package com.nguacon.textprocessing.patternmatching.impl;

import com.nguacon.textprocessing.patternmatching.PatternMatchingAlgorithm;

/**
 * n: text length
 * m: pattern length
 * Performance: O(n * m)
 */
public class BruceForceAlgorithm implements PatternMatchingAlgorithm {

    @Override
    public boolean isMatchPattern(String text, String pattern) {
        if(text == null || pattern == null || text.length() == 0 || pattern.length() == 0) {
            return false;
        }

        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int textLength = text.length();
        int patternLength = pattern.length();
        boolean isMatch = false;
        for(int i=0; i<=textLength-patternLength; i++) {
            int j;
            for(j=0; j<patternLength; j++) {
                if(patternChars[j] != textChars[i + j]) {
                    break;
                }
            }

            if(j == patternLength) {
                isMatch = true;
                break;
            }
        }
        return isMatch;
    }
}
