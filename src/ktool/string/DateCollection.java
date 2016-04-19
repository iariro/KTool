package ktool.string;

import java.text.*;
import java.util.*;
import ktool.datetime.*;

/**
 * 日付文字列コレクション。
 */
public class DateCollection
	extends ArrayList<String>
{
	/**
	 * CSV形式の文字列から日付文字列コレクションを生成。デバッグ用。
	 * @param csv CSV形式の文字列
	 * @return 日付文字列コレクション
	 */
	static public DateCollection fromCsv(String csv)
	{
		DateCollection dateCollection = new DateCollection();

		for (String date : csv.split(","))
		{
			dateCollection.add(date);
		}

		return dateCollection;
	}

	/**
	 * 「yyyy/mm/dd-yyyy/mm/dd,yyyy/mm/dd」といった形式の日付文字列を展開。
	 * @param dates 「yyyy/mm/dd-yyyy/mm/dd,yyyy/mm/dd」といった形式の日付文字列
	 * @return 日付文字列コレクション
	 * @throws ParseException
	 */
	static public DateCollection fromHyphenAndComma(String dates)
		throws ParseException
	{
		DateCollection dateCollection = new DateCollection();

		for (String dates2 : dates.split(","))
		{
			if (dates2.indexOf('-') >= 0)
			{
				// ハイフンを含む。

				String [] dates2Split = dates2.split("-");

				DateTime date1 = DateTime.parseDateString(dates2Split[0]);
				DateTime date2 = DateTime.parseDateString(dates2Split[1]);

				for ( ; date1.compareTo(date2) <= 0 ; date1.add(24 * 60 * 60))
				{
					dateCollection.add(date1.toString());
				}
			}
			else
			{
				// ハイフンを含まない。

				dateCollection.add(dates2);
			}
		}

		return dateCollection;
	}

	/**
	 * 「yyyy/mm/dd-yyyy/mm/dd,yyyy/mm/dd」といった形式の日付文字列を生成。
	 * @return 「yyyy/mm/dd-yyyy/mm/dd,yyyy/mm/dd」といった形式の日付文字列
	 * @throws ParseException
	 */
	public String toShortString()
		throws ParseException
	{
		String string = new String();
		DateTime date1 = null;
		DateTime date2 = null;

		boolean nokori = false;

		for (int i=0 ; i<size() ; i++)
		{
			date1 = DateTime.parseDateString(get(i));

			boolean renzoku = false;

			if (date2 != null)
			{
				// ２個目以降。

				// 次の日に。
				date2.add(24 * 60 * 60);

				renzoku = date2.compareTo(date1) == 0;
			}

			if (! renzoku)
			{
				// 不連続＝直前の確定のタイミング。

				if (i > 0)
				{
					// ２個目以降。

					if (nokori)
					{
						// 未確定分あり。

						string += "-";
						string += get(i - 1);

						nokori = false;
					}

					string += ",";
				}

				string += get(i);
			}
			else
			{
				// 連続。

				nokori = true;
			}

			date2 = date1;
		}

		if (nokori)
		{
			// 未確定分あり。

			string += "-";
			string += get(size() - 1);
		}

		return string;
	}
}
