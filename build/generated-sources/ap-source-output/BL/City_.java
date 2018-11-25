package BL;

import BL.Country;
import BL.Organizer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-27T11:54:40")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, String> zipCode;
    public static volatile SingularAttribute<City, String> cityName;
    public static volatile SingularAttribute<City, Organizer> organizer;
    public static volatile SingularAttribute<City, Integer> cityID;
    public static volatile SingularAttribute<City, Country> countryID;

}