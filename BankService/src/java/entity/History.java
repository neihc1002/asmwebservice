/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DuongTK
 */
@Entity
@Table(name = "HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h")
    , @NamedQuery(name = "History.findById", query = "SELECT h FROM History h WHERE h.id = :id")
    , @NamedQuery(name = "History.findByName", query = "SELECT h FROM History h WHERE h.name = :name")
    , @NamedQuery(name = "History.findByAmount", query = "SELECT h FROM History h WHERE h.amount = :amount")
    , @NamedQuery(name = "History.findByDate", query = "SELECT h FROM History h WHERE h.accId.id = :accid and h.transactionDate BETWEEN :startdate and :enddate")
    , @NamedQuery(name = "History.findByFee", query = "SELECT h FROM History h WHERE h.fee = :fee")
    , @NamedQuery(name = "History.findByTransactionDate", query = "SELECT h FROM History h WHERE h.transactionDate = :transactionDate")
    , @NamedQuery(name = "History.findByStatus", query = "SELECT h FROM History h WHERE h.status = :status")})
public class History implements Serializable {

    public History(String name, BigDecimal amount, BigDecimal fee, Date transactionDate, Integer status, Account accId) {
        this.name = name;
        this.amount = amount;
        this.fee = fee;
        this.transactionDate = transactionDate;
        this.status = status;
        this.accId = accId;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "FEE")
    private BigDecimal fee;
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "ACC_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.History[ id=" + id + " ]";
    }
    
}
