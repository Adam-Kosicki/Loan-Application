/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author adas
 */
 
package bean;

import javax.ejb.Stateless;

@Stateless
public class LoanBean implements LoanBeanRemote {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;
    
    public LoanBean() {
        this(2.5, 1, 1000);
    }
    
    public LoanBean(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }
    
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public int getNumberOfYears() {
        return numberOfYears;
    }
    
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    
    public double getLoanAmount() {
        return loanAmount;
    }
    
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    public double getMonthlyPayment(double annualInterestRate, int numberOfYears, double loanAmount) {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 
        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }
    
    public double getTotalPayment(double annualInterestRate, int numberOfYears, double loanAmount) {
        double totalPayment = getMonthlyPayment(annualInterestRate, numberOfYears, loanAmount) * numberOfYears * 12;
        return totalPayment;
    }
    
    public java.util.Date getLoanDate() {
        return loanDate;
    }
}
