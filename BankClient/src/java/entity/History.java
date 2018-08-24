/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DuongTK
 */

@XmlRootElement

public class History implements Serializable {

    public History(String name, BigDecimal amount, BigDecimal fee, Date transactionDate, Integer status, Account accId) {
        this.name = name;
        this.amount = amount;
        this.fee = fee;
        this.transactionDate = transactionDate;
        this.status = status;
        this.accId = accId;
    }

    private Integer id;

    private String name;
  
   
    private BigDecimal amount;
  
    private BigDecimal fee;
    private Date transactionDate;
    
    private Integer status;
    private Account accId;

    public History() {
    }

    public History(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Account getAccId() {
        return accId;
    }

    public void setAccId(Account accId) {
        this.accId = accId;
    }
    
}
