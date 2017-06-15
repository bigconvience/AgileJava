package timer;

public class TimeUtils {
    public static String formatTime(long timeInMills) {
        int timeInSecond = (int)(timeInMills / 1000L);
        int hour = timeInSecond / 3600;
        timeInSecond -= hour * 3600;
        int minute = timeInSecond / 60;
        int second = timeInSecond - minute * 60;
        StringBuilder stringBuilder = new StringBuilder();
        if(hour > 0) {
            noneZeroAppendTime(stringBuilder, hour);
            stringBuilder.append(":");
            appendTime(stringBuilder, minute);
            stringBuilder.append(":");
            appendTime(stringBuilder, second);
        } else {
            noneZeroAppendTime(stringBuilder, minute);
            stringBuilder.append(":");
            appendTime(stringBuilder, second);
        }

        return stringBuilder.toString();
    }

    private static void noneZeroAppendTime(StringBuilder string, int time) {
        string.append(time);
    }

    private static void appendTime(StringBuilder string, int time) {
        if(time < 10) {
            string.append("0");
        }

        string.append(time);
    }
}