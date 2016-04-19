package ktool.window;

import java.awt.*;
import java.awt.event.*;

/**
 * 簡単なフレームウインドウアプリケーションのためのベースクラス。
 */
public class ApplicationFrame
	extends Frame
{
	/**
	 * 基底クラスの初期化・イベントの設定・サイズ指定などを行う。
	 * @param size サイズ
	 * @param title タイトル
	 */
	public ApplicationFrame(Dimension size, String title)
	{
		super(title);

		addWindowListener(new WindowCallback());
		setSize(size);
		setResizable(false);
	}

	/**
	 * 表示処理。
	 */
	public void run()
	{
		initialize();
		setVisible(true);
	}

	/**
	 * 各フレームごとの初期化処理
	 * @return true=成功／false=失敗
	 */
	protected boolean initialize()
	{
		// 空のデフォルト処理につき実装なし

		return true;
	}

	/**
	 * ウインドウクローズ時基底処理。
	 */
	protected void onClose()
	{
		// 何もしない。
	}

	/**
	 * ウインドウクローズ時。
	 */
	private void close()
	{
		onClose();
		terminate();
		dispose();
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
	 * ウインドウ処理イベントコールバッククラス。
	 * @author kumagai
	 */
	class WindowCallback
		implements WindowListener
	{
		/**
		 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
		 */
		public void windowOpened(WindowEvent evt)
		{
		}

		/**
		 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
		 */
		public void windowIconified(WindowEvent evt)
		{
		}

		/**
		 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
		 */
		public void windowDeiconified(WindowEvent evt)
		{
		}

		/**
		 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
		 */
		public void windowDeactivated(WindowEvent evt)
		{
		}

		/**
		 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
		 */
		public void windowClosing(WindowEvent evt)
		{
			close();
		}

		/**
		 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
		 */
		public void windowClosed(WindowEvent evt)
		{
		}

		/**
		 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
		 */
		public void windowActivated(WindowEvent evt)
		{
		}
	}
}
