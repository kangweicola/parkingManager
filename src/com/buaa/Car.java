package com.buaa;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public class Car {

    private String ticket;
    private String carNumber;

    public Car(String ticket,String carNumber){
        this.ticket=ticket;
        this.carNumber=carNumber;
    }
    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
