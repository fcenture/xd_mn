package com.agasa.xd_f371_v0_0_1.controller;

import com.agasa.xd_f371_v0_0_1.dto.Nhap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;


import java.net.URL;
import java.util.*;

public class CreateFormController implements Initializable {
    @FXML
    private TextField dvnTf, dvvcTf, soTf, recvTf, donGiaTf, soLuongTf, tenXDTf;
    @FXML
    private Label dateIf;
    @FXML
    private Button addbtn, delbtn, importbtn, cancelbtn;

    @FXML
    private TableColumn<Integer, Integer> tbTT;
    @FXML
    private TableColumn<Nhap, String> tbTenXD;
    @FXML
    private TableColumn<Nhap, String> tbDonGia;
    @FXML
    private TableColumn<Nhap, String> tbSoLuong;
    @FXML
    private TableColumn<Nhap, String> tbTong;
    @FXML
    private TableColumn<String, String> tbct;
    @FXML
    private TableView<Nhap> tableView;


    private AutoCompletionBinding<String> autoCompletionBinding;
    private String[] _possibleSuggestion = {"factory", "abstract", "singleton", "duplicate", "xiaomi","single", "sign-in","simba"};
    private Set<String> possibleSuggestions = new HashSet<>(Arrays.asList(_possibleSuggestion));

    ObservableList<Nhap> initialData(){
        Nhap nhap = new Nhap("dv1", "dv2","dv1", "dv2","dv1", "dv2","123","465");
        Nhap nhap1 = new Nhap("dv1", "dv2","dv1", "dv2","dv1", "dv2","234","345");
        Nhap nhap2 = new Nhap("dv1", "dv2","dv1", "dv2","dv1", "dv2","345","465");
        return FXCollections.observableArrayList(nhap, nhap1, nhap2);
    }

    @FXML
    private void btnInsert(ActionEvent event){
        Nhap nhap = new Nhap();
        nhap.setTenXD(tenXDTf.getText());
        nhap.setDonGia(donGiaTf.getText());
        tableView.getItems().add(nhap);
        tenXDTf.clear();
        donGiaTf.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        tbTT.setCellValueFactory(new PropertyValueFactory<String, String>("tbTT"));
        tbTenXD.setCellValueFactory(new PropertyValueFactory<Nhap, String>("tenXD"));
        tbDonGia.setCellValueFactory(new PropertyValueFactory<Nhap, String>("donGia"));
        tableView.setItems(initialData());
        TextFields.bindAutoCompletion(tenXDTf, _possibleSuggestion);
        System.out.println(tenXDTf.getText().trim());
        tenXDTf.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER :
                        autoCompletionLearnWord(tenXDTf.getText().trim());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void autoCompletionLearnWord(String newWord) {
        possibleSuggestions.add(newWord);

        if (autoCompletionBinding != null){
            autoCompletionBinding.dispose();
        }
        autoCompletionBinding = TextFields.bindAutoCompletion(tenXDTf, possibleSuggestions);
    }

}
