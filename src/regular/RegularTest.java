package regular;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiangbenpeng on 5/24/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class RegularTest {
    public static void main(String[] args) {
        //被替换关键字的的数据源
        Map<String,String> tokens = new HashMap<String,String>();
        tokens.put("cat", "Garfield");
        tokens.put("beverage", "coffee");

        //匹配类似velocity规则的字符串
        String template = "${cat} really needs some ${beverage}.";
        //生成匹配模式的正则表达式
        String patternString = "\\$\\{(" + StringUtils.join(tokens.keySet(), "|") + ")\\}";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(template);

        //两个方法：appendReplacement, appendTail
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(sb, tokens.get(matcher.group(1)));
        }
        matcher.appendTail(sb);

        //out: Garfield really needs some coffee.
        System.out.println(sb.toString());

        //对于特殊含义字符"\","$"，使用Matcher.quoteReplacement消除特殊意义
        matcher.reset();
        //out: cat really needs some beverage.
        System.out.println(matcher.replaceAll("$1"));
        //out: $1 really needs some $1.
        System.out.println(matcher.replaceAll(Matcher.quoteReplacement("$1")));

        //到得邮箱的前缀名。插一句，其实验证邮箱的正则多种多样，根据自己的需求写对应的正则才是王道
        String emailPattern = "^([a-z0-9_\\.\\-\\+]+)@([\\da-z\\.\\-]+)\\.([a-z\\.]{2,6})$";
        pattern = Pattern.compile(emailPattern);
        matcher = pattern.matcher("test@qq.com");
        //验证是否邮箱
        System.out.println(matcher.find());
        //得到@符号前的邮箱名  out: test
        System.out.println(matcher.replaceAll("$1"));

        //获得匹配值
        String temp = "<meta-data android:name=\"appid\" android:value=\"joy\"></meta-data>";
        pattern = Pattern.compile("android:(name|value)=\"(.+?)\"");
        matcher = pattern.matcher(temp);
        while(matcher.find()) {
            //out: appid, joy
            System.out.println(matcher.group(2));
        }

        testPoint();
    }


    private static void testPoint() {
        String point = "fda{543fdasfdas";
        String patternString = "\\{.+\\}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(point);

        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            String result = matcher.group(0);
            String a = "<font color=#ffffff>" + result.substring(1, result.length() - 1) + "</font>";
            System.out.println("match: " + a);
            matcher.appendReplacement(sb, a);
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
