package version03;

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
}
