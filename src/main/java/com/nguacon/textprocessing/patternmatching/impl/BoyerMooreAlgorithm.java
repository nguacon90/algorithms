package com.nguacon.textprocessing.patternmatching.impl;

import com.nguacon.textprocessing.patternmatching.PatternMatchingAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreAlgorithm  implements PatternMatchingAlgorithm {

    @Override
    public boolean isMatchPattern(String text, String pattern) {
        if(text == null || pattern == null || text.length() == 0 || pattern.length() == 0) {
            return false;
        }

        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int textLength = text.length();
        int patternLength = pattern.length();
        Map<Character, Integer> last = new HashMap<>();
        for(int i=0; i<textLength; i++) {
            last.put(textChars[i], -1);
        }

        for(int j=0; j<patternLength; j++) {
            last.put(patternChars[j], j);
        }

        int i = patternLength - 1;
        int j = patternLength - 1;
        while (i < textLength) {
            if(textChars[i] == patternChars[j]) {
                if(j == 0) {
                    return true;
                }
                i--;
                j--;
            } else {
                i += patternLength - Math.min(j, 1 + last.get(textChars[i]));
                j = patternLength -1;
            }
        }
        return false;
    }
}
