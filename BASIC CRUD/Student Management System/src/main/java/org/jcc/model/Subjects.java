package org.jcc.model;

public class Subjects {

    private String subjectId;
    private String subjectName;
    private double firstGrading;
    private double secondGrading;
    private double thirdGrading;
    private double fourthGrading;

    public Subjects(String subjectId, String subjectName, double firstGrading, double secondGrading, double thirdGrading, double fourthGrading) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.firstGrading = firstGrading;
        this.secondGrading = secondGrading;
        this.thirdGrading = thirdGrading;
        this.fourthGrading = fourthGrading;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectid) {
        this.subjectId = subjectid;
    }

    public Subjects(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getFirstGrading() {
        return firstGrading;
    }

    public void setFirstGrading(double firstGrading) {
        this.firstGrading = firstGrading;
    }

    public double getSecondGrading() {
        return secondGrading;
    }

    public void setSecondGrading(double secondGrading) {
        this.secondGrading = secondGrading;
    }

    public double getThirdGrading() {
        return thirdGrading;
    }

    public void setThirdGrading(double thirdGrading) {
        this.thirdGrading = thirdGrading;
    }

    public double getFourthGrading() {
        return fourthGrading;
    }

    public void setFourthGrading(double fourthGrading) {
        this.fourthGrading = fourthGrading;
    }

    public double getAverage() {
        return (firstGrading + secondGrading + thirdGrading + fourthGrading) / 4;
    }
}
