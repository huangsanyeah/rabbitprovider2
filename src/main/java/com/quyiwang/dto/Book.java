package com.quyiwang.dto;

import java.io.Serializable;

/**
 * @Description
 * @Author huangweiyue
 * @Date Created in 2018-06-19 17:08
 * @ModifiedBy
 * @Version v1.0
 */
//@Data
//@ToString
public class Book implements Serializable{
    private String bookName;
    private String author;

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
