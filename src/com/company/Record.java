package com.company;

public class Record {
    private long id;
    private String phoneNumber;
    private String name;


    public Record(long id, String phoneNum, String nam){
        this.id = id;
        this.phoneNumber = phoneNum;
        this.name = nam;
    }


    public long getId(){
        return this.id;
    }
    public String getPhoneNum(){
        return this.phoneNumber;
    }
    public String getName(){
        return this.name;
    }


    public void setId(long id){
        this.id = id;
    }
    public void setPhoneNum(String number){
        this.phoneNumber = number;
    }
    public void setName(String name){
        this.name = name;
    }
}
