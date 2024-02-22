package version07.price;

/**
 * @author: chenyh
 * @creat: 2024/2/22 14:55
 * @description:
 */
public class ChildrenPrice extends Price {

    @Override
    public int getPriceCode() {
        return 2;
    }

    @Override
    public double getCharge(int dayRented) {
        if (dayRented > 3) {
            return 1.5 + (dayRented - 3) * 1.5;
        }
        return 1.5;
    }
}
