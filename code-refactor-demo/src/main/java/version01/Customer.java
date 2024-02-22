package version01;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author: chenyh
 * @creat: 2024/2/22 10:39
 * @description:
 */
public class Customer {

    private String name;

    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    /**
     * 最简单的打印账单和积分详情的方式
     * @return
     */
    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration rentals = this.rentals.elements();

        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {

            double thisAmount = 0;

            Rental each = (Rental) rentals.nextElement();

            //  根据租借的电影的类型计算费用; 不同类型的电影的计算方式不同
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    // 租借时间未超过两天, 按照两天计费, 超过部分, 每多一天多1.5元
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }


            // 添加常客积分, 新发行的电影的常客积分额外增加1
            frequentRenterPoints++;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // 添加尾部行
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned  " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}
