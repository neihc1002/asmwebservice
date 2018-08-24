/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DuongTK
 */
@Entity
@Table(name = "PARTNER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p")
    , @NamedQuery(name = "Partner.findById", query = "SELECT p FROM Partner p WHERE p.id = :id")
    , @NamedQuery(name = "Partner.findByPartnerCode", query = "SELECT p FROM Partner p WHERE p.partnerCode = :partnerCode")
        , @NamedQuery(name = "Partner.findByPartnerCodeAndPassword", query = "SELECT p FROM Partner p WHERE p.partnerCode = :partnerCode AND p.partnerPassword = :partnerPassword")
    , @NamedQuery(name = "Partner.findByPartnerPassword", query = "SELECT p FROM Partner p WHERE p.partnerPassword = :partnerPassword")
    , @NamedQuery(name = "Partner.findByStatus", query = "SELECT p FROM Partner p WHERE p.status = :status")})
public class Partner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "PARTNER_CODE")
    private String partnerCode;
    @Size(max = 50)
    @Column(name = "PARTNER_PASSWORD")
    private String partnerPassword;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "ACC_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account accId;

    public Partner() {
    }

    public Partner(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getPartnerPassword() {
        return partnerPassword;
    }

    public void setPartnerPassword(String partnerPassword) {
        this.partnerPassword = partnerPassword;
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
        if (!(object instanceof Partner)) {
            return false;
        }
        Partner other = (Partner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Partner[ id=" + id + " ]";
    }
    
}
