package version08;

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
     * 去除 totalAmount, frequentRenterPoints的临时变量
     * @return
     */
    public String statement() {

        Enumeration rentals = this.rentals.elements();

        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();

            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }

        // 添加尾部行
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned  " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    /**
     *
     * @return
     */
    public String htmlStatement() {

        Enumeration rentals = this.rentals.elements();

        String result = "Html: Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();

            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\t freq point/movie: " + each.getFrequentRenterPoints() + "\n";
        }

        // 添加尾部行
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned  " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    /**
     * 在提取出逻辑并把逻辑归属方都确定的情况下, 去除临时变量, 改用从类中直接查询属性的方式
     * @return
     */
    private double getTotalCharge() {
        double totalAmount = 0;
        Enumeration rentals = this.rentals.elements();

        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();

            totalAmount += each.getCharge();

        }
        return totalAmount;
    }

    /**
     * 在提取出逻辑并把逻辑归属方都确定的情况下, 去除临时变量, 改用从类中直接查询属性的方式
     * @return
     */
    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();

        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();

            frequentRenterPoints += each.getFrequentRenterPoints();

        }
        return frequentRenterPoints;
    }
}
