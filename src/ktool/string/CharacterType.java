package ktool.string;

/**
 * 文字列タイプ判定ユーティリティ。
 * @author kumagai
 */
public class CharacterType
{
	// static
	static private final char [] white =
	{
		0x09,	// TAB
		0x20	// SPACE
	};

	static private final char [] kaigyou =
	{
		0x0a,	// LF
		0x0d	// CR
	};

	/**
	 * 数字であるかを判定。
	 * @param ch 対象文字
	 * @return true=数字／false=それ以外
	 */
	static public boolean isDigit(char ch)
	{
		return ch >= '0' && ch <= '9';
	}

	/**
	 * 改行文字であるかを判定。
	 * @param value 対象文字
	 * @return true=改行文字／false=それ以外
	 */
	static public boolean isReturn(char value)
	{
		boolean find = false;

		for (int i=0 ; i<kaigyou.length && !find ; i++)
		{
			find = value == kaigyou[i];
		}

		return find;
	}

	/**
	 * 空白文字であるかを判定。
	 * @param value 対象文字
	 * @return true=空白文字／false=それ以外
	 */
	static public boolean isWhite(char value)
	{
		boolean find = false;

		for (int i=0 ; i<white.length && !find ; i++)
		{
			find = value == white[i];
		}

		for (int i=0 ; i<kaigyou.length && !find ; i++)
		{
			find = value == kaigyou[i];
		}

		return find;
	}
}
