package model.entitites;

import model.exceptions.BusinessException;

public class Account {

    private Integer accountNumber;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer accountNumber, String holder, Double balance, Double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }
    public void withdraw(Double amount) throws BusinessException {
        if ( getWithdrawLimit() < amount){
            throw new BusinessException("The amount exceeds withdraw limit");
        }
        if ( amount > getBalance()){
            throw new BusinessException("Not enough balance!");
        }
        balance -= amount;
    }
}
