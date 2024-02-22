package version07;

/**
 * @author: chenyh
 * @creat: 2024/2/22 11:13
 * @description: 重构到此, 职责的分配已经比较合理了
 * 基于以下原则进行重构: 方法提取, 方法移动, 用多态替换条件表达式, 自封装字段, 用策略模式或状态模式替换类型编码
 * 重构的节奏: 小修改 -> 测试 -> 小修改 -> ... -> 测试
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        Customer cyh = new Customer("cyh");
        System.out.println(cyh.getClass().getName());

        cyh.addRental(new Rental(new Movie("爱在西元前", Movie.REGULAR), 2));
        cyh.addRental(new Rental(new Movie("热辣滚烫", Movie.NEW_RELEASE), 3));
        cyh.addRental(new Rental(new Movie("熊出没", Movie.CHILDRENS), 3));

        System.out.println(cyh.statement());
    }

}
