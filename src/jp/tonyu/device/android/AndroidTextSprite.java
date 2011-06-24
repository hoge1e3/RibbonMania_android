package jp.tonyu.device.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import jp.tonyu.kernel.screen.TRect;
import jp.tonyu.kernel.screen.sprite.TextSprite;

public class AndroidTextSprite extends TextSprite implements SimpleDrawable {

	public AndroidTextSprite(double x, double y, String text, int color,
			double size, double order) {
		super(x, y, text, color, size, order);
	}

	@Override
	public void draw(Canvas c) {
		Paint paint=new Paint();
		paint.setColor(col);
		float w=paint.measureText(text);
		//Paint.FontMetrics f=paint.getFontMetrics();
		float h=paint.getTextSize();
		c.drawText(text, (int)x, (int)y, paint);
		setTRect(new TRect(x,y,w,h));
	}

}
