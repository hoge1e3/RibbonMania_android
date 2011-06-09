package jp.tonyu.device.android;

import android.graphics.Bitmap;
import jp.tonyu.kernel.screen.pattern.CharPattern;

public class BitmapCharPattern implements CharPattern {
	Bitmap bmp;
	public BitmapCharPattern(Bitmap bmp) {
		this.bmp=bmp;
	}

}
