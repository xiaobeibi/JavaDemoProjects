
package com.bjpowernode.module.login;

import animatefx.animation.Flash;
import animatefx.animation.Pulse;
import animatefx.animation.SlideInLeft;
import com.gn.GNAvatarView;
import com.bjpowernode.App;
import com.bjpowernode.bean.Admin;
import com.bjpowernode.global.AdminDetail;
import com.bjpowernode.global.Section;
import com.bjpowernode.global.plugin.SectionManager;
import com.bjpowernode.service.AdminService;
import com.bjpowernode.global.plugin.ViewManager;
import com.bjpowernode.module.main.Main;
import com.bjpowernode.service.impl.AdminServiceImpl;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/*
    管理员登录
 */
public class Login implements Initializable {

    @FXML private GNAvatarView avatar;
    @FXML private HBox box_username;
    @FXML private HBox box_password;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Button login;

    @FXML private Label lbl_password;
    @FXML private Label lbl_username;
    @FXML private Label lbl_error;

    private RotateTransition rotateTransition = new RotateTransition();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rotateTransition.setNode(avatar);
        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setAutoReverse(true);

        addEffect(password);
        addEffect(username);

        setupListeners();

    }

    private void addEffect(Node node){
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            rotateTransition.play();
            Pulse pulse = new Pulse(node.getParent());
            pulse.setDelay(Duration.millis(100));
            pulse.setSpeed(5);
            pulse.play();
            node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });

        node.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!node.isFocused())
                node.getParent().setStyle("-icon-color : -dark-gray; -fx-border-color : transparent");
            else node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });
    }

    private void setupListeners(){
        password.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validPassword()){
                if(!newValue){
                    Flash swing = new Flash(box_password);
                    lbl_password.setVisible(true);
                    new SlideInLeft(lbl_password).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_password.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_password.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });

        username.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validUsername()){
                if(!newValue){
                    Flash swing = new Flash(box_username);
                    lbl_username.setVisible(true);
                    new SlideInLeft(lbl_username).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_username.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_username.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });
    }

    /*
        校验密码
     */
    private boolean validPassword(){
        return !password.getText().isEmpty() && password.getLength() > 3;
    }

    /*
        校验用户名
     */
    private boolean validUsername(){
        return !username.getText().isEmpty() && username.getLength() > 3;
    }


    /*
        登录
     */
    @FXML
    private void loginAction(){
        Pulse pulse = new Pulse(login);
        pulse.setDelay(Duration.millis(20));
        pulse.play();
        if(validPassword() && validUsername())
            enter();
        else {
            lbl_password.setVisible(true);
            lbl_username.setVisible(true);
        }
    }


    private void enter() {
        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.get(username.getText());

        //检查是否输入了正确的用户名和密码
        if(admin.getUserName().equals(this.username.getText()) && admin.getPassword().equals(this.password.getText())){
            Section section = new Section();
            section.setLogged(true);
            section.setUserLogged(this.username.getText());
            SectionManager.save(section);

            App.decorator.setContent(ViewManager.getInstance().get("main"));

            AdminDetail detail = App.getAdminDetail();
            detail.setHeader(admin.getUserName());

            App.decorator.addCustom(App.getAdminDetail());

            App.getAdminDetail().setProfileAction(event -> {
                App.getAdminDetail().getPopOver().hide();
                Main.ctrl.title.setText("Profile");
                Main.ctrl.body.setContent(ViewManager.getInstance().get("profile"));
            });

            App.getAdminDetail().setSignAction(event -> {
                App.getAdminDetail().getPopOver().hide();
                App.decorator.setContent(ViewManager.getInstance().get("Login"));
                this.username.setText("");
                this.password.setText("");
                if(Main.popConfig.isShowing()) Main.popConfig.hide();
                if(Main.popup.isShowing()) Main.popup.hide();
                App.decorator.removeCustom(App.getAdminDetail());
            });

        } else {
            lbl_error.setVisible(true);
        }
    }

    @FXML
    private void switchCreate(){
        App.decorator.setContent(ViewManager.getInstance().get("account"));
    }
}
