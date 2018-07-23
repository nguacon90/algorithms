package com.nguacon.textprocessing.patternmatching.impl;

import com.nguacon.textprocessing.util.BasePatternMatchingTest;

public class KnuthMorrisPrattAlgorithmTest extends BasePatternMatchingTest {

    @Override
    public void setUp() {
        super.setPatternMatchingAlgorithm(new KnuthMorrisPrattAlgorithm());
    }
}
