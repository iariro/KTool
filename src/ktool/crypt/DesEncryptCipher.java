package ktool.crypt;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * DES暗号用Cipherオブジェクト。
 */
public class DesEncryptCipher
	extends CipherWrapper
{
	/**
	 * DES暗号用Cipherオブジェクトを構築。
	 * @param keyAndIV キーと初期化ベクタ
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 */
	public DesEncryptCipher(DesKeyAndIV keyAndIV)
		throws
			NoSuchAlgorithmException,
			NoSuchPaddingException,
			InvalidKeyException,
			InvalidAlgorithmParameterException
	{
		super("DES/CBC/PKCS5Padding");

		cipher.init(
			Cipher.ENCRYPT_MODE,
			new SecretKeySpec(keyAndIV.key, "DES"),
			new IvParameterSpec(keyAndIV.iv));
	}
}
