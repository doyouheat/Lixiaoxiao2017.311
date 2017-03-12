package news.bwie.com.lixiaoxiao2017311.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import news.bwie.com.lixiaoxiao2017311.R;
import news.bwie.com.lixiaoxiao2017311.activity.DetailActivity;
import news.bwie.com.lixiaoxiao2017311.adapter.MyBaseAdapter;
import news.bwie.com.lixiaoxiao2017311.bean.News;

public class FragmentNews extends Fragment implements PullToRefreshListView.OnRefreshListener2<ListView>{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private View view;
    private PullToRefreshListView pull;
    private List<News.ResultBean.DataBean> list;

    public FragmentNews() {
        // Required empty public constructor
    }

    public static FragmentNews newInstance(String param1, String param2) {
        FragmentNews fragment = new FragmentNews();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentlayout,null,false);
        Toast.makeText(getActivity(), ""+mParam1, Toast.LENGTH_SHORT).show();
       getViews();
       new  MyTask().execute(mParam1);
        return view;
    }

    private void getViews() {

        pull = (PullToRefreshListView) view.findViewById(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setOnRefreshListener(this);


    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

    }


    class  MyTask  extends AsyncTask<String,String,String> {

        private List<News.ResultBean.DataBean> list;

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... params) {

            try {
                URL  url=new URL(params[0]);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                if (connection.getResponseCode()==200){
                    InputStream is = connection.getInputStream();

                    ByteArrayOutputStream  os=new ByteArrayOutputStream();
                    byte[]  buffer=new  byte[1024];
                    int  len;
                    while ((len=is.read(buffer))!=-1){
                        os.write(buffer,0,len);
                    }
                    is.close();
                    os.close();
                    return  os.toString();
                }
            } catch (Exception e) {

            }
            return null;
        }
        @Override
        protected void onProgressUpdate(String... values) {

            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            News news = new Gson().fromJson(s, News.class);
            list = news.getResult().getData();
            pull.setAdapter(new MyBaseAdapter(getActivity(), list));
            pull.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=     new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("url", list.get(position - 1).getUrl());
                    startActivity(intent);
                }
            });
        }
    }


}
