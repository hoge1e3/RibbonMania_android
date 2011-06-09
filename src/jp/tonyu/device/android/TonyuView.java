package jp.tonyu.device.android;

import java.util.List;

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

public class TonyuView extends View implements Screen {
	@Override
	protected void onDraw(Canvas canvas) {
		Log.d("pp","onDraw");
		Paint p=new Paint();
		//p.setFlags(Paint.)
		for (int i=0 ; i<list.size(); i++) {
			BitmapCharPattern bitmap=(BitmapCharPattern) list.get(i);
			canvas.drawBitmap(bitmap.bmp, i*10, i*10+50, p);
		}
		//redraw(list);
	}
	final List<CharPattern> list;


	/*public synchronized void redraw(List<CharPattern> l) {
		SurfaceHolder h=getHolder();
		if (h==null) return;
		Canvas canvas = h.lockCanvas();
		Log.d("pp","canvas="+canvas);
		if (canvas==null) return;
		Log.d("pp","redraw?");
		canvas.drawColor(Color.WHITE);
		//Paint paint=new Paint();
		for (int i=0 ; i<l.size(); i++) {
			BitmapCharPattern bitmap=(BitmapCharPattern) l.get(i);
			canvas.drawBitmap(bitmap.bmp, i*10, i*10, null);
		}
		//onRedraw(canvas);
		h.unlockCanvasAndPost(canvas);
	}*/
	public TonyuView(Context context, List<CharPattern> p) {
		super(context);
		list=p;
		Log.d("pp", "sz="+list.size());
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public ImageSprite addImageSprite(double x, double y, CharPattern p,
			boolean f, double order, double angle, double alpha, double scaleX,
			double scaleY) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public LineSprite addLineSprite(double sx, double sy, double dx, double dy,
			int color) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public TextSprite addTextSprite(double x, double y, String text, int color,
			double size, double order) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void clearSprites() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void drawSprites() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public int getMouseX() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int getMouseY() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
