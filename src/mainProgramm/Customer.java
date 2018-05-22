package mainProgramm;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental rentalItem = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = rentalItem.amountFor();
            //show figures for this rental
            result += "\t" + rentalItem.getMovie().getTitle()+ "\t" + "\t" + rentalItem.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(this.frequentRenterPoints()) + " frequent renter points";
        return result;
    }
    
    private int frequentRenterPoints(){
    	Enumeration enum_rentals = rentals.elements();	    
    	int frequentRenterPoints = 0;
    	while (enum_rentals.hasMoreElements()) {
            Rental rentalItem = (Rental) enum_rentals.nextElement();
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((rentalItem.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rentalItem.getDaysRented() > 1) 
                frequentRenterPoints ++;
        }
    	
    	return frequentRenterPoints;
    }
    	
}
    
    