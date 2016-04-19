package ktool.db;

import java.sql.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * DBコネクションラッパーオブジェクト。
 */
public class KConnection
	implements Connection
{
	private Connection connection;

	/**
	 * @param driver ドライバ
	 * @throws SQLException
	 */
	public KConnection(Driver driver)
		throws SQLException
	{
		DriverManager.registerDriver(driver);
	}

	/**
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	public <T> T unwrap(Class<T> iface) throws SQLException
	{
		return connection.unwrap(iface);
	}

	/**
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	public boolean isWrapperFor(Class<?> iface) throws SQLException
	{
		return connection.isWrapperFor(iface);
	}

	/**
	 * @see java.sql.Connection#createClob()
	 */
	public Clob createClob() throws SQLException
	{
		return connection.createClob();
	}

	/**
	 * @see java.sql.Connection#createBlob()
	 */
	public Blob createBlob() throws SQLException
	{
		return connection.createBlob();
	}

	/**
	 * @see java.sql.Connection#createNClob()
	 */
	public NClob createNClob() throws SQLException
	{
		return connection.createNClob();
	}

	/**
	 * @see java.sql.Connection#createSQLXML()
	 */
	public SQLXML createSQLXML() throws SQLException
	{
		return connection.createSQLXML();
	}

	/**
	 * @see java.sql.Connection#isValid(int)
	 */
	public boolean isValid(int timeout) throws SQLException
	{
		return connection.isValid(timeout);
	}

	/**
	 * @see java.sql.Connection#setClientInfo(java.lang.String, java.lang.String)
	 */
	public void setClientInfo(String name, String value)
			throws SQLClientInfoException
	{
		connection.setClientInfo(name, value);
	}

	/**
	 * @see java.sql.Connection#setClientInfo(java.util.Properties)
	 */
	public void setClientInfo(Properties properties)
		throws SQLClientInfoException
	{
		connection.setClientInfo(properties);
	}

	/**
	 * @see java.sql.Connection#getClientInfo(java.lang.String)
	 */
	public String getClientInfo(String name) throws SQLException
	{
		return connection.getClientInfo(name);
	}

	/**
	 * @see java.sql.Connection#getClientInfo()
	 */
	public Properties getClientInfo() throws SQLException
	{
		return connection.getClientInfo();
	}

	/**
	 * @see java.sql.Connection#createArrayOf(java.lang.String, java.lang.Object[])
	 */
	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException
	{
		return connection.createArrayOf(typeName, elements);
	}

	/**
	 * @see java.sql.Connection#createStruct(java.lang.String, java.lang.Object[])
	 */
	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException
	{
		return connection.createStruct(typeName, attributes);
	}

	/**
	 * @see java.sql.Connection#setSchema(java.lang.String)
	 */
	public void setSchema(String schema) throws SQLException
	{
		connection.setSchema(schema);
	}

	/**
	 * (非 Javadoc)
	 * @see java.sql.Connection#getSchema()
	 */
	public String getSchema() throws SQLException
	{
		return connection.getSchema();
	}

	/**
	 * @see java.sql.Connection#abort(java.util.concurrent.Executor)
	 */
	public void abort(Executor executor) throws SQLException
	{
		connection.abort(executor);
	}

	/**
	 * @see java.sql.Connection#setNetworkTimeout(java.util.concurrent.Executor, int)
	 */
	public void setNetworkTimeout(Executor executor, int milliseconds)
			throws SQLException
	{
		connection.setNetworkTimeout(executor, milliseconds);
	}

	/**
	 * @see java.sql.Connection#getNetworkTimeout()
	 */
	public int getNetworkTimeout() throws SQLException
	{
		return connection.getNetworkTimeout();
	}

	/**
	 * @param dbUrl DB URL
	 * @param user ユーザ名
	 * @param password パスワード
	 */
	public void connect(DbUrl dbUrl, String user, String password)
		throws SQLException
	{
		connection =
			DriverManager.getConnection(dbUrl.toString(), user, password);
	}

	/**
	 * @see java.sql.Connection#createStatement()
	 */
	public Statement createStatement()
		throws SQLException
	{
		return connection.createStatement();
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String)
	 */
	public PreparedStatement prepareStatement(String arg0)
		throws SQLException
	{
		return connection.prepareStatement(arg0);
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String)
	 */
	public CallableStatement prepareCall(String arg0)
		throws SQLException
	{
		return connection.prepareCall(arg0);
	}

	/**
	 * @see java.sql.Connection#nativeSQL(java.lang.String)
	 */
	public String nativeSQL(String arg0)
		throws SQLException
	{
		return connection.nativeSQL(arg0);
	}

	/**
	 * @see java.sql.Connection#setAutoCommit(boolean)
	 */
	public void setAutoCommit(boolean arg0)
		throws SQLException
	{
		connection.setAutoCommit(arg0);
	}

	/**
	 * @see java.sql.Connection#getAutoCommit()
	 */
	public boolean getAutoCommit()
		throws SQLException
	{
		return connection.getAutoCommit();
	}

	/**
	 * @see java.sql.Connection#commit()
	 */
	public void commit()
		throws SQLException
	{
		connection.commit();
	}

	/**
	 * @see java.sql.Connection#rollback()
	 */
	public void rollback()
		throws SQLException
	{
		connection.rollback();
	}

	/**
	 * @see java.sql.Connection#close()
	 */
	public void close()
		throws SQLException
	{
		connection.close();
	}

	/**
	 * @see java.sql.Connection#isClosed()
	 */
	public boolean isClosed()
		throws SQLException
	{
		return connection.isClosed();
	}

	/**
	 * @see java.sql.Connection#getMetaData()
	 */
	public DatabaseMetaData getMetaData()
		throws SQLException
	{
		return connection.getMetaData();
	}

	/**
	 * @see java.sql.Connection#setReadOnly(boolean)
	 */
	public void setReadOnly(boolean arg0)
		throws SQLException
	{
		connection.setReadOnly(arg0);
	}

	/**
	 * @see java.sql.Connection#isReadOnly()
	 */
	public boolean isReadOnly()
		throws SQLException
	{
		return connection.isReadOnly();
	}

	/**
	 * @see java.sql.Connection#setCatalog(java.lang.String)
	 */
	public void setCatalog(String arg0)
		throws SQLException
	{
		connection.setCatalog(arg0);
	}

	/**
	 * @see java.sql.Connection#getCatalog()
	 */
	public String getCatalog()
		throws SQLException
	{
		return connection.getCatalog();
	}

	/**
	 * @see java.sql.Connection#setTransactionIsolation(int)
	 */
	public void setTransactionIsolation(int arg0)
		throws SQLException
	{
		connection.setTransactionIsolation(arg0);
	}

	/**
	 * @see java.sql.Connection#getTransactionIsolation()
	 */
	public int getTransactionIsolation()
		throws SQLException
	{
		return connection.getTransactionIsolation();
	}

	/**
	 * @see java.sql.Connection#getWarnings()
	 */
	public SQLWarning getWarnings()
		throws SQLException
	{
		return connection.getWarnings();
	}

	/**
	 * @see java.sql.Connection#clearWarnings()
	 */
	public void clearWarnings()
		throws SQLException
	{
		connection.clearWarnings();
	}

	/**
	 * @see java.sql.Connection#createStatement(int, int)
	 */
	public Statement createStatement(int arg0, int arg1)
		throws SQLException
	{
		return connection.createStatement(arg0, arg1);
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
	 */
	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2)
		throws SQLException
	{
		return connection.prepareStatement(arg0, arg1, arg2);
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
	 */
	public CallableStatement prepareCall(String arg0, int arg1, int arg2)
		throws SQLException
	{
		return connection.prepareCall(arg0, arg1, arg2);
	}

	/**
	 * @see java.sql.Connection#getTypeMap()
	 */
	public Map<String, Class<?>> getTypeMap()
		throws SQLException
	{
		return connection.getTypeMap();
	}

	/**
	 * @see java.sql.Connection#setTypeMap(java.util.Map)
	 */
	public void setTypeMap(Map<String, Class<?>> arg0)
		throws SQLException
	{
		connection.setTypeMap(arg0);
	}

	/**
	 * @see java.sql.Connection#setHoldability(int)
	 */
	public void setHoldability(int arg0)
		throws SQLException
	{
		connection.setHoldability(arg0);
	}

	/**
	 * @see java.sql.Connection#getHoldability()
	 */
	public int getHoldability()
		throws SQLException
	{
		return connection.getHoldability();
	}

	/**
	 * @see java.sql.Connection#setSavepoint()
	 */
	public Savepoint setSavepoint()
		throws SQLException
	{
		return connection.setSavepoint();
	}

	/**
	 * @see java.sql.Connection#setSavepoint(java.lang.String)
	 */
	public Savepoint setSavepoint(String arg0)
		throws SQLException
	{
		return connection.setSavepoint(arg0);
	}

	/**
	 * @see java.sql.Connection#rollback(java.sql.Savepoint)
	 */
	public void rollback(Savepoint arg0)
		throws SQLException
	{
		connection.rollback(arg0);
	}

	/**
	 * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
	 */
	public void releaseSavepoint(Savepoint arg0)
		throws SQLException
	{
		connection.releaseSavepoint(arg0);
	}

	/**
	 * @see java.sql.Connection#createStatement(int, int, int)
	 */
	public Statement createStatement(int arg0, int arg1, int arg2)
		throws SQLException
	{
		return connection.createStatement(arg0, arg1, arg2);
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
	 */
	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3)
		throws SQLException
	{
		return connection.prepareStatement(arg0, arg1, arg2, arg3);
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
	 */
	public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3)
		throws SQLException
	{
		return connection.prepareCall(arg0, arg1, arg2, arg3);
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int)
	 */
	public PreparedStatement prepareStatement(String arg0, int arg1)
		throws SQLException
	{
		return connection.prepareStatement(arg0, arg1);
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
	 */
	public PreparedStatement prepareStatement(String arg0, int[] arg1)
		throws SQLException
	{
		return connection.prepareStatement(arg0, arg1);
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
	 */
	public PreparedStatement prepareStatement(String arg0, String[] arg1)
		throws SQLException
	{
		return connection.prepareStatement(arg0, arg1);
	}
}
