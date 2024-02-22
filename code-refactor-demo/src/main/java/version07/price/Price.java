package version07.price;

/**
 * @author: chenyh
 * @creat: 2024/2/22 14:51
 * @description:
 */
public abstract class Price {

   public abstract double getCharge(int dayRented);

   public int getFrequentRenterPoints(int dayRented) {
        return 1;
    }

   public abstract int getPriceCode();
}
