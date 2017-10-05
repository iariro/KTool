package ktool.io;

import java.io.File;

/**
 * ディレクトリ取得関数を提供するクラス。
 * @author kumagai
 * 2004/11/03
 */
public class Directory
{
	/**
	 * ファイルリスト取得。
	 * @param path 対象パス
	 * @return ファイルリスト
	 * <pre>
	 * 履歴
	 * 2004.11.16 Kumagai
	 * listFiles()失敗時にnullを返却するよう修正
	 * </pre>
	 */
	static public File [] getFiles(String path)
	{
		File folder = new File(path);
		File [] fileList = folder.listFiles();

		if (fileList != null)
		{
			// 取得成功。

			return removeDirectory(fileList);
		}
		else
		{
			// 取得失敗。

			return null;
		}
	}

	/**
	 * ファイルリストからディレクトリ分のエントリを削除して返却。
	 * @param dir1 対象ファイルリスト
	 * @return ファイル分のみのファイルリスト
	 * <pre>
	 * 履歴
	 * <li>2004.11.16 Kumagai
	 * <code>for(i=0 ; i<num ; i++)</code>
	 * を
	 * <code>for(i=0 ; i<dir1.length ; i++)</code>
	 * に修正
	 * </pre>
	 */
	static private File [] removeDirectory(File [] dir1)
	{
		int num = 0;

		for (int i=0 ; i<dir1.length ; i++)
		{
			if (! dir1[i].isDirectory())
			{
				// ディレクトリではない＝ファイルである。

				num++;
			}
		}

		File [] dir2 = new File [num];

		int count = 0;

		for (int i=0 ; i<dir1.length ; i++)
		{
			if (! dir1[i].isDirectory())
			{
				// ディレクトリではない＝ファイルである。

				dir2[count] = dir1[i];
				count++;
			}
		}

		return dir2;
	}
}
