package ktool.datetime;

/**
 * 月文字列ユーティリティ。
 * @author kumagai
 */
public class Month
{
	public final static String [] monthData =
	{
		"Jan", "Feb", "Mar", "Apr", "May", "Jun",
		"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
	};

	/**
	  * 月の名前を文字列で取得する。
	  * @param month 取得したい月を 1 ～ 12 までの数値で指定する
	  * @return 月文字列
	  */
	public static String getMonth(int month)
	{
		return monthData[month - 1];
	}

	/**
	  * 月の名前を数値で取得する
	  * @param month 英語３文字形式の月文字列
	  * @return 1-12 までの数値で返却する
	  */
	public static int monthToInt(String month)
	{
		boolean find = false;

		int i;

		for (i=0 ; i<monthData.length && !find ; i++)
		{
			find = month.equals(monthData[i]);
		}

		return find ? i : 0;
	}
}
