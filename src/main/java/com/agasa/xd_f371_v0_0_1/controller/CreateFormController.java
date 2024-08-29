package com.agasa.xd_f371_v0_0_1.controller;

import com.agasa.xd_f371_v0_0_1.dto.ImportDto;
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
    private TextField dvnTf, dvvcTf, soTf, recvTf,tcNhap,lenhKHso,soXe,
            donGiaTf, phaiXuatTf, tenXDTf,thucXuatTf,tThucTe, vcf,tyTrong;
    @FXML
    private Label dateIf;
    @FXML
    private Button addbtn, delbtn, importbtn, cancelbtn;

    @FXML
    private TableColumn<Integer, Integer> tbTT;
    @FXML
    private TableColumn<ImportDto, String> tbTenXD,tbDonGia, tbPx,tbNhietDo, tbTyTrong, tbVCf, tbTx, tbThanhTien;
    @FXML
    private TableView<ImportDto> tableView;


    private AutoCompletionBinding<String> autoCompletionBinding;
    private String[] _possibleSuggestion = {"factory", "abstract", "singleton", "duplicate", "xiaomi","single", "sign-in","simba"};
    private Set<String> possibleSuggestions = new HashSet<>(Arrays.asList(_possibleSuggestion));

    ObservableList<ImportDto> initialData(){
        return FXCollections.observableArrayList();
    }

    @FXML
    private void btnInsert(ActionEvent event){
        ImportDto importDto = new ImportDto();
        importDto.setDvn(dvnTf.getText());
        importDto.setDvvc(dvvcTf.getText());
        importDto.setSo(soTf.getText());
        importDto.setNguoiNhanHang(recvTf.getText());
        importDto.setTcNhap(tcNhap.getText());
        importDto.setLenhKHso(lenhKHso.getText());
        importDto.setSoXe(soXe.getText());
        importDto.setDonGia(Double.parseDouble(donGiaTf.getText()));
        importDto.setPx(Integer.parseInt(phaiXuatTf.getText()));
        importDto.setTenXD(tenXDTf.getText());
        importDto.setTenXD(tenXDTf.getText());
        importDto.setTx(Integer.parseInt(thucXuatTf.getText()));
        importDto.setNhietDoTT(Integer.parseInt(tThucTe.getText()));
        importDto.setVcf(Integer.parseInt(vcf.getText()));
        importDto.setTyTrong(Integer.parseInt(tyTrong.getText()));
        importDto.setThanhTien(Double.parseDouble(thucXuatTf.getText())* Double.parseDouble(donGiaTf.getText()));
        tableView.getItems().add(importDto);
        addNewImport(importDto);
        clearHH();
    }

    private void addNewImport(ImportDto importDto){
        tbTenXD.setCellValueFactory(new PropertyValueFactory<ImportDto, String>("tenXD"));
        tbDonGia.setCellValueFactory(new PropertyValueFactory<ImportDto, String>("donGia"));
        tbPx.setCellValueFactory(new PropertyValueFactory<ImportDto, String>("px"));
        tbTx.setCellValueFactory(new PropertyValueFactory<ImportDto, String>("tx"));
        tbNhietDo.setCellValueFactory(new PropertyValueFactory<ImportDto, String>("nhietDoTT"));
        tbVCf.setCellValueFactory(new PropertyValueFactory<ImportDto, String>("vcf"));
        tbTyTrong.setCellValueFactory(new PropertyValueFactory<ImportDto, String>("tyTrong"));
        tbThanhTien.setCellValueFactory(new PropertyValueFactory<ImportDto, String>("thanhTien"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    private void clearHH(){
        tenXDTf.clear();
        donGiaTf.clear();
        phaiXuatTf.clear();
        thucXuatTf.clear();
        tThucTe.clear();
        vcf.clear();
        tyTrong.clear();
    }

}
