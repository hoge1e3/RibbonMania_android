package jp.tonyu.device.android;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import jp.tonyu.kernel.screen.pattern.CharPattern;
import jp.tonyu.kernel.screen.sprite.ImageSprite;

public class BitmapSprite extends ImageSprite implements SimpleDrawable {

	public BitmapSprite(double x, double y, CharPattern p, boolean f,
			double order, double angle, double alpha, double scaleX,
			double scaleY) {
		super(x, y, p, f, order, angle, alpha, scaleX, scaleY);

	}
	@Override
	public void draw(Canvas c) {
		if (p instanceof BitmapCharPattern) {
			Paint paint=new Paint();
			paint.setAlpha((int)alpha);
			c.save();
			c.rotate((float)angle ,(float)x,(float)y);
			//c.translate(x, y);
			c.scale((float)scaleX, (float)scaleY,(float)x,(float)y);

			Bitmap bitmap = ((BitmapCharPattern)p).bmp;
			c.drawBitmap(bitmap, (float)(x-bitmap.getWidth()/2),(float)(y-bitmap.getHeight()/2), paint);
			c.restore();
		}
	}
}
