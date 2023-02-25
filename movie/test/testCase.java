package test;

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
        Customer customer = new Customer("Steve");
        Rental movie1 = new Rental(new Movie("Pinocchio: A True Story", Movie.CHILDREN), 3);
        Rental movie2 = new Rental(new Movie("Pinocchio (2022 live-action film)", Movie.CHILDREN), 3);
        Rental movie3 = new Rental(new Movie("Guillermo del Toro's Pinocchio", Movie.NEW_RELEASE), 3);
        customer.addRental(movie1);
        customer.addRental(movie2);
        customer.addRental(movie3);
        contextObject CO = new contextObject(customer, movie1);
        dis.dispatchRent(CO);
        String expected = "Steve has rented the movie Pinocchio: A True Story for the price of $1.5 over 3 days";

        System.out.println(expected);
        System.out.println(customer.statement());
        System.out.println(dis.equals(customer.statement()));
    }

}
