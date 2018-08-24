package entity;

import entity.Customer;
import entity.History;
import entity.Partner;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-24T22:16:30")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> accNumber;
    public static volatile CollectionAttribute<Account, History> historyCollection;
    public static volatile SingularAttribute<Account, String> pin;
    public static volatile SingularAttribute<Account, Double> balance;
    public static volatile SingularAttribute<Account, Customer> cusId;
    public static volatile SingularAttribute<Account, Integer> id;
    public static volatile CollectionAttribute<Account, Partner> partnerCollection;
    public static volatile SingularAttribute<Account, Integer> status;

}