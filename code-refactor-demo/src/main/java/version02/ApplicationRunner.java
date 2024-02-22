package version02;


/**
 * @author: chenyh
 * @creat: 2024/2/22 11:13
 * @description:
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
