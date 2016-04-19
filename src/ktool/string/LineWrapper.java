package ktool.string;

import java.io.*;
import java.util.*;

/**
 * テキストを指定の幅に開業し整形するユーティリティ。
 * @author kumagai
 */
public class LineWrapper
{
	private final int width;
	private final int tabSize;

	/**
	 * 幅情報を割り当てる。
	 * @param width １行の幅
	 * @param tabSize タブ幅
	 */
	public LineWrapper(int width, int tabSize)
	{
		this.width = width;
		this.tabSize = tabSize;
	}

	/**
	 * 整形処理。
	 * @param source 対象文字列
	 * @return 処理済み文字列
	 * @throws IOException
	 */
	public String wrap(ArrayList<String> source)
		throws IOException
	{
		StringBuffer sb = new StringBuffer();

		for (int i=0 ; i<source.size() ; i++)
		{
			String line = source.get(i);
			String leftString = "";
			int column = 0;
			int leftStringColumn = 0;
			boolean inWhiteSpace = true;

			for (int j=0 ; j<line.length() ; j++)
			{
				if (line.charAt(j) == '\t')
				{
					// タブ。

					column += tabSize;
				}
				else
				{
					// タブ以外。

					// ShiftJIS とした時のバイト数を半角文字数としてカウントす
					// る。邪道である。
					try
					{
						column +=
							line.substring(j, j + 1).getBytes("SJIS").length;
					}
					catch (UnsupportedEncodingException exception)
					{
					}
				}

				sb.append(line.charAt(j));

				if (inWhiteSpace)
				{
					// ホワイトスペースの内である。

					if (! Character.isWhitespace(line.charAt(j)))
					{
						// ホワイトスペースではない。

						inWhiteSpace = false;
					}
				}

				if (inWhiteSpace)
				{
					// ホワイトスペースの内である。

					leftString += line.charAt(j);
					leftStringColumn = column;
				}

				if (column > width)
				{
					// １行の幅を越えた。

					sb.append("\r\n");
					sb.append(leftString);
					column = leftStringColumn;
				}
			}

			sb.append("\r\n");
		}

		return sb.toString();
	}
}
