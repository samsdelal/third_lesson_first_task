package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class PhoneBook {

    private ArrayList<Record> phoneUsers = new ArrayList<>();


    public ArrayList<Record> getAllRecords(){
        return this.phoneUsers;
    }
    public void createRecord(Record record) throws PhoneNumberAlreadyExists{
        if(this.checkRecord(record.getPhoneNum())){
            throw new PhoneNumberAlreadyExists();
        }else{
            this.phoneUsers.add(record);
        }
    }

    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid{
        if(record.getName().isEmpty() || record.getPhoneNum().isEmpty() ||
                record.getName().equals("") || record.getPhoneNum().equals("")){
            throw new RecordNotValid();
        }else if(!this.checkUser(record.getId())){
            throw new RecordNotFound();
        }else{
            for(Record i: this.phoneUsers){
                if (i.getId() == record.getId()){
                    i.setName(record.getName());
                    i.setPhoneNum(record.getPhoneNum());
                }
            }
        }
    }
    public void deleteRecord(long id) throws RecordNotFound{
        if(!this.checkUser(id)){
            throw new RecordNotFound();
        }else{this.phoneUsers.remove(findUserIndex(id));}
    }



    private boolean checkRecord(String num){
        for(Record rec: this.phoneUsers){
            if(Objects.equals(rec.getPhoneNum(), num)){
                return true;
            }
        }
        return false;
    }
    private boolean checkUser(long id){
        for(Record i: this.phoneUsers){
            if(i.getId() == id){
                return true;
            }
        }
        return false;
    }
    private int findUserIndex(long id){
        int ind = 0;
        for(int i = 0; i < this.phoneUsers.size(); i++){
            if(this.phoneUsers.get(i).getId() == id){
                ind = i;
            }
        }
        return ind;
    }

    public void PrintUserBook(){
        for(Record i: this.phoneUsers){
            System.out.printf("id - %s, num - %s, name - %s\n", i.getId(),i.getPhoneNum(), i.getName());
        }
    }

}
