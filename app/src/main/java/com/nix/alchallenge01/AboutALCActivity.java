package com.nix.alchallenge01;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class AboutALCActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("About ALC");

        webView = findViewById(R.id.webView);
        webView.loadUrl("https://andela.com/alc/");

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
