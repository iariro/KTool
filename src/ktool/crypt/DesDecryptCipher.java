package ktool.crypt;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * DES復号用Cipherオブジェクト。
 */
public class DesDecryptCipher
	extends CipherWrapper
{
	/**
	 * DES復号用Cipherオブジェクトを構築。
	 * @param keyAndIV キーと初期化ベクタ
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 */
	public DesDecryptCipher(DesKeyAndIV keyAndIV)
		throws
			NoSuchAlgorithmException,
			NoSuchPaddingException,
			InvalidKeyException,
			InvalidAlgorithmParameterException
	{
		super("DES/CBC/PKCS5Padding");

		cipher.init(
			Cipher.DECRYPT_MODE,
			new SecretKeySpec(keyAndIV.key, "DES"),
			new IvParameterSpec(keyAndIV.iv));
	}
}
