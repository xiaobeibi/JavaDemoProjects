
package com.bjpowernode.module.book;

import com.bjpowernode.service.BookService;
import com.bjpowernode.service.impl.BookServiceImpl;
import com.gn.App;
import com.bjpowernode.bean.Book;
import com.bjpowernode.bean.Constant;
import com.bjpowernode.global.util.Alerts;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 图书管理
 *
 * @author admin
 */
public class BookViewCtrl implements Initializable {

    @FXML
    private TableView<Book> bookTableView;
    @FXML
    private TableColumn<Book, String> c1;
    @FXML
    private TableColumn<Book, String> c2;
    @FXML
    private TableColumn<Book, String> c3;
    @FXML
    private TableColumn<Book, String> c4;
    @FXML
    private TableColumn<Book, String> c5;
    @FXML
    private TableColumn<Book, String> c6;
    @FXML
    private TableColumn<Book, String> c7;

    @FXML
    private TextField bookNameField;

    @FXML
    private TextField isbnField;

    ObservableList<Book> books = FXCollections.observableArrayList();

    private BookService bookService = new BookServiceImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

/*
        books.add(new Book(1, "java实战入门", "张三", Constant.TYPE_COMPUTER, "12-987", "XX出版社", Constant.STATUS_STORAGE));
        books.add(new Book(2, "编程之道", "李四", Constant.TYPE_COMPUTER, "1245-987", "XX出版社", Constant.STATUS_STORAGE));
        books.add(new Book(3, "颈椎病康复指南", "王五", Constant.TYPE_COMPUTER, "08712-987", "XX出版社", Constant.STATUS_STORAGE));
*/
        //查询
        List<Book> bookList = bookService.select(null);
        books.addAll(bookList);

        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        c3.setCellValueFactory(new PropertyValueFactory<>("author"));
        c4.setCellValueFactory(new PropertyValueFactory<>("type"));
        c5.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        c6.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        c7.setCellValueFactory(new PropertyValueFactory<>("status"));
        bookTableView.setItems(books);

    }

    /*
        借书
     */
    @FXML
    private void lendBook() {
        try {
            Book book = this.bookTableView.getSelectionModel().getSelectedItem();
            if (book == null || Constant.STATUS_LEND.equals(book.getStatus())){
                Alerts.warning("未选择","请选择可借阅的书籍");
                return;
            }

            initLendStage(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteBook() {
        try {
            Book book = this.bookTableView.getSelectionModel().getSelectedItem();
            if (book == null){
                Alerts.warning("未选择","请先选择要删除的书籍");
                return;
            }
            bookService.delete(book.getId());
            this.books.remove(book);
            Alerts.success("成功", "图书删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            Alerts.error("失败","图书删除失败");
        }
    }

    /*
        查询
     */
    @FXML
    private void bookSelect(){
        //获取用户输入的姓名和isbn
        String bookName = bookNameField.getText();
        String isbn = isbnField.getText();
        boolean bookFlag = "".equals(bookName);
        boolean isbnFlag = "".equals(isbn);

        Book book = new Book();
        book.setBookName(bookName);
        book.setIsbn(isbn);
        //根据条件查询图书
        List<Book> bookList = bookService.select(book);
/*
        ObservableList<Book> result = books;
        if (bookFlag && isbnFlag) {
            return;
        }else {
            if (!bookFlag){
                result = books.filtered(s -> s.getBookName().contains(bookName));
            }
            if (!isbnFlag) {
                result = books.filtered(s -> s.getIsbn().contains(isbn));
            }
        }
*/
        books = new ObservableListWrapper<Book>(new ArrayList<Book>(bookList));
        bookTableView.setItems(books);
    }

    /*
        修改
     */
    @FXML
    private void bookEditView(MouseEvent event) {
        try {
            Book book = this.bookTableView.getSelectionModel().getSelectedItem();
            if (book == null){
                Alerts.warning("未选择","请先选择要修改的书籍");
                return;
            }

           initStage(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        添加
     */
    @FXML
    private void bookAddView() {
        try {
            initStage(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    初始化借阅stage
 */
    private void initLendStage(Book book) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/com/bjpowernode/module/book/BookLendView.fxml"));
        StackPane target = (StackPane) loader.load();
        Scene scene = new Scene(target);

        Stage stage = new Stage();//创建舞台；
        BookLendViewCtrl controller = (BookLendViewCtrl)loader.getController();
        controller.setBookTableView(bookTableView);
        controller.setStage(stage);
        controller.setBook(book);
        stage.setHeight(800);
        stage.setWidth(700);
        //设置窗口图标
        stage.getIcons().add(new Image("icon.png"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene); //将场景载入舞台；
        stage.show(); //显示窗口；
    }

    /*
        初始化stage
     */
    private void initStage(Book book) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/com/bjpowernode/module/book/BookHandleView.fxml"));
        StackPane target = (StackPane) loader.load();
        //Scene scene1 = App.getDecorator().getScene();
        Scene scene = new Scene(target);


        Stage stage = new Stage();//创建舞台；
        BookHandleViewCtrl controller = (BookHandleViewCtrl)loader.getController();
        controller.setStage(stage);
        controller.setBooks(books);
        controller.setBook(book);
        controller.setBookTableView(bookTableView);
//        stage.setResizable(false);
        stage.setHeight(800);
        stage.setWidth(700);
        //设置窗口图标
        stage.getIcons().add(new Image("icon.png"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene); //将场景载入舞台；
        stage.show(); //显示窗口；
    }
}
