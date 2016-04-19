package ktool.datetime;

import java.text.*;
import java.util.*;

/**
 * 時間間隔情報。
 */
public class TimeSpan
{
	static private final SimpleDateFormat format;

	/**
	 * 時刻文字列書式初期化。
	 */
	static
	{
		format = new SimpleDateFormat();
		format.applyPattern("HH:mm:ss");
	}

	/**
	 * 日指定でTimeSpanオブジェクトを生成。
	 * @param day 日
	 * @return TimeSpanオブジェクト
	 */
	static public TimeSpan createByDay(int day)
	{
		return new TimeSpan(1000 * 60 * 60 * 24 * day);
	}

	private long millisecond;

	/**
	 * 指定のミリ秒からオブジェクトを構築する。
	 * @param millisecond ミリ秒
	 */
	public TimeSpan(long millisecond)
	{
		this.millisecond = millisecond;
	}

	/**
	 * 指定の時分秒からオブジェクトを構築する。
	 * @param hour 時
	 * @param minute 分
	 * @param second 秒
	 */
	public TimeSpan(int hour, int minute, int second)
	{
		millisecond = (((hour * 60) + minute) * 60 + second) * 1000;
	}

	/**
	 * 指定の時分秒文字列からオブジェクトを構築する。
	 * @param time 時分秒文字列
	 */
	public TimeSpan(String time)
		throws ParseException
	{
		Calendar calendar = new GregorianCalendar();

		calendar.setTime(format.parse(time));

		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		millisecond = (((hour * 60) + minute) * 60 + second) * 1000;
	}

	/**
	 * 日数を取得。
	 * @return 時間
	 */
	public int getDay()
	{
		return (int)(millisecond / (1000 * 60 * 60 * 24));
	}

	/**
	 * 時間を取得。
	 * @return 時間
	 */
	public int getHour()
	{
		return (int)(millisecond / (1000 * 60 * 60));
	}

	/**
	 * 分を取得。
	 * @return 分
	 */
	public int getMinute()
	{
		return (int)((millisecond / (1000 * 60)) % 60);
	}

	/**
	 * 秒を取得。
	 * @return 秒
	 */
	public int getSecond()
	{
		return (int)((millisecond / 1000) % 60);
	}

	/**
	 * ミリ秒を取得。
	 * @return ミリ秒
	 */
	public int getMillisecond()
	{
		return (int)(millisecond % 1000);
	}

	/**
	 * トータルのミリ秒を取得。
	 * @return ミリ秒
	 */
	public int getTotalSecond()
	{
		return (int)(millisecond / 1000);
	}

	/**
	 * トータルのミリ秒を取得。
	 * @return トータルのミリ秒
	 */
	public long getTotalMillisecond()
	{
		return millisecond;
	}

	/**
	 * 別のTimeSpanを足す。
	 * @param time 足すTimeSpan
	 */
	public void add(TimeSpan time)
	{
		millisecond += time.millisecond;
	}

	/**
	  * Time 型同士を比較。
	  * @param time 比較を行うTimeSpanの値
	  * @return 0=同じ/1=指定の値より大きい/-1=指定の値より小さい
	  */
	public int compare(TimeSpan time)
	{
		if (millisecond > time.millisecond)
		{
			// 大きい。

			return 1;
		}
		else if (millisecond < time.millisecond)
		{
			// 小さい。

			return -1;
		}
		else
		{
			// 同じ。

			return 0;
		}
	}

	/**
	 * 時間の差を求める。
	 * @param time 時間
	 * @return 時間の差
	 */
	public TimeSpan diff(TimeSpan time)
	{
		return new TimeSpan(millisecond - time.millisecond);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return
			String.format(
				"%02d:%02d:%02d",
				getHour(),
				getMinute(),
				getSecond());
	}
}
