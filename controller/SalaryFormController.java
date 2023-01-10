package lk.ijse.Fusion.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.Fusion.model.AttendModel;
import lk.ijse.Fusion.model.SalaryModel;
import lk.ijse.Fusion.to.Attendence;
import lk.ijse.Fusion.to.Salary;

import java.sql.SQLException;

public class SalaryFormController {
    public TextField amountTxt;
    public TextField employeeIdTxt;
    public TextField SalaryIdtxt;
    public TextField salaryMethodTxt;
    public TextField txtDetail;


    public void deleteOnAction(ActionEvent actionEvent) {
        String  SalaryID  =  SalaryIdtxt.getText();
        String  EmployeeID =employeeIdTxt.getText();
        double SalaryAmount = Double.parseDouble(amountTxt.getText());
        String SalaryMethod = salaryMethodTxt.getText();
        String  Details = txtDetail.getText();

        Salary salary = new Salary(SalaryID,EmployeeID,SalaryAmount,SalaryMethod,Details);
        try {
            boolean isDeleted = SalaryModel.remove(SalaryIdtxt.getText());

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Salary Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        String  SalaryID  =  SalaryIdtxt.getText();
        String  EmployeeID =employeeIdTxt.getText();
        double SalaryAmount = Double.parseDouble(amountTxt.getText());
        String SalaryMethod = salaryMethodTxt.getText();
        String  Details = txtDetail.getText();

        Salary salary = new Salary(SalaryID,EmployeeID,SalaryAmount,SalaryMethod,Details);
        try {
            boolean isUpdate = SalaryModel.update(salary);

            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Salary Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addOnAction(ActionEvent actionEvent) {
        String  SalaryID  =  SalaryIdtxt.getText();
        String  EmployeeID =employeeIdTxt.getText();
        double SalaryAmount = Double.parseDouble(amountTxt.getText());
        String SalaryMethod = salaryMethodTxt.getText();
        String  Details = txtDetail.getText();


        Salary salary = new Salary(SalaryID,EmployeeID,SalaryAmount,SalaryMethod,Details);
        try {
            boolean isAdded = SalaryModel.addsala(salary);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Salary Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
