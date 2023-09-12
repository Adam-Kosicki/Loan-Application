/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adas
 */

package bean;

import javax.ejb.Remote;

@Remote
public interface LoanBeanRemote {
    
    public double getMonthlyPayment(double annualInterestRate, int numberOfYears, double loanAmount);
    public double getTotalPayment(double annualInterestRate, int numberOfYears, double loanAmount);
    
}
