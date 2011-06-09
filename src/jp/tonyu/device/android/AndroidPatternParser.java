package jp.tonyu.device.android;


import java.util.Collections;
import java.util.List;
import java.util.Vector;

import jp.tonyu.kernel.screen.pattern.CharPattern;
import jp.tonyu.kernel.screen.pattern.PatterParseError;
import jp.tonyu.kernel.screen.pattern.PatternParser;
import jp.tonyu.util.SPrintf;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Style;
import android.util.Log;

public class AndroidPatternParser implements PatternParser {
	//Bitmap img;
	public AndroidPatternParser(Object r) {
		Bitmap img=(Bitmap)r;

		height = img.getHeight();
		width = img.getWidth();
		buf=Bitmap.createBitmap(width, height, Config.ARGB_8888);
		//copy(Bitmap.Config.ARGB_8888, true); copy does not change configuration: if img is No-alpha channel png, also buf.
		int[] getput=new int[width*height];
		img.getPixels(getput, 0, width, 0, 0, width, height);
		buf.setPixels(getput, 0, width, 0, 0, width, height);
		base=buf.getPixel(0,0);
	}
	String hex(int c) {
		return SPrintf.sprintf("%08x", c);
	}
	final int width,height;
	final Bitmap buf;
	final int base;
	@Override
  	public List<CharPattern> parse() {
  		try {
			Log.d("pp","parse()");
  			Vector<CharPattern> res=new Vector<CharPattern>();
			for (int y=0; y<height ;y++) {
				for (int x=0; x<width ;x++) {
					int c=buf.getPixel(x, y);
					if (c!=base) {
						//Log.d("pp","Col="+hex(c)+" base="+hex(base));
						res.add(parse1Pattern(x,y));
					}
					//System.out.printf("%08x ",c);
				}
				//System.out.println("\n");
			}
			return res;
  		} catch (PatterParseError p) {
			Log.d("pp","parse error! "+p);
  			return Collections.singletonList((CharPattern)new BitmapCharPattern(buf));
  		}
	}
  	private BitmapCharPattern parse1Pattern(int x, int y) throws PatterParseError {
		int trans=buf.getPixel(x, y);
		int dx=x,dy=y;
		while (dx<width) {
			int pixel = buf.getPixel(dx,dy);
			//Log.d("pp","dx="+dx+" dy="+dy+" pixel="+hex(pixel)+" trans="+hex(trans));
			if (pixel!=trans) break;
			dx++;
		}
		if (dx>=width || buf.getPixel(dx,dy)!=base) throw new PatterParseError(this,dx,dy,hex(buf.getPixel(dx,dy))+"!="+hex(base));
		dx--;
		while (dy<height) {
			if (buf.getPixel(dx,dy)!=trans) break;
			dy++;
		}
		if (dy>=height || buf.getPixel(dx,dy)!=base) throw new PatterParseError(this,dx,dy,hex(buf.getPixel(dx,dy))+"!="+hex(base));
		//Log.d("pp", SPrintf.sprintf("x=%d y=%d dx=%d dy=%d",x,y,dx,dy));
		dy--;
		int sx=x+1,sy=y+1,w=dx-sx,h=dy-sy;
		if (w*h==0) throw new PatterParseError(this, dx, dy,"w*h==0");
		Log.d("trans","trans?="+buf.getPixel(sx+2, sy+2));
		for (int ey=sy ; ey<dy ; ey++) {
			for (int ex=sx ; ex<dx ; ex++) {
				if (buf.getPixel(ex, ey)==trans) {
//				if (buf.getPixel(ex, ey)==0 || (ex-sx)+(ey-sy)<20) {
					buf.setPixel(ex, ey, 0);
				}
			}
		}
		Bitmap i=Bitmap.createBitmap(buf, sx, sy, w, h);// createBitmap(w, h, Bitmap.Config.ARGB_8888);
		//Log.d("pp", SPrintf.sprintf("%d %d %d %d %d %d",w,h,sx,sy,dx,dy));
		//i. getGraphics().drawImage(buf, 0, 0, w, h, sx, sy, dx, dy, null);
		Canvas g = new Canvas(buf);
		Paint p=new Paint();
		p.setColor(base);
		p.setStyle(Style.FILL);
		g.drawRect(x, y, x+w+2, y+h+2, p);//(x,y, w+2, h+2);
		return new BitmapCharPattern(i);
	}

}
