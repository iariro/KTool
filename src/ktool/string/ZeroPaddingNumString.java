package ktool.string;

/**
 * 数値のゼロパディング
 */
public class ZeroPaddingNumString
{
	static private final int nRadix = 10;

	public String string;

	/**
	 * 指定の値を文字列に変換。
	 * @param value 対象の値
	 * @param width 桁数
	 */
	public ZeroPaddingNumString(int value, int width)
	{
		string = new String();

		do
		{
			string = new Integer(value % nRadix).toString() + string;
			value /= nRadix;
		}
		while (value > 0);

		int len = string.length();

		for (int i=len ; i<width ; i++)
		{
			string = "0" + string;
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return string;
	}
}
