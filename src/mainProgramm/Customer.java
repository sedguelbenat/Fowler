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
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental rentalItem = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = amountFor(rentalItem);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((rentalItem.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rentalItem.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + rentalItem.getMovie().getTitle()+ "\t" + "\t" + rentalItem.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rentalItem) {
        double thisAmount = 0;
        switch (rentalItem.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rentalItem.getDaysRented() > 2)
                    thisAmount += (rentalItem.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rentalItem.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rentalItem.getDaysRented() > 3)
                    thisAmount += (rentalItem.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

}
    