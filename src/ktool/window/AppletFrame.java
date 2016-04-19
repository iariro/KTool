package ktool.window;

import java.awt.*;
import java.applet.*;

/**
 * Applet をフレームウインドウアプリケーションとして扱うことができる。
 */
public class AppletFrame
	extends ApplicationFrame
{
	private final Applet applet;

	/**
	 * 基底クラスの初期化・アプレットの設置を行う。
	 * @param applet アプレットオブジェクト
	 * @param size サイズ
	 * @param title タイトル
	 */
	public AppletFrame(Applet applet, Dimension size, String title)
	{
		super(size, title);

		this.applet = applet;

		add(applet, BorderLayout.CENTER);
	}

	/**
	 * 実行開始。
	 */
	public void run()
	{
		applet.init();
		applet.start();
		setVisible(true);
	}
}
