package version08.price;

import version08.Constant;


/**
 * @author: chenyh
 * @creat: 2024/2/22 14:52
 * @description:
 */
public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Constant.MovieCode.REGULAR;
    }

    @Override
    public double getCharge(int dayRented) {

        if (dayRented > Constant.MovieRentedDay.REGULAR) {
            return Constant.MoviePriceUnit.REGULAR + (dayRented - Constant.MovieRentedDay.REGULAR) * Constant.MoviePriceUnit.REGULAR_OVER;
        }
        return Constant.MoviePriceUnit.REGULAR;
    }
}
