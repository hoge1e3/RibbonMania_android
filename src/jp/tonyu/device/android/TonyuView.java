package jp.tonyu.device.android;

import java.util.List;
//git@github.com:hoge1e3/RibbonMania_android.git
import jp.tonyu.kernel.screen.Screen;
import jp.tonyu.kernel.screen.pattern.CharPattern;
import jp.tonyu.kernel.screen.sprite.ImageSprite;
import jp.tonyu.kernel.screen.sprite.LineSprite;
import jp.tonyu.kernel.screen.sprite.TextSprite;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class TonyuView extends SurfaceView implements Screen, SurfaceHolder.Callback {
	/*@Override
	protected void onDraw(Canvas canvas) {
		Log.d("pp","onDraw");
		Paint p=new Paint();
		//p.setFlags(Paint.)
		for (int i=0 ; i<list.size(); i++) {
			BitmapCharPattern bitmap=(BitmapCharPattern) list.get(i);
			canvas.drawBitmap(bitmap.bmp, i*10, i*10+50, p);
		}
		//redraw(list);
	}*/
	final List<CharPattern> list;
	int bgcolor=Color.argb(255, 20, 80, 180) ;//(20,80,180);
	public synchronized void redraw() {
		SurfaceHolder h=getHolder();
		if (h==null) return;
		Canvas canvas = h.lockCanvas();
		Log.d("pp","canvas="+canvas);
		if (canvas==null) return;
		Log.d("pp","redraw?");
		canvas.drawColor(bgcolor);
		//Paint paint=new Paint();
		//paint.setAlpha(128);
		for (int i=0 ; i<list.size(); i++) {
			BitmapCharPattern bitmap=(BitmapCharPattern) list.get(i);
			//canvas.drawBitmap(bitmap.bmp, i*10, i*10, paint);
			AndroidImageSprite sp = new AndroidImageSprite(i*10,i*10, bitmap,false,0,i,255-i*5,
					1+((float)i)*0.1,1+((float)i)*0.1);
			sp.draw(canvas);
		}
		//onRedraw(canvas);
		h.unlockCanvasAndPost(canvas);
	}
	public TonyuView(Context context, List<CharPattern> p) {
		super(context);
		list=p;
		Log.d("pp", "sz="+list.size());
		getHolder().addCallback(this);
	}

	@Override
	public ImageSprite addImageSprite(double x, double y, CharPattern p,
			boolean f, double order, double angle, double alpha, double scaleX,
			double scaleY) {
		return null;
	}

	@Override
	public LineSprite addLineSprite(double sx, double sy, double dx, double dy,
			int color) {
		return null;
	}

	@Override
	public TextSprite addTextSprite(double x, double y, String text, int color,
			double size, double order) {
		return null;
	}

	@Override
	public void clearSprites() {

	}

	@Override
	public void drawSprites() {

	}

	@Override
	public int getMouseX() {
		return 0;
	}

	@Override
	public int getMouseY() {
		return 0;
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO 自動生成されたメソッド・スタブ

	}
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		redraw();
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
