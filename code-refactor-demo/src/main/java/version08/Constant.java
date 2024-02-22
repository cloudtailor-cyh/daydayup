package version08;

/**
 * @author: chenyh
 * @creat: 2024/2/22 15:42
 * @description:
 */
public interface Constant {

    interface MovieCode {

        int REGULAR = 0;
        int NEW_RELEASE = 1;
        int CHILDREN = 2;
        int HORROR = 3;
    }


    /**
     * 电影计价常量
     */
    public interface MoviePriceUnit {

        int REGULAR = 2;
        double REGULAR_OVER  = 1.5;

        double CHILDREN = 1.5;
        double CHILDREN_OVER  = 1.5;

//        double NEW_RELEASE_OVER = 3;
        double NEW_RELEASE_OVER = 5;

        int HORROR = 10;
        double HORROR_OVER = 3;

    }

    /**
     * 电影计价规则, 多少天内为固定金额
     */
    interface MovieRentedDay {

        int REGULAR = 2;
        int CHILDREN = 3;
        int NEW_RELEASE = 1;// 和前两者不同, 只用于计算积分, 不计算费用
        int HORROR = 5;
    }

    interface FrequentPoints {

        int ONE = 1;
        int TWO = 2;
        int FIVE = 5;
    }



}
