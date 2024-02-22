package version04;

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
     * 继续抽取积分计算函数, 同样放到rental, 兼容第一版本代码, 用方法xxxfor方法包一层
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
            int point = pointFor(each);

            totalAmount += thisAmount;
            frequentRenterPoints += point;

            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
        }

        // 添加尾部行
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned  " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rental) {
        return rental.getCharge();
    }

    private int pointFor(Rental rental) {

        return rental.getFrequentRenterPoints();
    }

}
