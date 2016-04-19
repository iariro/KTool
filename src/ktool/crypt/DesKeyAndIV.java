package ktool.crypt;

/**
 * DES暗号用キーと初期化ベクタ情報
 *
 */
public class DesKeyAndIV
{
	/**
	 * キー
	 */
	public final byte [] key;

	/**
	 * 初期化ベクタ
	 */
	public final byte [] iv;

	/**
	 * キー，初期化ベクタの領域確保
	 */
	public DesKeyAndIV()
	{
		key = new byte [8];
		iv = new byte [8];
	}
}
