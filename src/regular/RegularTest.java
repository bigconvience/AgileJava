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

        String url = "fdawww.baidu.com/fadg https://github.com/google/guava/wiki/CachesExplained";
        String url1 = "fdashttp://ued.xiami.net/grammy/prototypes/pro9.1/#p=帖子支持外链跳转";
        String url2 = "fdashttp://ued.xiami.net/grammy/prototypes/pro9.1/?q=fdswofd我的";
        String url3 = "Choked http://www.baidu.com/?a=1";

        testUrl(url);
        testUrl(url1);
        testUrl(url2);
        testUrl(url3);
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

    String hint = "[打开网页]";



    private static void testUrl(String input) {
       // Pattern p = Pattern.compile("(http[s]{0,1}://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?");
        Pattern p = Pattern.compile("(((http[s]{0,1})://)?[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)");
        Matcher matcher = p.matcher(input);

        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            //out: appid, joy
            String url = matcher.group();
            System.out.println("start: " + matcher.start() + " end: " + matcher.end() + " " + url);

            String a = "[打开网页](" + url + ")";
            matcher.appendReplacement(sb, a);
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
