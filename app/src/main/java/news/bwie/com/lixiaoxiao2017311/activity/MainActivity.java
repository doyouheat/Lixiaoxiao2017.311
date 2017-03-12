package news.bwie.com.lixiaoxiao2017311.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import news.bwie.com.lixiaoxiao2017311.R;
import news.bwie.com.lixiaoxiao2017311.adapter.MyFragmentPagerAdapter;
import news.bwie.com.lixiaoxiao2017311.fragment.FragmentNews;

public class MainActivity extends FragmentActivity {


    private ArrayList<Fragment>   fmlist=new ArrayList<>();
    private  String[]  name=new String[]{"头条","社会","国内","国际","娱乐","体育","军事","科技","财经","时尚",};
    private TabLayout tab;
    private ViewPager vp;
    private MyFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          getViews();
          addFragment();

        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fmlist,name);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }
    private void addFragment() {
        for (int i = 0; i <name.length; i++) {
            fmlist.add(new FragmentNews());
        }
    }
    private void getViews() {
        tab = (TabLayout) findViewById(R.id.tablayout);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "豆豆是傻逼，没有小鸡鸡", Toast.LENGTH_SHORT).show();
            }
        });
        vp = (ViewPager) findViewById(R.id.vp);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
       }

}
