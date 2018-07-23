package com.nguacon.textprocessing.patternmatching.impl;

import com.nguacon.textprocessing.util.BasePatternMatchingTest;
import org.junit.Before;

public class BruceForceAlgorithmTest extends BasePatternMatchingTest {
    private BruceForceAlgorithm bruceForceAlgorithm;


    @Before
    public void setUp() {
        bruceForceAlgorithm = new BruceForceAlgorithm();
        super.setPatternMatchingAlgorithm(bruceForceAlgorithm);
    }
}
