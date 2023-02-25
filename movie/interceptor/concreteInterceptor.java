package interceptor;

public class concreteInterceptor implements interceptor {

    public void interceptRented(contextObject ConObj) {
        String message = ConObj.getCustomerName() + " has rented the movie " +
                ConObj.getMovieTitle() + " for the price of $" +
                ConObj.getCharge() + " over " + ConObj.getDaysRent() + " days";
        System.out.println(message);
    }

    public void interceptFRP(contextObject ConObj) {
        String message = ConObj.getCustomerName() + "has" + ConObj.FRP() + " in Frequent renter points";
        System.out.println(message);
    }

}
