package com.m2p;

public class ProbabilityChecker {

        private final double probabilityValue;

        public ProbabilityChecker(double probabilityValue){
            this.probabilityValue = probabilityValue;
        }

        @Override
        public boolean equals(Object probabilityObject){
                if(this == probabilityObject){
                        return true;
                }
                if(probabilityObject == null || probabilityObject.getClass() != getClass()){
                     return false;
                }
                ProbabilityChecker that = (ProbabilityChecker) probabilityObject;

                if(that.probabilityValue == probabilityValue)
                        return true;
                return false;
        }
        ProbabilityChecker and(ProbabilityChecker event){
                return new ProbabilityChecker(this.probabilityValue *event.probabilityValue);

        }




}
