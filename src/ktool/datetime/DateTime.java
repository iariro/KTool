package ktool.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日付・時刻型。
 */
public class DateTime
	implements Comparable<DateTime>
{
	static private final SimpleDateFormat formatDate;
	static private final SimpleDateFormat formatTime;
	static private final SimpleDateFormat formatFull;

	/**
	 * 書式オブジェクトの生成。
	 */
	static
	{
		formatDate = new SimpleDateFormat();
		formatDate.applyPattern("yyyy/MM/dd");

		formatTime = new SimpleDateFormat();
		formatTime.applyPattern("HH:mm:ss");

		formatFull = new SimpleDateFormat();
		formatFull.applyPattern("yyyy/MM/dd HH:mm:ss");
	}

	/**
	 * 日付文字列からDateTimeオブジェクトを生成。
	 * @param date yyyy/mm/dd形式の日付文字列
	 * @return DateTimeオブジェクト
	 * @throws ParseException
	 */
	static public DateTime parseDateString(String date)
		throws ParseException
	{
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(formatDate.parse(date));

		return new DateTime(calendar);
	}

	/**
	 * 日時文字列からDateTimeオブジェクトを生成。
	 * @param dateTime yyyy/MM/dd HH:mm:ss形式の日時文字列
	 * @return DateTimeオブジェクト
	 * @throws ParseException
	 */
	static public DateTime parseDateTimeString(String dateTime)
		throws ParseException
	{
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(formatFull.parse(dateTime));

		return new DateTime(calendar);
	}

	private final Calendar calendar;

	/**
	 * 現在の日時を持ってオブジェクトを構築する。
	 */
	public DateTime()
	{
		calendar = GregorianCalendar.getInstance();
	}

	/**
	 * 指定の年月日時分秒を割り当てる。
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @param hour 時
	 * @param minute 分
	 * @param second 秒
	 */
	public DateTime
		(int year, int month, int day, int hour, int minute, int second)
	{
		this(year, month, day, hour, minute, second, null);
	}

	/**
	 * 指定の年月日時分秒を割り当てる。
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @param hour 時
	 * @param minute 分
	 * @param second 秒
	 * @param timezone タイムゾーン
	 */
	public DateTime(int year, int month, int day, int hour, int minute,
		int second, TimeZone timezone)
	{
		calendar = GregorianCalendar.getInstance();

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);

		if (timezone != null)
		{
			// タイムゾーン指定あり。

			calendar.setTimeZone(timezone);
		}
	}

	/**
	 * 指定の文字列から年月日時分秒を割り当てる。
	 * @param date 年月日時分秒文字列
	 */
	public DateTime(String date)
		throws ParseException
	{
		calendar = GregorianCalendar.getInstance();
		calendar.setTime(formatFull.parse(date));
	}

	/**
	 * 指定のDate値から年月日時分秒を割り当てる。
	 * @param date Date値
	 */
	public DateTime(Date date)
	{
		calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
	}

	/**
	 * 指定のCalendar値から年月日時分秒を割り当てる。
	 * @param calendar Calendar値
	 */
	public DateTime(Calendar calendar)
	{
		this.calendar = calendar;
	}

	/**
	 * 指定のDateTime値のコピーを作成する。
	 * @param date DateTime値
	 */
	public DateTime(DateTime date)
	{
		calendar = GregorianCalendar.getInstance();
		calendar.setTime(date.calendar.getTime());
	}

	/**
	 * 指定のDateTime値のコピーを作成する。
	 * @param date DateTime値
	 */
	public DateTime(long date)
	{
		calendar = GregorianCalendar.getInstance();
		calendar.setTimeInMillis(date);
	}

	/**
	 * Calendarオブジェクトを取得する。
	 * @return Calendarオブジェクト
	 */
	public Calendar getCalendar()
	{
		return calendar;
	}

	/**
	 * Dateオブジェクトを取得する。
	 * @return Dateオブジェクト
	 */
	public Date getDate()
	{
		return calendar.getTime();
	}

	/**
	 * 年を取得。
	 * @return 年
	 */
	public int getYear()
	{
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 年を設定。
	 * @param year 年
	 */
	public void setYear(int year)
	{
		calendar.set(Calendar.YEAR, year);
	}

	/**
	 * 月を取得。
	 * @return 年
	 */
	public int getMonth()
	{
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 月を設定。
	 * @param month 月
	 */
	public void setMonth(int month)
	{
		calendar.set(Calendar.MONTH, month - 1);
	}

	/**
	 * 日を取得。
	 * @return 年
	 */
	public int getDay()
	{
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 日を設定。
	 * @param day 日
	 */
	public void setDay(int day)
	{
		calendar.set(Calendar.DAY_OF_MONTH, day);
	}

	/**
	 * 時を取得。
	 * @return 年
	 */
	public int getHour()
	{
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 分を取得。
	 * @return 年
	 */
	public int getMinute()
	{
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 秒を取得。
	 * @return 年
	 */
	public int getSecond()
	{
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 指定の日時を割り当てる。
	 * @param datetime 日時
	 */
	public void set(DateTime datetime)
	{
		this.calendar.setTime(datetime.calendar.getTime());
	}

	/**
	 * 指定の日時と比較する。
	 * @param datetime 比較する日時
	 * @return 大小
	 */
	public int compareTo(DateTime datetime)
	{
		return calendar.compareTo(datetime.calendar);
	}

	/**
	 * 指定の日時と比較する。
	 * @param datetime 比較する日時
	 * @return 大小
	 */
	public int compareTo(Date datetime)
	{
		return calendar.getTime().compareTo(datetime);
	}

	/**
	 * 指定の時間を加算する。
	 * @param second 加算する時間（秒）
	 */
	public void add(int second)
	{
		calendar.add(Calendar.SECOND, second);
	}

	/**
	 * 指定の時間を減算する。
	 * @param second 減算する時間（秒）
	 */
	public void sub(int second)
	{
		calendar.add(Calendar.SECOND, - second);
	}

	/**
	 * 指定の時間を加算する。
	 * @param time 加算する時間
	 */
	public void add(TimeSpan time)
	{
		calendar.add(Calendar.SECOND, time.getTotalSecond());
	}

	/**
	 * 指定の時間を減算する。
	 * @param time 減算する時間
	 */
	public void sub(TimeSpan time)
	{
		calendar.add(Calendar.SECOND, - time.getTotalSecond());
	}

	/**
	 * 指定の月を加算する。
	 * @param month 加算する月
	 */
	public void addMonth(int month)
	{
		calendar.add(Calendar.MONTH, month);
	}

	/**
	 * 指定の日を加算する。
	 * @param day 加算する日数
	 */
	public void addDay(int day)
	{
		calendar.add(Calendar.DATE, day);
	}

	/**
	 * 指定の時間を加算・返却する。
	 * @param second 加算する時間（秒）
	 * @return 加算した時間
	 */
	public DateTime makeAdd(int second)
	{
		DateTime datetime = new DateTime(this);

		datetime.calendar.add(Calendar.SECOND, second);

		return datetime;
	}

	/**
	 * 指定の時間を加算・返却する。
	 * @param time 加算する時間
	 * @return 加算した時間
	 */
	public DateTime makeAdd(TimeSpan time)
	{
		DateTime datetime = new DateTime(this);

		datetime.calendar.add(Calendar.SECOND, time.getTotalSecond());

		return datetime;
	}

	/**
	 * 指定の日時との差を求める。
	 * @param datetime 比較する日時
	 * @return 指定の日時との差
	 */
	public TimeSpan diff(DateTime datetime)
	{
		long milli1 = this.calendar.getTimeInMillis();
		long milli2 = datetime.calendar.getTimeInMillis();

		return new TimeSpan(milli1 - milli2);
	}

	/**
	 * 時間文字列を取得する。
	 * @return 時間文字列
	 */
	public String toTimeString()
	{
		return formatTime.format(calendar.getTime());
	}

	/**
	 * 日付文字列を取得する。
	 * @return 日付文字列
	 */
	public String toString()
	{
		return formatDate.format(calendar.getTime());
	}

	/**
	 * 日時文字列を取得する。
	 * @return 日時文字列
	 */
	public String toFullString()
	{
		return formatFull.format(calendar.getTime());
	}
}
