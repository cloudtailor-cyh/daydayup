package version08;

/**
 * @author: chenyh
 * @creat: 2024/2/22 11:13
 * @description: 重构到此, 职责的分配已经比较合理了
 * 基于以下原则进行重构: 方法提取, 方法移动, 用多态替换条件表达式, 自封装字段, 用策略模式或状态模式替换类型编码
 * 重构的节奏: 小修改 -> 测试 -> 小修改 -> ... -> 测试
 */
public class ApplicationRunner {



    // 当我想要更改电影的计费方式, 比如新发行的涨价为一天5块, 并添加一个电影类型为恐怖片, 计费方式为, 5天以内, 10块钱, 超过5天, 每天3块
    public static void main(String[] args) {
        Customer cyh = new Customer("cyh");
        System.out.println(cyh.getClass().getName());

        cyh.addRental(new Rental(new Movie("爱在西元前", Constant.MovieCode.REGULAR), 2));
        cyh.addRental(new Rental(new Movie("热辣滚烫", Constant.MovieCode.NEW_RELEASE), 3));
        cyh.addRental(new Rental(new Movie("熊出没", Constant.MovieCode.CHILDREN), 3));
        cyh.addRental(new Rental(new Movie("电锯惊魂", Constant.MovieCode.HORROR), 6));

        System.out.println("==========normal===============");
        System.out.println(cyh.statement());
        /** 原始输出结果
         * version08.Customer
         * Rental Record for cyh
         * 	爱在西元前	2.0
         * 	热辣滚烫	9.0
         * 	熊出没	1.5
         * Amount owed is 12.5
         * You earned  4 frequent renter points
         */
        // 有新的 statment, 比如htmlStatment, 要展示用户积分
        System.out.println("==========html===============");
        System.out.println(cyh.htmlStatement());
        /**
         * version08.Customer
         * ==========normal===============
         * Rental Record for cyh
         * 	爱在西元前	2.0
         * 	热辣滚烫	9.0
         * 	熊出没	1.5
         * Amount owed is 12.5
         * You earned  4 frequent renter points
         * ==========html===============
         * Html: Rental Record for cyh
         * 	爱在西元前	2.0	 freq point/movie: 1
         * 	热辣滚烫	9.0	 freq point/movie: 2
         * 	熊出没	1.5	 freq point/movie: 1
         * Amount owed is 12.5
         * You earned  4 frequent renter points
         */
    }
}
