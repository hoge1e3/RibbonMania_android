package jp.tonyu.device.android;

import android.graphics.Bitmap;
import jp.tonyu.kernel.screen.pattern.CharPattern;
import jp.tonyu.kernel.screen.TSize;

public class BitmapCharPattern implements CharPattern {
	Bitmap bmp;
	public BitmapCharPattern(Bitmap bmp) {
		this.bmp=bmp;
	}
	@Override
	public TSize getSize() {
		return new TSize( bmp.getWidth(), bmp.getHeight());
	}

}
