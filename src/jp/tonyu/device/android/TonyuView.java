package jp.tonyu.device.android;

import java.util.List;
import java.util.Vector;

import jp.tonyu.kernel.screen.Screen;
import jp.tonyu.kernel.screen.pattern.CharPattern;
import jp.tonyu.kernel.screen.sprite.ImageSprite;
import jp.tonyu.kernel.screen.sprite.LineSprite;
import jp.tonyu.kernel.screen.sprite.TextSprite;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TonyuView extends SurfaceView implements Screen {
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
	private List<SimpleDrawable> slist = new Vector<SimpleDrawable>();
	int bgcolor=Color.argb(255, 20, 80, 180) ;//(20,80,180);
	public synchronized void redraw(List<CharPattern> list) {
		SurfaceHolder h=getHolder();
		if (h==null) return;
		Canvas canvas = h.lockCanvas();
		//Log.d("pp","canvas="+canvas);
		if (canvas==null) return;
		//Log.d("pp","redraw?");
		canvas.drawColor(bgcolor);
		//Paint paint=new Paint();
		//paint.setAlpha(128);
		for (int i=0 ; i<list.size(); i++) {
			BitmapCharPattern bitmap=(BitmapCharPattern) list.get(i);
			//canvas.drawBitmap(bitmap.bmp, i*10, i*10, paint);
			BitmapSprite sp = new BitmapSprite(i*10,i*10, bitmap,false,0,i,255-i*5,
					1+((float)i)*0.1,1+((float)i)*0.1);
			sp.draw(canvas);
		}
		//onRedraw(canvas);
		h.unlockCanvasAndPost(canvas);
	}
	public TonyuView(Context context) {
		super(context);

	}

	@Override
	public ImageSprite addImageSprite(double x, double y, CharPattern p,
			boolean f, double order, double angle, double alpha, double scaleX,
			double scaleY) {
		BitmapSprite res=new BitmapSprite(x,y,p,f,order,angle,alpha,scaleX,scaleY);
		slist.add(res);
		return res;
	}

	@Override
	public LineSprite addLineSprite(double sx, double sy, double dx, double dy,
			int color) {
		AndroidLineSprite res = new AndroidLineSprite(sx,sy,dx,dy,color);
		slist.add(res);
		return res;
	}

	@Override
	public TextSprite addTextSprite(double x, double y, String text, int color,
			double size, double order) {
		AndroidTextSprite res = new AndroidTextSprite(x,y,text,color,size,order);
		slist.add(res);
		return res;
	}

	@Override
	public void clearSprites() {
		slist.clear();
	}

	@Override
	public void drawSprites() {
		SurfaceHolder h=getHolder();
		if (h==null) return;
		Canvas canvas = h.lockCanvas();
		//Log.d("pp","canvas="+canvas);
		if (canvas==null) return;
		//Log.d("pp","redraw?");
		canvas.drawColor(bgcolor);
		for (SimpleDrawable d:slist) {
			d.draw(canvas);
		}
		h.unlockCanvasAndPost(canvas);
	}

	@Override
	public double getMouseX() {
		return mx;
	}

	@Override
	public double getMouseY() {
		return my;
	}
	double mx,my;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//Log.d("pp","mouse"+event);
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
			mx=event.getX();
			my=event.getY();
			break;
		case MotionEvent.ACTION_DOWN:
			mx=event.getX();
			my=event.getY();
			break;
		case MotionEvent.ACTION_UP:
			mx=event.getX();
			my=event.getY();
			break;
		}
		return true;
	}
	@Override
	public int getScreenHeight() {
		return getHeight();
	}
	@Override
	public int getScreenWidth() {
		return getWidth();
	}
}
