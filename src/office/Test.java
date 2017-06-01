package office;

/**
 * Created by jiangbenpeng on 23/04/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Test {
    public static void main(String args[]) {
        ClassLoader cl = Test.class.getClassLoader();
        System.out.println(cl);
        ClassLoader cl1 = cl.getParent();
        System.out.println(cl1);
        ClassLoader cl2 = cl1.getParent();
        System.out.println(cl2);

        String s = System.getProperty("java.class.path");
        System.out.println(s) ;

        String s1 = System.getProperty("java.ext.dirs");
        System.out.println(s1) ;


        String s2 = System.getProperty("sun.boot.class.path");
        System.out.println(s2) ;

        String s3 = System.getProperty("user.dir");
        System.out.println(s3) ;
    }

}
