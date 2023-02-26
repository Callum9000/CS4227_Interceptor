package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import interceptor.concreteInterceptor;
import interceptor.contextObject;
import interceptor.dispatcher;
import src.Customer;
import src.Movie;
import src.Rental;

public class testCase {

    @Test
    public void test() {
        concreteInterceptor CI = new concreteInterceptor();
        dispatcher dis = new dispatcher();
        dis.attach(CI);
        Customer customer = new Customer("Geppetto");
        Rental movie1 = new Rental(new Movie("Pinocchio: A True Story", Movie.CHILDREN), 3);
        Rental movie2 = new Rental(new Movie("Pinocchio (2022 live-action film)", Movie.CHILDREN), 3);
        Rental movie3 = new Rental(new Movie("Guillermo del Toro's Pinocchio", Movie.NEW_RELEASE), 3);

        customer.addRental(movie1);
        String expected1 = "Rental record for Geppetto\n" + "\tPinocchio: A True Story	1.5\n" +
                "Amount owed is 1.5" + "\n" + "You earned 1 frequent renter points";

        assertEquals(expected1, customer.statement());
        System.out.println(customer.statement() + "\n");
        customer.addRental(movie2);
        String expected2 = "Rental record for Geppetto\n" + "\tPinocchio: A True Story	1.5\n" +
                "\tPinocchio (2022 live-action film)	1.5\n" +
                "Amount owed is 3.0" + "\n" + "You earned 2 frequent renter points";
        assertEquals(expected2, customer.statement());
        System.out.println(customer.statement() + "\n");
        customer.addRental(movie3);
        String expected3 = "Rental record for Geppetto\n" + "\tPinocchio: A True Story	1.5\n" +
                "\tPinocchio (2022 live-action film)	1.5\n" + "\tGuillermo del Toro's Pinocchio	9.0\n" +
                "Amount owed is 12.0" + "\n" + "You earned 4 frequent renter points";
        assertEquals(expected3, customer.statement());
        System.out.println(customer.statement() + "\n");
        contextObject CO1 = new contextObject(customer, movie1);
        contextObject CO2 = new contextObject(customer, movie2);
        contextObject CO3 = new contextObject(customer, movie3);
        dis.dispatchRent(CO1);
        dis.dispatchFRP(CO1);
        dis.dispatchRent(CO2);
        dis.dispatchFRP(CO2);
        dis.dispatchRent(CO3);
        dis.dispatchFRP(CO3);
    }

}
