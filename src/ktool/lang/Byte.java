package ktool.lang;

/**
 * バイト値ユーティリティ。
 * @author kumagai
 */
public class Byte
{
	static private char hexChar [] =
	{
		'0',  '1',  '2',  '3',  '4',  '5',  '6',  '7',
		'8',  '9',  'a',  'b',  'c',  'd',  'e',  'f'
	};

	/**
	 * 0-15までの値を受け、0-fの文字を取得する。
	 * @param value 0-15までの値
	 * @return 0-fの文字
	 */
	static public char toHex(int value)
	{
		if (value >= 0x0 && value <= 0xf)
		{
			// 範囲内。

			return hexChar[value];
		}
		else
		{
			// 範囲外。

			return '_';
		}
	}

	/**
	 * 文字を１６進表現にする。
	 * @param value 対象文字
	 * @return １６進
	 */
	static public String toHexString(byte value)
	{
		char [] ch = new char [2];

		ch[0] = toHex((value & 0xf0) / 0x10);
		ch[1] = toHex(value & 0x0f);

		return new String(ch);
	}
}
