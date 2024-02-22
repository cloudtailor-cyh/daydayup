package version08.price;

import version08.Constant;

/**
 * @author: chenyh
 * @creat: 2024/2/22 14:54
 * @description:
 */
public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Constant.MovieCode.NEW_RELEASE;
    }

    @Override
    public double getCharge(int dayRented) {

        return dayRented * Constant.MoviePriceUnit.NEW_RELEASE_OVER;
    }

    @Override
    public int getFrequentRenterPoints(int dayRented) {
        return dayRented > Constant.MovieRentedDay.NEW_RELEASE ? Constant.FrequentPoints.TWO : Constant.FrequentPoints.ONE;
    }

}
