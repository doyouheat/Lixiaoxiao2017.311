package news.bwie.com.lixiaoxiao2017311.application;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 1. 类的用途
 * 2. @author : do  you  heat
 * 3. @date 2017/3/11 10:19
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration aDefault = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(aDefault);
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this);
    }
}
