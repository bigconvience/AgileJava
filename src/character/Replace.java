package character;

/**
 * Created by jiangbenpeng on 30/12/2016.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Replace {
    public static void main(String[] argv)
            throws Exception
    {
        String s1 = "this\r\nis a test";
        String s2 = s1.replaceAll("[\n\r]", " ");
        System.out.println(s2);
    }
}
