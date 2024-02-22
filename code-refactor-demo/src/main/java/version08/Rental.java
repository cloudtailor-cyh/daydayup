package version08;


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

    /**
     * 没有使用customer的任何属性, 费用只和电影有关, 因此可以放在rental这里
     * switch最好用本类是属性, 所以要给他放到movie中去
     * @return
     */
    public double getCharge() {

        return movie.getCharge(daysRented);
    }

    /**
     * 与费用的重构方式同理
     * @return
     */
    public int getFrequentRenterPoints() {

        return movie.getFrequentRenterPoints(daysRented);
    }
}
