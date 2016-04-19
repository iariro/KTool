package ktool.io;

import java.io.*;
import java.util.*;

/**
 * テキストファイルから構築可能な文字列配列。
 * @author kumagai
 */
public class StringListFromFile
	extends ArrayList<String>
{
	/**
	 * オブジェクトを構築。
	 * @param filename ファイル名
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public StringListFromFile(String filename)
		throws FileNotFoundException, IOException
	{
		this(filename, "Shift_JIS");
	}

	/**
	 * オブジェクトの構築とともに、指定ファイルから文字列配列を取得。
	 * @param fileName 読み込むファイル
	 * @param encode 文字コード名
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public StringListFromFile(String fileName, String encode)
		throws FileNotFoundException, IOException
	{
		BufferedReader reader =
			new BufferedReader(
				new InputStreamReader(
					new FileInputStream(fileName), encode));

		String line;

		while ((line = reader.readLine()) != null)
		{
			add(line);
		}

		reader.close();
	}
}
