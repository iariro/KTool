package ktool.crypt;

import java.security.*;

/**
 * MD5による文字列のハッシュ値からDesKeyAndIVオブジェクトを構築。
 */
public class DesKeyAndIVByMD5
	extends DesKeyAndIV
{
	/**
	 * 指定された文字列をMD5によりハッシュ化し、key, ivを生成。
	 * @param phrease ハッシュ化する文字列
	 * @throws NoSuchAlgorithmException
	 */
	public DesKeyAndIVByMD5(String phrease)
		throws NoSuchAlgorithmException
	{
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte[] passwordByteArray = phrease.getBytes();
		messageDigest.update(passwordByteArray);
		byte [] messageDigestByteArray = messageDigest.digest();

		System.arraycopy(messageDigestByteArray, 0, key, 0, 8);
		System.arraycopy(messageDigestByteArray, 8, iv, 0, 8);
	}
}
