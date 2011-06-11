package jp.tonyu.device.android;

import java.io.IOException;

import jp.tonyu.kernel.device.Device;
import jp.tonyu.kernel.device.ResourceList;
import jp.tonyu.kernel.screen.Screen;
import jp.tonyu.kernel.screen.pattern.PatternParser;
import jp.tonyu.kernel.screen.pattern.PatternParserFactory;
import android.content.Context;

public class AndroidDevice implements Device {
	public AndroidDevice(Context c) {
		v=new TonyuView(c);
	}
	final TonyuView v;
	final AndroidResouceList res=new AndroidResouceList();
	@Override
	public PatternParserFactory getPatternParserFactory() {

		return new PatternParserFactory() {
			@Override
			public PatternParser newPatternParser(Object r)
					throws IOException {
				return new BitmapPatternParser(r);
			}
		};
	}

	@Override
	public Screen getScreen() {
		return v;
	}

	@Override
	public AndroidResouceList getResourceList() {
		return res;
	}

}
