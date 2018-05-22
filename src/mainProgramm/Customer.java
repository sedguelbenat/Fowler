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
            result += "\t" + rentalItem.getMovie().getTitle()+ "\t" + "\t" + rentalItem.getDaysRented() + "\t" + String.valueOf(rentalItem.amountFor()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(this.totalAmount()) + "\n";
        result += "You earned " + String.valueOf(this.frequentRenterPoints()) + " frequent renter points";
        return result;
    }
    
    private int frequentRenterPoints(){
    	Enumeration enum_rentals = rentals.elements();	    
    	int frequentRenterPoints = 0;
    	while (enum_rentals.hasMoreElements()) {
            Rental rentalItem = (Rental) enum_rentals.nextElement();
            frequentRenterPoints+= rentalItem.getfrequentRenterPoints();
        }
    	return frequentRenterPoints;
    }
    
    private double totalAmount(){
        Enumeration enum_rentals = rentals.elements();
        double totalAmount = 0.0;
    	while (enum_rentals.hasMoreElements()) {
            Rental rentalItem = (Rental) enum_rentals.nextElement();
            totalAmount += rentalItem.amountFor();
        }
    	return totalAmount;
    }
    	
}
    
    