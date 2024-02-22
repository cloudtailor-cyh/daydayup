package version01;

/**
 * @author: chenyh
 * @creat: 2024/2/22 10:38
 * @description: 租赁关系
 */
public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
