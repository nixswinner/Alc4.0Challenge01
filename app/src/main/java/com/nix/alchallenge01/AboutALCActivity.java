package com.nix.alchallenge01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AboutALCActivity extends AppCompatActivity {
    private WebView webView;
    private WebViewClient webClient;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("About ALC");

        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);
        webView.getSettings().setJavaScriptEnabled(true);
        webClient=new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                Log.e("Webview", "onPageStarted: "+url );
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                Log.e("WebView", "onPageFinished: "+url );
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(AboutALCActivity.this,"Error occured "+error.toString()+
                        " loading about ALC Kindly try again.",Toast.LENGTH_SHORT).show();
                Log.e("AboutALC error", "onReceivedError: "+error.toString() );
                finish();
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                Log.e("Webview", "onReceivedSslError: "+error.toString() );
                handler.proceed();
            }
        };
        webView.setWebViewClient(webClient);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("https://andela.com/alc/");


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
