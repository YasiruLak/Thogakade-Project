package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import views.tm.CustomerTm;

import java.sql.*;
import java.util.ArrayList;

public class CustomerSelectAllFormController {
    public TableView <CustomerTm>tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;

    public void initialize(){
        try {

            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

            setCustomersToTable(new CustomerController().getAllCustomers());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setCustomersToTable(ArrayList<Customer> customers) {
        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();
        customers.forEach(e->{
            obList.add(
                    new CustomerTm(e.getId(),e.getName(),e.getAddress(),e.getSalary()));
        });
        tblCustomer.setItems(obList);
    }

}


