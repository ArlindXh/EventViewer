/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventLocation;
import BL.EventPayment;
import java.util.List;

/**
 *
 * @author dell
 */
public interface EventPaymentInterface {
    
    void create(EventPayment eventPayment) throws EventPaymentException;
    void edit (EventPayment eventPayment) throws EventPaymentException;
    void remove(EventPayment eventPayment) throws EventPaymentException;
    List<EventPayment> findAll();
    EventPayment findById(int paymentID) throws EventPaymentException;
    
}
