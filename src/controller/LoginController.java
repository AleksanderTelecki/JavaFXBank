package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.*;
import utils.dbclasses.Bank;
import utils.dbclasses.BankUser;

import java.util.List;

public class LoginController implements Initializer {

    @FXML
    private Pane Pane_LogIn;

    @FXML
    private TextField TextBox_Email;

    @FXML
    private TextField TextBox_Password;

    @FXML
    private TextField TextBox_BacN;

    @FXML
    private Button Button_Admin;

    @FXML
    private Button Button_LogIn;

    @FXML
    private Button Button_NewAccount;

    private WindowController starter = new WindowController();


    @FXML
    void AdminLogin(ActionEvent event) {
        starter.Show((Stage) Pane_LogIn.getScene().getWindow(), WindowController.windowType.AdminLogIn);

    }

    @FXML
    void LogIn(ActionEvent event) {
        // TODO: 28.05.2021 Data checking function or class?
        List<BankUser> bankUsers = DBcontroller.getBankUserList();

        if (bankUsers.size() != 0) {
            //starter.Show((Stage) Pane_LogIn.getScene().getWindow(), WindowStarter.windowType.User,bankUsers.get(0));
            starter.Show(WindowController.windowType.User,bankUsers.get(0).getID());
            Message.showMessage(Alert.AlertType.INFORMATION,"Inf",Double.toString(Bank.getDepositPercentage()));

        }else{

        }


    }

    @FXML
    void NewAccount(ActionEvent event) {

        // TODO: 28.05.2021 Data checking function or class?
        starter.Show((Stage) Pane_LogIn.getScene().getWindow(), WindowController.windowType.Registration);


    }


    @Override
    public void Initialize(Object object) {
        BankUser user = (BankUser) object;

    }
}