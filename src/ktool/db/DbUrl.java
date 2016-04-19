package ktool.db;

/**
 * DB URLオブジェクト。
 */
public class DbUrl
{
	public final String dbUrl;

	/**
	 * DB URLオブジェクトを構築。
	 * @param dbUrl DB URL
	 */
	public DbUrl(String dbUrl)
	{
		this.dbUrl = dbUrl;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return dbUrl;
	}
}
