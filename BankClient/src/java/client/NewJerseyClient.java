/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:BankService [service]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author DuongTK
 */
public class NewJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/BankService/webresources";

    public NewJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("service");
    }

    public <T> T queryHistoryCustomer_XML(GenericType<T> responseType, String number, String enddate, String pin, String startdate) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (number != null) {
            resource = resource.queryParam("number", number);
        }
        if (enddate != null) {
            resource = resource.queryParam("enddate", enddate);
        }
        if (pin != null) {
            resource = resource.queryParam("pin", pin);
        }
        if (startdate != null) {
            resource = resource.queryParam("startdate", startdate);
        }
        resource = resource.path("query");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T queryHistoryCustomer_JSON(GenericType<T> responseType, String number, String enddate, String pin, String startdate) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (number != null) {
            resource = resource.queryParam("number", number);
        }
        if (enddate != null) {
            resource = resource.queryParam("enddate", enddate);
        }
        if (pin != null) {
            resource = resource.queryParam("pin", pin);
        }
        if (startdate != null) {
            resource = resource.queryParam("startdate", startdate);
        }
        resource = resource.path("query");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAccountService(GenericType<T> responseType, String number, String pin) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (number != null) {
            resource = resource.queryParam("number", number);
        }
        if (pin != null) {
            resource = resource.queryParam("pin", pin);
        }
        resource = resource.path("get_account");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public String payment(String account_number, String password, String amount, String pin, String customer_number, String order_number, String partner_code) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (account_number != null) {
            resource = resource.queryParam("account_number", account_number);
        }
        if (password != null) {
            resource = resource.queryParam("password", password);
        }
        if (amount != null) {
            resource = resource.queryParam("amount", amount);
        }
        if (pin != null) {
            resource = resource.queryParam("pin", pin);
        }
        if (customer_number != null) {
            resource = resource.queryParam("customer_number", customer_number);
        }
        if (order_number != null) {
            resource = resource.queryParam("order_number", order_number);
        }
        if (partner_code != null) {
            resource = resource.queryParam("partner_code", partner_code);
        }
        resource = resource.path("payment");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public <T> T getAccountPartnerService(GenericType<T> responseType, String password, String code) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (password != null) {
            resource = resource.queryParam("password", password);
        }
        if (code != null) {
            resource = resource.queryParam("code", code);
        }
        resource = resource.path("get_partner");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
