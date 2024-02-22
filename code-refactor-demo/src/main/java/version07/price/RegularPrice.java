package version07.price;

/**
 * @author: chenyh
 * @creat: 2024/2/22 14:52
 * @description:
 */
public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return 0;
    }

    @Override
    public double getCharge(int dayRented) {

        if (dayRented > 2) {
           return 2 + (dayRented - 2) * 1.5;
        }
        return 2;
    }
}
