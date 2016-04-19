package ktool.xml;

import org.w3c.dom.*;

/**
 * 簡易的な扱いが可能なXML要素。XmlMapper使用時に使用する。
 * @date 2004/11/08 Kumagai
 *	- 新規作成。
 */
public class StructElement
{
	private final Element element;

	/**
	 * @brief 指定の実物の要素を集約しつつオブジェクトを構築する。
	 * @param element 実物の要素
	 */
	public StructElement(Element element)
	{
		this.element = element;
	}

	/**
	 * 指定の名前の要素をStructElementの形で取得
	 * @param name 取得する子要素の名前
	 * @return 取得した子要素
	 */
	public StructElement getChildElementByName(String name)
	{
		Element choose = null;
		NodeList list = element.getChildNodes();

		for (int i=0 ; i<list.getLength() ; i++)
		{
			Node child = list.item(i);

			if (child.getNodeType() == Node.ELEMENT_NODE)
			{
				// 要素である。

				if (child.getNodeName() == name)
				{
					// 指定の要素名である。

					choose = (Element)child;
				}
			}
		}

		if(choose != null)
		{
			// 見つかった。

			return new StructElement(choose);
		}
		else
		{
			// 見つからなかった。

			return null;
		}
	}

	/**
	 * @brief 全ての子要素をStructElement配列の型で取得。
	 * @return 全ての子要素
	 */
	public StructElement [] getChildElements()
	{
		int num = 0;
		NodeList list = element.getChildNodes();

		for (int i=0 ; i<list.getLength() ; i++)
		{
			Node child = list.item(i);

			if (child.getNodeType() == Node.ELEMENT_NODE)
			{
				// 要素である。

				num++;
			}
		}

		StructElement [] elements = new StructElement [num];

		int count = 0;
		list = element.getChildNodes();

		for (int i=0 ; i<list.getLength() ; i++)
		{
			Node child = list.item(i);

			if (child.getNodeType() == Node.ELEMENT_NODE)
			{
				// 要素である。

				elements[count] = new StructElement((Element)child);
				count++;
			}
		}

		return elements;
	}

	/**
	 * @brief 要素内容の文字列を取得。
	 * @return 要素内容の文字列
	 */
	public String getContent()
	{
		String ret = null;

		if (element != null)
		{
			// 要素あり。

			Node child = element.getFirstChild();

			if (child != null)
			{
				// ノードあり。

				ret = child.getNodeValue();
			}
		}

		return ret;
	}

	/**
	 * 要素名は指定の名前である。
	 * @param name 比較する要素名
	 * @return true=一致する／false=しない
	 */
	public boolean isEqualInName(String name)
	{
		return element.getNodeName().equals(name);
	}

	/**
	 * @brief 実物の要素を取得
	 * @return 実物の要素
	 */
	public Element element()
	{
		return element;
	}
}
