package ktool.db.postgre;

import ktool.db.*;

/**
 * PostgreSQL接続文字列。
 */
public class PostgreDbUrl
	extends DbUrl
{
	/**
	 * 文字列構築。
	 * @param hostName ホスト名
	 * @param dbName DB名
	 */
	public PostgreDbUrl(String hostName, String dbName)
	{
		super(String.format("jdbc:postgresql://%s/%s", hostName, dbName));
	}
}
