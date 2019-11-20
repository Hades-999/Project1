/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AccOps;

/**
 *
 * @author HP
 */
public class Account {
    private String accno;
    private String savingsamt;
    private String currentamt;

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getSavingsamt() {
        return savingsamt;
    }

    public void setSavingsamt(String savingsamt) {
        this.savingsamt = savingsamt;
    }

    public String getCurrentamt() {
        return currentamt;
    }

    public void setCurrentamt(String currentamt) {
        this.currentamt = currentamt;
    }
    
}
