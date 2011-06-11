package jp.tonyu.device.android;

import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import jp.tonyu.android.ribbon.R;
import jp.tonyu.kernel.device.ResourceList;

public class AndroidResouceList implements ResourceList {
	public void add(String name, Bitmap val) {
		m.put(name, val);
	}
	Map<String,Bitmap> m=new HashMap<String, Bitmap>();
	@Override
	public Object getImageResource(String name) {
		return m.get(name);
	}
}
