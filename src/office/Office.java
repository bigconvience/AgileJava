package office;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by jiangbenpeng on 20/04/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Office {
    public static void main(String args[]) throws Exception {

//        Office office = new Office();
//        Class cb = Office.class;
        System.out.println("load class");
//        ClassLoader classLoader = cb.getClassLoader();
        String rootPath = "file:" + System.getProperty("user.dir") + "/out/production/java_note/office/lib/";

        URL u = new URL(rootPath);
        URLClassLoader ucl = new URLClassLoader(new URL[]{u});
        Class c = ucl.loadClass(args[0]);
        Assembly asm = (Assembly) c.newInstance();
        asm.start();


        URL u1 = new URL(rootPath);
        URLClassLoader ucl1 = new URLClassLoader(new URL[]{u1});
        Class c1 = ucl1.loadClass(args[0]);
        Assembly asm1 = (Assembly) c1.newInstance();
        asm1.start();

        System.out.println(Office.class.getClassLoader());
        System.out.println(u.getClass().getClassLoader());
        System.out.println(ucl.getClass().getClassLoader());
        System.out.println(c.getClassLoader());
        System.out.println(asm.getClass().getClassLoader());

        System.out.println(u1.getClass().getClassLoader());
        System.out.println(ucl1.getClass().getClassLoader());
        System.out.println(c1.getClassLoader());
        System.out.println(asm1.getClass().getClassLoader());
        System.out.println(Assembly.class.getClassLoader()) ;
    }
}
