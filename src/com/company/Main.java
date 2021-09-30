package com.company;

public class Main {

    public static void main(String[] args) {

        PhoneBook nsk = new PhoneBook();
        try{
            Record user1 = new Record(1, "+724", "Boris");
            Record user2 = new Record(2, "+725", "Ivan");
            Record user3 = new Record(3, "+726", "Andrey");
            Record user4 = new Record(4, "+727", "Kiril");
            Record user5 = new Record(5, "+728", "Alex");
            Record user6 = new Record(6, "+729", "Tim");
            Record user7 = new Record(7, "+721", "Bob");
            Record user8 = new Record(8, "+722", "Vlad");
            nsk.createRecord(user1);
            nsk.createRecord(user2);
            nsk.createRecord(user3);
            nsk.createRecord(user4);
            nsk.createRecord(user5);
            nsk.createRecord(user6);
            nsk.createRecord(user7);
            nsk.createRecord(user8);


        } catch (PhoneNumberAlreadyExists e){
            System.out.println("Такое номер уже существует");
        }

        //nsk.PrintUserBook();

        Record newNumber = new Record(3, "+888", "Gachi");
        try{
            nsk.updateRecord(newNumber);
        } catch (RecordNotFound e){
            System.out.printf("Нет такого пользователя");
        } catch (RecordNotValid e){
            System.out.printf("Запись не действительна");
        }

        nsk.PrintUserBook();

        try{
            nsk.deleteRecord(1);
        }catch (RecordNotFound e){
            System.out.printf("Вы не можете удалить не существующую запись");
        }
        nsk.PrintUserBook();


    }
}
