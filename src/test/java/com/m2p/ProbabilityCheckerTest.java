package com.m2p;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class ProbabilityCheckerTest {
    @Test
    void toCheckProbabilityOfHeadsEqualToProbabilityOfTails(){
       ProbabilityChecker probabilityOfHeads = new ProbabilityChecker(0.5);
       ProbabilityChecker probabilityOfTails = new ProbabilityChecker(0.5);

       assertThat(probabilityOfHeads, is(equalTo(probabilityOfTails)));
    }
    @Test
    void toCheckInEqualiyProbabilityOfHeadsEqualToProbabilityOfTails(){
        ProbabilityChecker probabilityOfHeads = new ProbabilityChecker(0.4);
        ProbabilityChecker probabilityOfTails = new ProbabilityChecker(0.5);

        assertThat(probabilityOfHeads, is(not(equalTo(probabilityOfTails))));
    }





}
