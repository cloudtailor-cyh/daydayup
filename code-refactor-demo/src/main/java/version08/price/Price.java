package version08.price;

import version08.Constant;

/**
 * @author: chenyh
 * @creat: 2024/2/22 14:51
 * @description:
 */
public abstract class Price {

    public abstract double getCharge(int dayRented);

    public int getFrequentRenterPoints(int dayRented) {
        return Constant.FrequentPoints.ONE;
    }

    public abstract int getPriceCode();
}
