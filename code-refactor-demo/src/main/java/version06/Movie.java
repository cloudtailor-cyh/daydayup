package version06;

/**
 * @author: chenyh
 * @creat: 2024/2/22 10:36
 * @description:
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public String getTitle() {
        return _title;
    }



    public int getPriceCode() {
        return _priceCode;
    }

    public Movie setPriceCode(int _priceCode) {
        this._priceCode = _priceCode;
        return this;
    }

    /**
     * 没有使用customer的任何属性, 费用只和电影有关, 因此可以放在rental这里
     * switch最好用本类是属性, 所以计算费用的逻辑应该放回到movie中, 价格本身也算是电影的一个属性, 费用的计算和单价关系密切
     * @return
     */
    public double getCharge(int dayRented) {
        double thisAmount = 0;
        //  根据租借的电影的类型计算费用; 不同类型的电影的计算方式不同
        switch (this.getPriceCode()) {
            case Movie.REGULAR:
                // 租借时间未超过两天, 按照两天计费, 超过部分, 每多一天多1.5元
                thisAmount += 2;
                if (dayRented > 2) {
                    thisAmount += (dayRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += dayRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (dayRented > 3) {
                    thisAmount += (dayRented - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

    public int getFrequentRenterPoints(int dayRented) {

        return getPriceCode() == Movie.NEW_RELEASE && dayRented > 1 ? 2 : 1;
    }
}
