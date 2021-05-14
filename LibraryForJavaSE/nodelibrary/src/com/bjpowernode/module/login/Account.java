package com.bjpowernode.module.login;

import animatefx.animation.*;
import com.bjpowernode.App;
import com.gn.GNAvatarView;
import com.bjpowernode.global.Section;
import com.bjpowernode.bean.Admin;
import com.bjpowernode.global.AdminDetail;
import com.bjpowernode.global.plugin.ViewManager;
import com.bjpowernode.global.plugin.SectionManager;
import com.bjpowernode.service.AdminService;
import com.bjpowernode.global.util.Mask;
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

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * зЂВс
 */
public class Account implements Initializable {

    @FXML
    private GNAvatarView avatar;

    @FXML
    private HBox box_username;
    @FXML
    private HBox box_password;

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    @FXML
    private Label lbl_password;
    @FXML
    private Label lbl_username;

    @FXML
    private Label lbl_error;

    @FXML
    private Button register;

    private RotateTransition rotateTransition = new RotateTransition();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rotateTransition.setNode(avatar);
        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setAutoReverse(true);

        addEffect(username);
        addEffect(password);

        Mask.noInitSpace(username);
        Mask.noSpaces(username);
        setupListeners();
    }

    @FXML
    private void register() throws Exception {
        Pulse pulse = new Pulse(register);
        pulse.setDelay(Duration.millis(20));
        pulse.play();

        if (validUsername() && validPassword()) {

            String user = username.getText();
            String extension = "properties";

            File directory = new File("admin/");
            File file = new File("admin/" + user + "." + extension);

            if (!directory.exists()) {
                directory.mkdir();
                file.createNewFile();
                setProperties();
            } else if (!file.exists()) {
                file.createNewFile();
                setProperties();
            } else {
                lbl_error.setVisible(true);
            }
        } else if (!validUsername()) {
            lbl_username.setVisible(true);
        } else {
            lbl_password.setVisible(true);
        }
    }

    private void setProperties() {

        AdminService adminService = new AdminServiceImpl();

        Section section = new Section(true, username.getText());
        SectionManager.save(section);

        Admin admin = new Admin(username.getText(), password.getText());
        adminService.save(admin);

        AdminDetail detail = App.getAdminDetail();
        detail.setHeader(admin.getUserName());

        App.decorator.addCustom(detail);
        detail.setProfileAction(event -> {
            App.getAdminDetail().getPopOver().hide();
            Main.ctrl.title.setText("Profile");
            Main.ctrl.body.setContent(ViewManager.getInstance().get("profile"));

        });

        detail.setSignAction(event -> {
            App.getAdminDetail().getPopOver().hide();
            SectionManager.save(new Section(false, ""));

            this.password.setText("");
            this.username.setText("");

            App.decorator.setContent(ViewManager.getInstance().get("login"));

            App.decorator.removeCustom(detail);
        });

        App.decorator.setContent(ViewManager.getInstance().get("main"));
    }

    @FXML
    private void back() {
        App.decorator.setContent(ViewManager.getInstance().get("login"));
    }

    private void addEffect(Node node) {
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            rotateTransition.play();
            Pulse pulse = new Pulse(node.getParent());
            pulse.setDelay(Duration.millis(100));
            pulse.setSpeed(5);
            pulse.play();
            node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });

        node.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!node.isFocused())
                node.getParent().setStyle("-icon-color : -dark-gray; -fx-border-color : transparent");
            else node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });
    }

    private boolean validPassword() {
        return !password.getText().isEmpty() && password.getLength() > 3;
    }

    private boolean validUsername() {
        return !username.getText().isEmpty() && username.getLength() > 3;
    }

    private void setupListeners() {
        password.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!validPassword()) {
                if (!newValue) {
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
            if (!validUsername()) {
                if (!newValue) {
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
}
