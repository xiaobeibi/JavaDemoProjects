package com.bjpowernode.service;

import com.bjpowernode.bean.Lend;

import java.util.List;

public interface LendService {
    List<Lend> select(Lend lend);

    void add(int bookId, int userId);

    List<Lend> returnBook(Lend lend);

    void update(Lend lend);
}
