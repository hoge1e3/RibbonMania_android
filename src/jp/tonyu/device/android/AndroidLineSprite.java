package jp.tonyu.device.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import jp.tonyu.kernel.screen.sprite.LineSprite;

public class AndroidLineSprite extends LineSprite implements SimpleDrawable {

	public AndroidLineSprite(double sx, double sy, double dx, double dy,
			int color) {
		super(sx, sy, dx, dy, color);
	}

	@Override
	public void draw(Canvas c) {
		Paint paint = new Paint();
		paint.setColor(color);
		c.drawLine((float)sx, (float)sy, (float)dx, (float)dy, paint);

	}

}
