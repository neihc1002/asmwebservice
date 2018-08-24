package entity;

import entity.Account;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-24T18:24:38")
@StaticMetamodel(History.class)
public class History_ { 

    public static volatile SingularAttribute<History, BigDecimal> amount;
    public static volatile SingularAttribute<History, BigDecimal> fee;
    public static volatile SingularAttribute<History, String> name;
    public static volatile SingularAttribute<History, Account> accId;
    public static volatile SingularAttribute<History, Integer> id;
    public static volatile SingularAttribute<History, Date> transactionDate;
    public static volatile SingularAttribute<History, Integer> status;

}