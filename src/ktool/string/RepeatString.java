package ktool.string;

/**
 * 繰り返し文字列生成ユーティリティ。
 * @date 2006/03/20 Kumagai
 *	- getString - IOException の throws 指定を消す
 */
public class RepeatString
{
	/**
	 * @brief 文字の繰り返しからなる文字列を作成する
	 * @param ch 繰り返す文字
	 * @param length 繰り返す回数
	 * @return 作成した文字列
	 * @date 2006/03/20 Kumagai
	 *	- IOException の throws 指定を消す
	 */
	static public String getString(char ch, int length)
	{
		StringBuffer sb = new StringBuffer();

		for (int i=0 ; i<length ; i++)
		{
			sb.append(ch);
		}

		return sb.toString();
	}
}
