package news.bwie.com.lixiaoxiao2017311.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import news.bwie.com.lixiaoxiao2017311.R;
import news.bwie.com.lixiaoxiao2017311.bean.News;

/**
 * 1. 类的用途
 * 2. @author : do  you  heat
 * 3. @date 2017/3/11 10:12
 */
public class MyBaseAdapter extends BaseAdapter {
    Context  context;
    List<News.ResultBean.DataBean> list;
    public MyBaseAdapter(Context context, List<News.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return  list.size();
    }
    @Override
    public Object getItem(int position) {
        return   list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder  v;
        if(convertView==null){
            v=new ViewHolder();
            convertView=View.inflate(context, R.layout.iteamlayout,null);
            v.iv= (ImageView) convertView.findViewById(R.id.iv);
            v.name= (TextView) convertView.findViewById(R.id.name);
            v.res= (TextView) convertView.findViewById(R.id.res);
            convertView.setTag(v);
        }else {
            v= (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s03(),v.iv);
        v.name.setText(list.get(position).getAuthor_name());
        v.res.setText(list.get(position).getTitle());
        return convertView;
    }

    class   ViewHolder{
        ImageView  iv;
        TextView  name,res;
    }
}
