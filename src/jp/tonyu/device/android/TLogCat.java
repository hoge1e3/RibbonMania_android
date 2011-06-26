package jp.tonyu.device.android;

import android.util.Log;
import jp.tonyu.debug.LogCat;

public class TLogCat implements LogCat {

	@Override
	public void d(Object tag, Object content) {
		Log.d(tag+"",content+"");

	}

	@Override
	public void e(Object tag, Object content) {
		Log.e(tag+"",content+"");

	}

	@Override
	public void v(Object tag, Object content) {
		Log.v(tag+"",content+"");
	}

	@Override
	public void w(Object tag, Object content) {
		Log.w(tag+"",content+"");
	}

}
