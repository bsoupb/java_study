package day1.주문시스템의불변객체.레코드를활용한dto;

import day1.주문시스템의불변객체.레코드를활용한dto.개선.CustomerRecord;

public class Main {
    public static void main(String[] args) {
        CustomerRecord record = new CustomerRecord("tt", "tt", "tt");
        
        record.name();  // get이 붙지 않음
    }
}
