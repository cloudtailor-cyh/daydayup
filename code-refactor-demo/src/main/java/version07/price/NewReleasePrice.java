package version07.price;

/**
 * @author: chenyh
 * @creat: 2024/2/22 14:54
 * @description:
 */
public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return 1;
    }

    @Override
    public double getCharge(int dayRented) {
        return dayRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int dayRented) {
        return dayRented > 1 ? 2 : 1;
    }

}
