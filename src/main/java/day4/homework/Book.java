package day4.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;
    private double rating;
    private int pages;
    private double price;
}
