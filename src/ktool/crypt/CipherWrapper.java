package ktool.crypt;

import java.security.*;
import java.io.*;
import javax.crypto.*;

/**
 * Cipherオブジェクトをラップ。
 * これを継承してCipherオブジェクトの構築を行うとよい。
 *
 * Cipher cipher = new DesDecryptCipher(new DesKeyAndIVByMD5(args[0])).getCipher();
 */
public abstract class CipherWrapper
{
	protected final Cipher cipher;

	/**
	 * 暗号名を指定してCipherオブジェクトを生成する。
	 * @param cipherName 暗号名
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public CipherWrapper(String cipherName)
		throws NoSuchAlgorithmException, NoSuchPaddingException
	{
		cipher = Cipher.getInstance(cipherName);
	}

	/**
	 * Cipherオブジェクトを取得。
	 * @return 集約しているCipherオブジェクト
	 */
	public Cipher getCipher()
	{
		return cipher;
	}

	/**
	 * 指定のストリームをデコレートした暗号入力ストリームを生成する。
	 * @param stream デコレートするストリーム
	 * @return デコレートした暗号入力ストリーム
	 */
	public InputStream createInputStream(InputStream stream)
	{
		return new CipherInputStream(stream, cipher);
	}

	/**
	 * 指定のストリームをデコレートした暗号出力ストリームを生成する。
	 * @param stream デコレートするストリーム
	 * @return デコレートした暗号出力ストリーム
	 */
	public OutputStream createOutputStream(OutputStream stream)
	{
		return new CipherOutputStream(stream, cipher);
	}
}
