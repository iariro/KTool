package ktool.window;

import java.awt.*;
import java.awt.event.*;

/**
 * ダミーのダイアログ。
 * @author kumagai
 */
public class DummyDialog
	extends Dialog
{
	/**
	 * 基底クラスの初期化・イベントの設定を行う。
	 * @param owner オーナーウインドウ
	 * @param caption ウインドウタイトル
	 */
	public DummyDialog(Frame owner, String caption)
	{
		super(owner, caption, true);

		addWindowListener(new WindowAdapterCallback());
	}

	/**
	 * 終了処理。
	 */
	private void terminate()
	{
		for (int i=0 ; i<getComponentCount() ; i++)
		{
			Object comp1 = getComponent(i);

			if (comp1 instanceof Terminatable)
			{
				// 終了処理あり。

				Terminatable comp2 = (Terminatable)comp1;
				comp2.terminate();
			}
		}
	}

	/**
	 * ウインドウを閉じるイベント処理用コールバッククラス。
	 * @author kumagai
	 */
	private class WindowAdapterCallback
		extends WindowAdapter
	{
		/**
		 * ウインドウを閉じるイベント。
		 */
		public void windowClosing(WindowEvent event)
		{
			terminate();
			dispose();
		}
	}
}
