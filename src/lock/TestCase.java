package lock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;

/**
 * Created by jiangbenpeng on 27/04/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class TestCase {
    public static int number;
    public static boolean isinited;
    public static void main(String[] args) {
       float srt = 0.99999f;

       int first = (int)srt;
       float second = srt - first;

        DecimalFormat fnum = new DecimalFormat("##0.0");
//        String floatString = String.valueOf(second);
//        String floatString =fnum.format(Float.POSITIVE_INFINITY);
//        System.out.println("floatString: " + Float.NaN + " " + Float.POSITIVE_INFINITY + " " + Float.NEGATIVE_INFINITY);


//        String display = floatString.substring(floatString.indexOf("."));

//       System.out.println("first: " + first + " second: " + display);



        Result2 r = new Result2();
        r.reput = 1111111111111111111111111111111111111111111111111111.1;

//        Result resutl = JSON.parseObject(input, Result.class);
//        System.out.println(new Gson().toJson(r));
        System.out.println(JSON.toJSONString(r));

//        String json = JSON.toJSONString(r);
//        System.out.println(json);

       String input = "{\"reput\":\"NaN\"}";


        Result resutl = JSON.parseObject(JSON.toJSONString(r), Result.class);
//        Result result = new Gson().fromJson(input, Result.class);

        System.out.println("result: " + resutl.reput);

    }

    static class Result {
        @SerializedName("reput")
        @JSONField(name = "reput")
        public Float reput;
    }

    static class Result2 {
        @SerializedName("reput")
        @JSONField(name = "reput")
        public Double reput;
    }

}
