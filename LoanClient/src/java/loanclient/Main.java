/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adas
 */ 

package loanclient;

import bean.LoanBeanRemote;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @javax.ejb.EJB
    private static LoanBeanRemote loanBean;
    
    private TextField annualInterestRate = new TextField();
    private TextField numberOfYears = new TextField();
    private TextField loanAmount = new TextField();
    private TextField monthlyPayment = new TextField();
    private TextField totalPayment = new TextField();
    private Button calculate = new Button("calculate");
    
    @Override
    public void start(Stage stage1) {
        GridPane gridPane = new GridPane();                     // creating the gui
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Annual Interest rate:"),0,0);
        gridPane.add(annualInterestRate, 1, 0);
        gridPane.add(new Label("Number of years:"), 0, 1);
        gridPane.add(numberOfYears, 1, 1);
        gridPane.add(new Label("Loan Amount"), 0, 2);
        gridPane.add(loanAmount, 1, 2);
        gridPane.add(new Label("Monthly Payment"), 0, 3);
        gridPane.add(monthlyPayment, 1, 3);
        gridPane.add(new Label("Total Payment"), 0, 4);
        gridPane.add(totalPayment, 1, 4);
        gridPane.add(calculate, 1, 5);
        
        gridPane.setAlignment(Pos.CENTER);                      //changing gui properties
        annualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        numberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        loanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        monthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        totalPayment.setAlignment(Pos.BOTTOM_RIGHT);
        monthlyPayment.setEditable(false);
        totalPayment.setEditable(false);
        GridPane.setHalignment(calculate, HPos.RIGHT);
        
        calculate.setOnAction(e -> {            // lamda event processing
        calculateLoanPayment();
        });
       
        Scene scene = new Scene(gridPane,450,300);      //stage and scene
        stage1.setTitle("Loan Calculator: ");
        stage1.setScene(scene);
        stage1.show();
    }
    
    private void calculateLoanPayment() {
        double interest = Double.parseDouble(annualInterestRate.getText());       //getting value from text fields
        int year = Integer.parseInt(numberOfYears.getText());
        double LoanAmount = Double.parseDouble(loanAmount.getText());
        
        monthlyPayment.setText(String.format("$%.2f", loanBean.getMonthlyPayment(interest, year, LoanAmount)));         // displaying the monthly payments and total
        totalPayment.setText(String.format("$%.2f", loanBean.getTotalPayment(interest, year, LoanAmount)));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
