package com.bjpowernode.bean;

import java.io.Serializable;
import java.util.Objects;

/*
    图书
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    //编号
    private int id;
    //书名
    private String bookName;
    //作者
    private String author;
    //类型
    private String type;
    //isbn
    private String isbn;
    //出版社
    private String publisher;
    //状态
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(author, book.author) &&
                Objects.equals(type, book.type) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(status, book.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, author, type, isbn, publisher, status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Book() {
    }

    public Book(int id, String bookName, String author, String type, String isbn, String publisher, String status) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.type = type;
        this.isbn = isbn;
        this.publisher = publisher;
        this.status = status;
    }
}
