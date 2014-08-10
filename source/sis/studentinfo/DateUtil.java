package sis.studentinfo;
import java.util.*;

public class DateUtil {
	public Date createDate(int year, int month, int day) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
}