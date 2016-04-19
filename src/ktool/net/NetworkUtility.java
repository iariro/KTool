package ktool.net;

import java.net.*;

/**
 * ネットワークユーティリティ。
 * @author kumagai
 */
public class NetworkUtility
{
	/**
	 * @brief プログラムが稼動しているホストの名前を取得。
	 * @return ホスト名
	 * @par 履歴:
	 *	- 2006/03/02 Kumagai
	 *		- 新規作成。
	 */
	static public String getHostName()
	{
		try
		{
			return InetAddress.getLocalHost().getHostName();
		}
		catch(UnknownHostException exception)
		{
			return null;
		}
	}
}
