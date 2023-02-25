package interceptor;

import src.Customer;
import src.Rental;

public class contextObject {
    private Rental rent;
    private Customer customer;

    public contextObject(Customer C_Customer, Rental rental) {
        this.customer = C_Customer;
        this.rent = rental;
    }

    public String getMovieTitle() {
        return rent.getMovie().getTitle();
    }

    public int getDaysRent() {
        return rent.getDaysRented();
    }

    public double getCharge() {
        return rent.getCharge();
    }

    public double FRP() {
        return rent.getFrequentRenterPoints();
    }

    public String getCustomerName() {
        return customer.getName();
    }
}