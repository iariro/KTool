package ktool.string;

import java.util.*;

/**
 * <pre>
 * 不定個のStringをString配列にするクラス。
 * String単体でも、String配列でも追加が可能。
 * </pre>
 * @author Kumagai
 */
public class StringArray
{
	private final Vector<String> vector;

	/**
	 * vectorを割り当てる。
	 */
	public StringArray()
	{
		vector = new Vector<String>();
	}

	/**
	 * String単体の追加。
	 * @param string 値
	 */
	public void add(String string)
	{
		vector.add(string);
	}

	/**
	 * String配列の追加。
	 * @param stringArray String配列
	 */
	public void add(String [] stringArray)
	{
		if (stringArray != null)
		{
			// 値指定あり。

			for (int i=0 ; i<stringArray.length ; i++)
			{
				vector.add(stringArray[i]);
			}
		}
	}

	/**
	 * 溜め込んだStringをStringの配列型で取得。
	 * @return 内容を保持するStringの配列
	 */
	public String [] getStringArray()
	{
		String [] ret = new String [vector.size()];

		for (int i=0 ; i<vector.size() ; i++)
		{
			ret[i] = (String)vector.get(i);
		}

		return ret;
	}
}
