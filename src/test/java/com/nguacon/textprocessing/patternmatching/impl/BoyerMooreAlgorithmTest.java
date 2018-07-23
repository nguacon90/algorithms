package com.nguacon.textprocessing.patternmatching.impl;

import com.nguacon.textprocessing.util.BasePatternMatchingTest;
import org.junit.Before;

public class BoyerMooreAlgorithmTest  extends BasePatternMatchingTest {

    private BoyerMooreAlgorithm boyerMooreAlgorithm;

    @Before
    public void setUp() {
        boyerMooreAlgorithm = new BoyerMooreAlgorithm();
        super.setPatternMatchingAlgorithm(boyerMooreAlgorithm);
    }
}
