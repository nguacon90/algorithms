package com.nguacon.textprocessing.patternmatching.impl;

import com.nguacon.textprocessing.util.BasePatternMatchingTest;
import org.junit.Before;

public class BoyerMooreAlgorithmTest  extends BasePatternMatchingTest {

    @Override
    public void setUp() {
        super.setPatternMatchingAlgorithm(new BoyerMooreAlgorithm());
    }
}
