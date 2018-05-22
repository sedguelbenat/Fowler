package mainProgramm;

import java.util.Enumeration;

public class Rental {
    private Movie movie;
    private int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }
    
    public double amountFor() {
        return this.getMovie().amountFor(this.daysRented);
    }
    
    public int getfrequentRenterPoints(){
    	return this.getMovie().getfrequentRenterPoints(daysRented);
    }
    
}