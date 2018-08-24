package entity;

import entity.Customer;
import entity.History;
import entity.Partner;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-24T18:24:38")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> accNumber;
    public static volatile CollectionAttribute<Account, History> historyCollection;
    public static volatile SingularAttribute<Account, String> pin;
    public static volatile SingularAttribute<Account, BigDecimal> balance;
    public static volatile SingularAttribute<Account, Customer> cusId;
    public static volatile SingularAttribute<Account, Integer> id;
    public static volatile CollectionAttribute<Account, Partner> partnerCollection;
    public static volatile SingularAttribute<Account, Integer> status;

}