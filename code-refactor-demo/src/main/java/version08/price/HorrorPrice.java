package version08.price;

import version08.Constant;

/**
 * @author: chenyh
 * @creat: 2024/2/22 16:02
 * @description:
 */
public class HorrorPrice extends Price {

    @Override
    public double getCharge(int dayRented) {
        return dayRented < Constant.MovieRentedDay.HORROR ? Constant.MoviePriceUnit.HORROR :
                Constant.MoviePriceUnit.HORROR_OVER * (dayRented - Constant.MovieRentedDay.HORROR) + Constant.MoviePriceUnit.HORROR;
    }

    @Override
    public int getPriceCode() {
        return Constant.MovieCode.HORROR;
    }

    @Override
    public int getFrequentRenterPoints(int dayRented) {
        return dayRented > Constant.MovieRentedDay.HORROR ? 3 : 2;
    }
}
