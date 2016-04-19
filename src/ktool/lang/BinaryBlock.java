package ktool.lang;

import java.io.*;

/**
 * バイト列オブジェクト。
 * デバッグに適
 */
public class BinaryBlock
{
	/**
	 * 4バイトをint値化。リトルエンディアンによる。
	 * @param buffer バッファ
	 * @param start 開始位置
	 * @return int値
	 */
	static public int toInt(byte [] buffer, int start)
	{
		return
			(0xff & buffer[start + 0]) +
			((0xff & buffer[start + 1]) << 8) +
			((0xff & buffer[start + 2]) << 16) +
			((0xff & buffer[start + 3]) << 24);
	}

	protected byte [] data;

	/**
	 * 対象のバイト列を関連付けて初期化。
	 * @param data 対象のバイト列
	 */
	public BinaryBlock(byte [] data)
	{
		this.data = data;
	}

	/**
	 * 内容をそのままダンプ。
	 * @param stream 出力するストリーム
	 * @throws IOException
	 */
	public void dump(OutputStream stream)
		throws IOException
	{
		stream.write(data);
	}

	/**
	 * デバッグ用に１６進形式でダンプ。
	 * @param stream 出力するストリーム
	 */
	public void debugDump(PrintStream stream)
	{
		for (int i=0 ; i<data.length ; i++)
		{
			stream.print(Byte.toHexString(data[i]));

			if (i % 0x10 < 0x0f)
			{
				// 行末ではない。

				if (i < data.length)
				{
					// データ末尾ではない。

					stream.print(" ");
				}
			}
			else
			{
				// 行末。

				stream.println();
			}
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String ret = new String();

		for (int i=0 ; i<data.length ; i++)
		{
			ret += Byte.toHexString(data[i]);

			if (i % 0x10 < 0x0f)
			{
				// 行末ではない。

				if (i < data.length)
				{
					// 末尾ではない。

					ret += " ";
				}
			}
			else
			{
				// 行末。

				ret += "\n";
			}
		}

		return ret;
	}
}
