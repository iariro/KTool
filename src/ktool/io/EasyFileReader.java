package ktool.io;

import java.io.*;

/**
 * ファイル読み取りユーティリティ。
 * @author kumagai
 */
public class EasyFileReader
	extends FileInputStream
{
	protected final int size;

	/**
	 * オブジェクトを構築。
	 * @param fileName ファイル名
	 * @throws FileNotFoundException
	 */
	public EasyFileReader(String fileName)
		throws FileNotFoundException
	{
		super(fileName);

		File file = new File(fileName);
		size = (int)file.length();
	}

	/**
	 * ファイル内容取得。
	 * @return ファイル内容
	 */
	public byte [] get()
	{
		byte [] buffer = new byte [size];

		try
		{
			read(buffer);
		}
		catch(IOException exception)
		{
			buffer = null;
		}

		return buffer;
	}
}
