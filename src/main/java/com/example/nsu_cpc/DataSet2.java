package com.example.nsu_cpc;

public class DataSet2 {
    private String firstName1;
    private String lastName1;
    private String mobile1;
    private String study1;
    private String adress1;
    private String birthDate1;
    private String jovExperience1;
    private String otherActivity1;
    private String uniqekey1;











    public DataSet2(String firstName, String lastName,String mobile,String study ,String adress, String birthDate, String jovExperience, String otherActivity, String uniqekey) {
        this.firstName1 = firstName;
        this.lastName1 = lastName;
        this.mobile1= mobile;
        this.study1=  study;
        this.adress1 = adress;
        this.birthDate1 = birthDate;
        this.jovExperience1 = jovExperience;
        this.otherActivity1 = otherActivity;
        this.uniqekey1 = uniqekey;
    }

    public String getFirstName() {
        return firstName1;
    }

    public void setFirstName(String firstName) { this.firstName1 = firstName;
    }

    public String getLastName() {
        return lastName1;
    }

    public void setlastName(String lastName) { this.lastName1 = lastName; }

    public String getMobile() {
        return mobile1;
    }

    public void setMobile(String mobile) {
        this.mobile1 = mobile;
    }

    public String getStudy() {
        return study1;
    }

    public void setStudy(String study) {
        this.study1 = study;
    }

    public String getAdress() {
        return adress1;
    }

    public void setAdress (String adress) {
        this.adress1 = adress;
    }


    public String getBirthDate() {
        return birthDate1;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate1 = birthDate;
    }

    public String getJobexp() {
        return jovExperience1;
    }

    public void setJobexp(String jovExperience) {
        this.jovExperience1 = jovExperience;
    }

    public String getActivity() {
        return otherActivity1;
    }

    public void setActivity(String otherActivity) {
        this.otherActivity1 = otherActivity;
    }

    public String getUniqekey() {
        return uniqekey1;
    }

    public void setUniqekey(String uniqekey) {
        this.uniqekey1 = uniqekey;
    }

}
