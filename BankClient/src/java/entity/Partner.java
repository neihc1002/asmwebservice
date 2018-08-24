/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DuongTK
 */
@XmlRootElement
public class Partner implements Serializable {

   
    private Integer id;
    private String partnerCode;
    private String partnerPassword;
    private Integer status;
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



  
 
    
}
