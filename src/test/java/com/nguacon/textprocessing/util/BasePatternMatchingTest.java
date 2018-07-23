package com.nguacon.textprocessing.util;


import com.nguacon.textprocessing.patternmatching.PatternMatchingAlgorithm;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class BasePatternMatchingTest {

    private PatternMatchingAlgorithm patternMatchingAlgorithm;

    @Before
    public abstract void setUp();

    public List<MatchStringObj> readTestCase(String fileName) throws IOException {
        List<MatchStringObj> results = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        int i = 0;
        MatchStringObj obj = new MatchStringObj();
        boolean isRead = false;
        for (String line; (line = reader.readLine()) != null;) {
            if(i == 0) {
                obj.setText(line);
                isRead = false;
            } else  if (i == 1){
                obj.setPattern(line);
            } else {
                obj.setMatch(Boolean.valueOf(line));
                results.add(obj);
                isRead = true;

            }

            if(isRead == true) {
                obj = new MatchStringObj();
                i = 0;
            } else {
                i++;
            }

        }

        return results;
    }

    public void test(String fileName) {
        try {
            List<MatchStringObj> matchStringObjs = this.readTestCase(fileName);
            for(MatchStringObj matchStringObj : matchStringObjs) {
                long startTime = System.currentTimeMillis();
                boolean matchPattern = getPatternMatchingAlgorithm().isMatchPattern(matchStringObj.getText(), matchStringObj.getPattern());
                long endTime = System.currentTimeMillis();
                assertEquals("Pass test case", matchStringObj.isMatch(), matchPattern);
                System.out.println("Pert time test " + fileName + " : " + (endTime - startTime));
            }
        } catch (IOException e) {
            e.printStackTrace();
            fail("exception occurs");
        }
    }

    public PatternMatchingAlgorithm getPatternMatchingAlgorithm() {
        return patternMatchingAlgorithm;
    }

    public void setPatternMatchingAlgorithm(PatternMatchingAlgorithm patternMatchingAlgorithm) {
        this.patternMatchingAlgorithm = patternMatchingAlgorithm;
    }

    @Test
    public void isPatternMatch_TextIsNull_ReturnFalse() {
        String text = null;
        String pattern = "abacab";

        boolean matchPattern = getPatternMatchingAlgorithm().isMatchPattern(text, pattern);
        assertFalse(matchPattern);
    }

    @Test
    public void isPatternMatch_PatternIsNull_ReturnFalse() {
        String text = "aaaa";
        String pattern = null;

        boolean matchPattern = getPatternMatchingAlgorithm().isMatchPattern(text, pattern);
        assertFalse(matchPattern);
    }

    @Test
    public void isPatternMatch_PatternIsEmpty_ReturnFalse() {
        String text = "aaaa";
        String pattern = "";

        boolean matchPattern = getPatternMatchingAlgorithm().isMatchPattern(text, pattern);
        assertFalse(matchPattern);
    }

    @Test
    public void isPatternMatch_TextIsEmpty_ReturnFalse() {
        String text = "";
        String pattern = "asb";

        boolean matchPattern = getPatternMatchingAlgorithm().isMatchPattern(text, pattern);
        assertFalse(matchPattern);
    }

    @Test
    public void isPatternMatch_ReturnTrue() {
        String text = "abacaabaccabacabaabb";
        String pattern = "abacab";

        boolean matchPattern = getPatternMatchingAlgorithm().isMatchPattern(text, pattern);
        assertTrue(matchPattern);
    }

    @Test
    public void isPatternMatch_ReturnTrue_case2() {
        String text = "abacaabaccabacabaabbsjhasjdhjahdjasdghasgdhasdghasgdhasdghasgdhasgdhghd asdghasgdh";
        String pattern = "hasgdh";

        boolean matchPattern = getPatternMatchingAlgorithm().isMatchPattern(text, pattern);
        assertTrue(matchPattern);
    }

    @Test
    public void isPatternMatch_NotMatching_ReturnFalse() {
        String text = "aaaaa";
        String pattern = "asb";

        boolean matchPattern = getPatternMatchingAlgorithm().isMatchPattern(text, pattern);
        assertFalse(matchPattern);
    }

    @Test
    public void advanceTestCase_01() {
        this.test("patternmatching.input1");
    }

    @Test
    public void advanceTestCase_02() {
        this.test("patternmatching.input2");
    }

    @Test
    public void hardAdvanceTestCase_03() {
        this.test("hardpatternmatching.input3");
    }

    @Test
    public void hardAdvanceTestCase_04() {
        this.test("hardpatternmatching.input4");
    }
}
