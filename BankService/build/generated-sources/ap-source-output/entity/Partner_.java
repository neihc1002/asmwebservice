package entity;

import entity.Account;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-24T22:16:30")
@StaticMetamodel(Partner.class)
public class Partner_ { 

    public static volatile SingularAttribute<Partner, String> partnerCode;
    public static volatile SingularAttribute<Partner, String> partnerPassword;
    public static volatile SingularAttribute<Partner, Account> accId;
    public static volatile SingularAttribute<Partner, Integer> id;
    public static volatile SingularAttribute<Partner, Integer> status;

}