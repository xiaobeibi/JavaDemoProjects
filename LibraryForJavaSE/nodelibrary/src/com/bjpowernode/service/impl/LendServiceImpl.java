package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Book;
import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.Lend;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.BookDao;
import com.bjpowernode.dao.LendDao;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.BookDaoImpl;
import com.bjpowernode.dao.impl.LendDaoImpl;
import com.bjpowernode.dao.impl.UserDaoImpl;
import com.bjpowernode.service.LendService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class LendServiceImpl implements LendService {

    private LendDao lendDao = new LendDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<Lend> select(Lend lend)  {
        return lendDao.select(lend);
    }

    /**
     * 添加借阅数据
     * @param bookId
     * @param userId
     */
    @Override
    public void add(int bookId, int userId) {
        //根据编号查询图书数据
        Book paramBook = new Book();
        paramBook.setId(bookId);
        List<Book> bookList = bookDao.select(paramBook);

        //根据编号查询用户数据
        User paramUser = new User();
        paramUser.setId(userId);
        List<User> userList = userDao.select(paramUser);

        Lend lend = new Lend();
        //生成编号
        lend.setId(UUID.randomUUID().toString());

        //给图书赋值
        Book book = bookList.get(0);
        book.setStatus(Constant.STATUS_LEND);
        lend.setBook(book);

        //给用户赋值
        User user = userList.get(0);
        user.setLend(true);
        lend.setUser(user);

        //设置出借
        lend.setStatus(Constant.STATUS_LEND);
        //设置归还日期
        LocalDate begin = LocalDate.now();
        lend.setLendDate(begin);
        lend.setReturnDate(begin.plusDays(30));

        //修改图书
        bookDao.update(book);
        //修改用户
        userDao.update(user);
        //添加出借数据
        lendDao.add(lend);

    }

    /**
     * 还书
     * @param lend
     * @return
     */
    @Override
    public List<Lend> returnBook(Lend lend) {
        //获取用户对象和图书对象
        Book book = lend.getBook();
        User user = lend.getUser();
        //修改状态
        book.setStatus(Constant.STATUS_STORAGE);
        user.setLend(false);

        userDao.update(user);
        bookDao.update(book);
        //删除lend数据
        lendDao.delete(lend.getId());

        return lendDao.select(null);
    }

    @Override
    public void update(Lend lend) {
        lendDao.update(lend);
    }
}
