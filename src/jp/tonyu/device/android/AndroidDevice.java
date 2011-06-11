package jp.tonyu.device.android;

import java.io.IOException;

import android.content.Context;

import jp.tonyu.kernel.device.Device;
import jp.tonyu.kernel.resource.Resource;
import jp.tonyu.kernel.screen.Screen;
import jp.tonyu.kernel.screen.pattern.PatternParser;
import jp.tonyu.kernel.screen.pattern.PatternParserFactory;

public class AndroidDevice implements Device {
	public AndroidDevice(Context c) {
		v=new TonyuView(c);
	}
	final TonyuView v;
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

}
