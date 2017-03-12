package news.bwie.com.lixiaoxiao2017311.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import news.bwie.com.lixiaoxiao2017311.R;

public class DetailActivity extends AppCompatActivity {

    private WebView webview;
    private ProgressBar bar;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        webview=(WebView) findViewById(R.id.webview);

        bar=(ProgressBar) findViewById(R.id.bar);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        tv=(TextView) findViewById(R.id.tv);
        webview.getSettings().setDefaultTextEncodingName("gbk");
        webview.loadUrl(url);
        //设置安卓可以调用js的方法
      /*  webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("javascript:want()");
        //设置js调用安卓的方法
        webview.addJavascriptInterface(this,"test");

        webview.setWebViewClient(new  WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO Auto-generated method stub
                super.onPageFinished(view, url);
                bar.setVisibility(View.GONE);
            }
        });
        webview.setWebChromeClient(new  WebChromeClient(){

            @Override
            public void onReceivedTitle(WebView view, String title) {
                // TODO Auto-generated method stub
                super.onReceivedTitle(view, title);
                tv.setText(title);
            }
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                super.onProgressChanged(view, newProgress);
                bar.setProgress(newProgress);
            }

        });*/
    }
}
