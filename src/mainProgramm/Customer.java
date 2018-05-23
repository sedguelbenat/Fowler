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
        Enumeration enum_rentals = rentals.elements();	    
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            Rental rentalItem = (Rental) enum_rentals.nextElement();
            result.append("\t" + rentalItem.getMovie().getTitle()+ "\t" + "\t" + rentalItem.getDaysRented() + "\t" + String.valueOf(rentalItem.amountFor()) + "\n");
        }
        //add footer lines
        result.append("Amount owed is " + String.valueOf(this.totalAmount()) + "\n");
        result.append("You earned " + String.valueOf(this.frequentRenterPoints()) + " frequent renter points");
        return result.toString();
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
    
    