package com.nguacon.textprocessing.patternmatching.impl;

import com.nguacon.textprocessing.patternmatching.PatternMatchingAlgorithm;

/**
 * n: text length
 * m: pattern length
 * Performance: O(n + m)
 */
public class KnuthMorrisPrattAlgorithm implements PatternMatchingAlgorithm {

    @Override
    public boolean isMatchPattern(String text, String pattern) {
        if(text == null || pattern == null || text.length() == 0 || pattern.length() == 0) {
            return false;
        }

        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int textLength = text.length();
        int patternLength = pattern.length();
        int[] fail = computeFailKMP(patternChars);
        int j = 0;
        int k = 0;
        while (j < textLength) {
            if(textChars[j] == patternChars[k]) {
                if(k == patternLength - 1) {
                    return true;
                }
                j++;
                k++;
            } else if (k>0){
                k = fail[k-1];
            } else {
                j++;
            }
        }
        return false;
    }

    private int[] computeFailKMP(char[] patternChars) {
        int m = patternChars.length;
        int[ ] fail = new int[m];
        int j = 1;
        int k = 0;
        while (j < m) {
            if(patternChars[j] == patternChars[k]) {
                fail[j] = k+1;
                j++;
                k++;
            } else if(k > 0) {
                k = fail[k-1];
            } else {
                j++;
            }
        }

        return fail;
    }
}
