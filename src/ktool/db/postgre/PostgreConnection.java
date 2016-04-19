package ktool.db.postgre;

import java.sql.*;
import ktool.db.*;

/**
 * PostgreSQLコネクション。
 */
public class PostgreConnection
	extends KConnection
{
	/**
	 * PostgreSQLコネクションを構築。
	 * @throws SQLException
	 */
	public PostgreConnection()
		throws SQLException
	{
		super(new org.postgresql.Driver());
	}
}
