/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Account;
import entity.History;
import entity.Partner;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DuongTK
 */
@Stateless
@Path("service")
public class BankService {
    @PersistenceContext(unitName = "BankServicePU")
    private EntityManager em;
    private Account getAccountByPartner(String code, String password) {
        Account account = null;
        Query query = em.createNamedQuery("Partner.findByPartnerCodeAndPassword").setParameter("partnerCode", code)
                .setParameter("partnerPassword", password);
        try {
            Partner partner = (Partner) query.getSingleResult();
            if (partner != null) {
                account = partner.getAccId();
            }
        } catch (Exception e) {

        }
        return account;
    }

    private Account getAccount(String number, String pin) {
        Account account = null;
        Query query = em.createNamedQuery("Account.findByAccNumberAndPin").setParameter("accNumber", number)
                .setParameter("pin", pin);
        try {
            account = (Account) query.getSingleResult();
        } catch (Exception e) {

        }
        return account;
    }

    private double calFee(double amount) {
        double motphantram = amount / 100;
        double fee = 0;
        if (amount < 100000) {
            fee = 10000;
        }
        if (amount > 100000 & amount <= 500000) {
            fee = motphantram * 2;
        }
        if (amount > 500000 & amount <= 1000000) {
            fee = (long) (motphantram * 1.5);
        }
        if (amount > 1000000 & amount <= 5000000) {
            fee = motphantram * 1;
        }
        if (amount > 5000000) {
            fee = (long) (motphantram * 0.5);
        }
        return fee;
    }
    
    @GET
    @Path("get_account")
    @Produces({MediaType.APPLICATION_XML})
    public Account getAccountService(@QueryParam("number") String number,@QueryParam("pin") String pin){
        return getAccount(number, pin);
    }
    
    @GET
    @Path("get_partner")
    @Produces({MediaType.APPLICATION_XML})
    public Account getAccountPartnerService(@QueryParam("code") String code,@QueryParam("password") String password){
        return getAccountByPartner(code, password);
    }
    
    @GET
    @Path("payment")
    @Produces({MediaType.TEXT_PLAIN})
    public String payment(@QueryParam("partner_code") String partnerCode,
             @QueryParam("password") String password,
             @QueryParam("customer_number") String customerNumber,
             @QueryParam("account_number") String accountNumber,
             @QueryParam("pin") String pin,
             @QueryParam("order_number") String orderNumber,
             @QueryParam("amount") String amount) {
        Account partner = getAccountByPartner(partnerCode, password);
        Account customer = getAccount(accountNumber, pin);
        if (partner != null & customer != null) {
            double amountL = Double.parseDouble(amount);
            double balanceCus = customer.getBalance();
            double balancePartner = partner.getBalance();
            double fee = calFee(amountL);
            double total = amountL + fee;
            if (balanceCus>=total) {
                balanceCus = balanceCus - total;
                balancePartner = balancePartner+amountL;
                customer.setBalance(balanceCus);
                partner.setBalance(balancePartner);
                History historyCus = new History("mua hang",-amountL,fee,new Date(),1,customer);
                History historyPartner = new History("ban hang",amountL,fee,new Date(),1,partner);
                em.persist(historyCus);
                em.persist(historyPartner);
                return "success";
            }           
        }
        return "fail";
    }
    
    @GET
    @Path("query")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<History> queryHistoryCustomer(@QueryParam("number") String number
            ,@QueryParam("pin") String pin
            ,@QueryParam("startdate") String startDate
            ,@QueryParam("enddate") String endDate){
        List<History> list =null;
        Account acc = getAccount(number, pin);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date start=new Date();
        Date end=new Date();
        try {
            start = formatter.parse(startDate);
            end = formatter.parse(endDate);
        } catch (Exception e) {
        }
        if (acc!=null) {
            Query query = em.createNamedQuery("History.findByDate")
                    .setParameter("accid", acc.getId())
                    .setParameter("startdate",start,TemporalType.DATE)
                    .setParameter("enddate", end,TemporalType.DATE);
            try {
                List<History> result = query.getResultList();
                if (result!=null) {
                    list = result;
                }
            } catch (Exception e) {
            }
        }
       return list;
    }
}
