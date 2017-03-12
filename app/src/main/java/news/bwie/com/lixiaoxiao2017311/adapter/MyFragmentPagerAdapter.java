package news.bwie.com.lixiaoxiao2017311.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import news.bwie.com.lixiaoxiao2017311.fragment.FragmentNews;
import news.bwie.com.lixiaoxiao2017311.utils.HttpUrl;

/**
 * 1. 类的用途
 * 2. @author : do  you  heat
 * 3. @date 2017/3/11 09:03
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private  ArrayList<Fragment>   fmlist;
    private  String[]  name;


    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fmlist, String[] name) {
        super(fm);
        this.fmlist = fmlist;
        this.name = name;
    }
    @Override
    public Fragment getItem(int position) {

        if (position==1){
            FragmentNews fragmentNews = FragmentNews.newInstance(HttpUrl.url[position], null);
            return   fragmentNews;
        }else {
            int  i=position-1;
            FragmentNews fragmentNews = FragmentNews.newInstance(HttpUrl.url[i > 0 ? i : 0], null);
            return fragmentNews;
        }
    }

    @Override
    public int getCount() {
        return  fmlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  name[position];
    }
}
