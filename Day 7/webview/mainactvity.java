package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    EditText ed1;
    Button btn1;
    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.ed1);
        btn1=(Button)findViewById(R.id.btn1);
        wv1=(WebView)findViewById(R.id.wv1);
        btn1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.btn1:
                String url = ed1.getText().toString();
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new MywebViewClient());
                wv1.loadUrl(url);

                break;
        }
    }
    private class MywebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            return super.shouldOverrideUrlLoading(view, url);
            view.loadUrl(url);
            return true;
        }
}


}
