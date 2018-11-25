package BL;

import BL.City;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-27T11:54:40")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile CollectionAttribute<Country, City> cityCollection;
    public static volatile SingularAttribute<Country, String> countryName;
    public static volatile SingularAttribute<Country, Integer> countryID;
    public static volatile SingularAttribute<Country, String> numberCode;

}