package BL;

import BL.City;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-27T11:54:40")
@StaticMetamodel(Organizer.class)
public class Organizer_ { 

    public static volatile SingularAttribute<Organizer, String> organizerLastName;
    public static volatile SingularAttribute<Organizer, Integer> eventID;
    public static volatile SingularAttribute<Organizer, Integer> organizerID;
    public static volatile SingularAttribute<Organizer, Date> organizerBirthDate;
    public static volatile SingularAttribute<Organizer, String> organizerFirstName;
    public static volatile SingularAttribute<Organizer, Integer> organizerCity;
    public static volatile SingularAttribute<Organizer, City> city;

}