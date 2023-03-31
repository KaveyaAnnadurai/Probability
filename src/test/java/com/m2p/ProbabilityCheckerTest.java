package com.m2p;

import org.junit.jupiter.api.Nested;
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

    @Nested
    class Requirement2 {
        @Test
        void findProbabilityOfTwoSureEventsOccurringTogether() {
            //arrange
            ProbabilityChecker probabilityOfEvent1 = new ProbabilityChecker(1);
            ProbabilityChecker probabilityOfEvent2 = new ProbabilityChecker(1);
            ProbabilityChecker expectedProbability = new ProbabilityChecker(1);

            //act
            ProbabilityChecker actualProbability = probabilityOfEvent1.and(probabilityOfEvent2);

            //assert
            assertThat(expectedProbability, is(equalTo(actualProbability)));
        }

        @Test
        void findProbabilityOfTwoEventsOccurringTogether() {
            //arrange
            ProbabilityChecker probabilityOfEvent1 = new ProbabilityChecker(0.4);
            ProbabilityChecker probabilityOfEvent2 = new ProbabilityChecker(0.5);
            ProbabilityChecker expectedProbability = new ProbabilityChecker(0.2);

            //act
            ProbabilityChecker actualProbability = probabilityOfEvent1.and(probabilityOfEvent2);

            //assert
            assertThat(expectedProbability, is(equalTo(actualProbability)));
        }

        @Test
        void findProbabilityOfTwoEventsNotOccurringTogether() {
            //arrange
            ProbabilityChecker probabilityOfEvent1 = new ProbabilityChecker(0.4);
            ProbabilityChecker probabilityOfEvent2 = new ProbabilityChecker(0.5);
            ProbabilityChecker expectedProbability = new ProbabilityChecker(0.1);

            //act
            ProbabilityChecker actualProbability = probabilityOfEvent1.and(probabilityOfEvent2);

            //assert
            assertThat(expectedProbability, is(not(equalTo(actualProbability))));
        }

    }

    @Nested
    class Requirement3{

        @Test
        void probabilityOfSureEventToNotOccur(){
            //arrange
            ProbabilityChecker probabilityOfEvent = new ProbabilityChecker(0);
            ProbabilityChecker expectedProbability = new ProbabilityChecker(1);

            //act
            ProbabilityChecker actualProbability = probabilityOfEvent.complimentOf(probabilityOfEvent);

            //assert
            assertThat(expectedProbability, is(equalTo(actualProbability)));

        }

        @Test
        void probabilityOfEventToNotOccur(){
            //arrange
            ProbabilityChecker probabilityOfEvent = new ProbabilityChecker(0.4);
            ProbabilityChecker expectedProbability = new ProbabilityChecker(0.6);

            //act
            ProbabilityChecker actualProbability = probabilityOfEvent.complimentOf(probabilityOfEvent);

            //assert
            assertThat(expectedProbability, is(equalTo(actualProbability)));

        }

        @Test
        void checkInequalityForProbabilityOfEventToNotOccur(){
            //arrange
            ProbabilityChecker probabilityOfEvent = new ProbabilityChecker(0.4);
            ProbabilityChecker expectedProbability = new ProbabilityChecker(0.4);

            //act
            ProbabilityChecker actualProbability = probabilityOfEvent.complimentOf(probabilityOfEvent);

            //assert
            assertThat(expectedProbability, is(not(equalTo(actualProbability))));

        }




    }

}
