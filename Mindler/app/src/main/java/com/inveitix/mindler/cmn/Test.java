package com.inveitix.mindler.cmn;

import java.util.ArrayList;

public class Test {
    private String testName;
    private ArrayList<Question> questions;

    public Test(ArrayList<Question> questions, String testName) {
        this.questions = questions;
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
