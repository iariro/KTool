package ktool.io;

import java.io.*;

/**
 * ストリームの内容をもう一方のストリームへ出力するクラス。
 */
public class StreamProcessor
{
	private final InputStream in;
	private final OutputStream out;

	/**
	 * オブジェクトの構築とともにストリームの集約を行う。
	 * @param in 入力ストリーム
	 * @param out 出力ストリーム
	 */
	public StreamProcessor(InputStream in, OutputStream out)
	{
		this.in = in;
		this.out = out;
	}

	/**
	 * ストリームの内容をもう一方のストリームへ出力。
	 * この中でストリームのクローズも行う。
	 * @throws IOException
	 */
	public void process()
		throws IOException
	{
		int data;

		while ((data = in.read()) >= 0)
		{
			out.write(data);
		}

		in.close();
		out.close();
	}
}
