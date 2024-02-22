package version07;

import version07.price.ChildrenPrice;
import version07.price.NewReleasePrice;
import version07.price.Price;
import version07.price.RegularPrice;

/**
 * @author: chenyh
 * @creat: 2024/2/22 10:36
 * @description:
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String _title, int _priceCode) {
        this.title = _title;
        // 自封装字段用法体现. 好处: 延迟初始化
        setPriceCode(_priceCode);
    }

    public String getTitle() {
        return title;
    }


    public int getPriceCode() {
        return price.getPriceCode();
    }

    public Movie setPriceCode(int _priceCode) {

        switch (_priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("当前不支持的价格代码: " + _priceCode);
        }
        return this;
    }

    /**
     * 直接利用price得到费用
     * @return
     */
    public double getCharge(int dayRented) {

        return price.getCharge(dayRented);
    }

    /**
     * 同getCharge方法
     * @param dayRented
     * @return
     */
    public int getFrequentRenterPoints(int dayRented) {

        return price.getFrequentRenterPoints(dayRented);
    }
}
