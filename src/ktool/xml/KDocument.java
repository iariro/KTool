package ktool.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * Documentを集約。継承可能なDOMドキュメントクラス。
 * @author kumagai
 */
public class KDocument
{
	private final Document document;
	private final DOMSource source;

	/**
	 * XPathオブジェクトの作成
	 * @param namespace 名前空間プリフィックス
	 * @param uri URI
	 * @return XPathオブジェクト
	 */
	static public XPath createXPath(final String namespace, final String uri)
	{
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        if (namespace != null && uri != null)
        {
	        xpath.setNamespaceContext(
	        	new NamespaceContext()
				{
					public Iterator<String> getPrefixes(String namespaceURI)
					{
						if (namespaceURI == null)
							throw new IllegalArgumentException();
						else if (uri.equals(namespaceURI))
							return Arrays.asList(namespace).iterator();
						return null;
					}

					public String getPrefix(String namespaceURI)
					{
						if (namespaceURI == null)
							throw new IllegalArgumentException();
						else if (uri.equals(namespaceURI))
							return namespace;
						return null;
					}

					public String getNamespaceURI(String prefix)
					{
						if (prefix == null)
							throw new IllegalArgumentException();
						else if (namespace.equals(prefix))
							return uri;
						return null;
					}
			});
        }

        return xpath;
	}

	/**
	 * 新規作成用コンストラクタ。
	 *
	 * @throws ParserConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 */
	public KDocument()
		throws ParserConfigurationException,
		TransformerConfigurationException,
		TransformerFactoryConfigurationError
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();

		document = db.newDocument();
		source = new DOMSource(document);
	}

	/**
	 * ファイル名指定によるXMLファイルロード用コンストラクタ。
	 *
	 * @param fileName ファイル名
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 */
	public KDocument(String fileName)
		throws IOException,
		SAXException,
		ParserConfigurationException,
		TransformerConfigurationException,
		TransformerFactoryConfigurationError
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		FileInputStream fis = new FileInputStream(fileName);

		document = db.parse(fis);
		source = new DOMSource(document);
	}

	/**
	 * ストリームによるXMLファイルロード用コンストラクタ。
	 * @param stream 読み込むストリーム
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 */
	public KDocument(InputStream stream)
		throws ParserConfigurationException,
		SAXException,
		IOException,
		TransformerConfigurationException,
		TransformerFactoryConfigurationError
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();

		document = db.parse(stream);
		source = new DOMSource(document);
	}

	/**
	 * トップ要素を取得。
	 * @return トップ要素
	 */
	public Element getDocumentElement()
	{
		return document.getDocumentElement();
	}

	/**
	 * 要素を作成。
	 * @param name 要素名
	 * @return 作成した要素
	 */
	public Element createElement(String name)
	{
		return document.createElement(name);
	}

	/**
	 * 子要素を追加。
	 * @param child 子要素
	 * @return 追加したノード
	 */
	public Node appendChild(Node child)
	{
		return document.appendChild(child);
	}

	/**
	 * テキストノード生成。
	 * @param text テキスト
	 * @return 生成したノード
	 */
	public Text createTextNode(String text)
	{
		return document.createTextNode(text);
	}

	/**
	 * Transormerを使用した書き込み。
	 *
	 * @param transformer Transormer
	 * @param writer 出力Writer オブジェクト
	 * @throws TransformerException
	 *
	 * @date 2009/05/12
	 *	- kumagai:new
	 */
	public void write(Transformer transformer, Writer writer)
		throws TransformerException
	{
		transformer.transform(source, new StreamResult(writer));
	}

	/**
	 * Writeへの出力。
	 *
	 * @param writer 出力Writer オブジェクト
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 * @throws TransformerConfigurationException
	 *
	 * @date 2009/05/13
	 *	- kumagai:new
	 */
	public void write(Writer writer)
		throws TransformerConfigurationException,
		TransformerException,
		TransformerFactoryConfigurationError
	{
		write(TransformerFactory.newInstance().newTransformer(), writer);
	}

	/**
	 * 集約しているDocumentオブジェクトを返却する。
	 * @return XMLドキュメント
	 */
	public Document getDocument()
	{
		return (Document)document;
	}
}
