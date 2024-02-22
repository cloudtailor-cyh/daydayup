package version03;

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
     *
     * 兼容提取出计算费用的逻辑, 又把计算逻辑归属到rental中
     * @return
     */
    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration rentals = this.rentals.elements();

        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();

            double thisAmount = amountFor(each);

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

    private double amountFor(Rental rental) {
        return rental.getCharge();
    }

}
