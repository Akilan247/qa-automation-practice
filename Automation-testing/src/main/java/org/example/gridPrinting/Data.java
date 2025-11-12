package org.example.gridPrinting;

public class Data {
    private String testCaseName;
    private String testId;

    public Data(String testCaseName,String  testId){
        this.testId = testId;
        this.testCaseName = testCaseName;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }
}
