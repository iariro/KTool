package ktool.net;

import java.io.*;
import java.net.*;
import org.apache.tools.ant.*;

/**
 * Ant用HTTPダウンロードタスク。
 * @author kumagai
 *
 * <br>
 * 使用例：
 * <p><blockquote><pre>
 * &lt;taskdef name="httpdownload" classname="ktool.net.HttpDownloadTask" classpath="KTool.jar" /&gt;
 *
 * &lt;target name="download"&gt;
 * 	&lt;httpdownload url="http://hostname/index.html" filepath="index.html" /&gt;
 * &lt;/target&gt;
 * </pre></blockquote>
 */
public class HttpDownloadTask
	extends Task
{
	private String url;
	private String filepath;

	/**
	 * urlセッター。
	 * @param url URL
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * urlゲッター。
	 * @return URL
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * ファイルパスセッター。
	 * @param filepath ファイルパス
	 */
	public void setFilepath(String filepath)
	{
		this.filepath = filepath;
	}

	/**
	 * ファイルパスゲッター。
	 * @return ファイルパス
	 */
	public String getFilepath()
	{
		return filepath;
	}

	/**
	 * HTTPダウンロード実行。
	 */
	@Override
	public void execute()
		throws BuildException
	{
		try
		{
			URL url = new URL(this.url);

			InputStream in = url.openStream();
			FileOutputStream out = new FileOutputStream(filepath);

			byte [] buffer = new byte [10000];
			int recv;

			while ((recv = in.read(buffer)) > 0)
			{
				out.write(buffer, 0, recv);
			}

			in.close();
			out.close();
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}
	}
}
