package version08.price;

import version08.Constant;

/**
 * @author: chenyh
 * @creat: 2024/2/22 14:55
 * @description:
 */
public class ChildrenPrice extends Price {

    @Override
    public int getPriceCode() {
        return Constant.MovieCode.CHILDREN;
    }

    @Override
    public double getCharge(int dayRented) {

        if (dayRented > Constant.MovieRentedDay.CHILDREN) {
            return Constant.MoviePriceUnit.CHILDREN + (dayRented - Constant.MovieRentedDay.CHILDREN) * Constant.MoviePriceUnit.CHILDREN_OVER;
        }
        return Constant.MoviePriceUnit.CHILDREN;
    }
}
