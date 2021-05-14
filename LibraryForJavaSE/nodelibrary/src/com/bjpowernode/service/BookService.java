package com.bjpowernode.service;

import com.bjpowernode.bean.Book;

import java.util.List;

public interface BookService {
    List<Book> select(Book book);

    void add(Book book);

    void delete(int id);

    void update(Book book);
}
