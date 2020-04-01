package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class smsConsoleController {

    public static final  String ACCOUNT_SID = "AC5719a77acdb8a8bded86362aa37e2710";
    public static final String  AUTH_TOKEN = "d94c288678d041d0452e3a5aa545bd5d";
    Alert alert;


    @FXML
    private JFXTextArea textArea;

    @FXML
    private JFXButton sendButton;

    @FXML
    void sendSms(ActionEvent event) {

        try{

            Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
            Message message = Message.creator(new PhoneNumber("+94710809862"),
                    new PhoneNumber("+13367702108"), textArea.getText().toString()).create();

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("");
            alert.setContentText("SMS Send Successfully");
            alert.show();

        } catch (Exception e){

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Failed");
            alert.setHeaderText("");
            alert.setContentText("Something went wrong:"+e.toString());
            e.printStackTrace();
            alert.show();
        }

    }


}
