package version04;

import com.sun.org.apache.bcel.internal.generic.RETURN;

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
     * @return
     */
    public double getCharge() {
        double thisAmount = 0;
        //  根据租借的电影的类型计算费用; 不同类型的电影的计算方式不同
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                // 租借时间未超过两天, 按照两天计费, 超过部分, 每多一天多1.5元
                thisAmount += 2;
                if (this.getDaysRented() > 2) {
                    thisAmount += (this.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (this.getDaysRented() > 3) {
                    thisAmount += (this.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

    /**
     * 没有使用customer的任何属性, 积分也只和电影有关, 因此可以放在rental这里
     * @return
     */
    public int getFrequentRenterPoints() {

        return getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1 ? 2 : 1;
    }
}
