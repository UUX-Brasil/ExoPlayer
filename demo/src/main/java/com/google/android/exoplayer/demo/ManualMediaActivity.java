package com.google.android.exoplayer.demo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.exoplayer.util.Util;

import java.util.EventListenerProxy;

public class ManualMediaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playButton;
    private EditText mediaUrl;
    private EditText issuerUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual_media);

        playButton = (Button)findViewById(R.id.play_button);
        mediaUrl = (EditText)findViewById(R.id.media_url);
        issuerUrl = (EditText)findViewById(R.id.issuer_url);

        issuerUrl.setText("http://teste-1.ottvs.com.br/androidsky/API/SkyFreeMe");
        mediaUrl.setText("http://vodsdash.skyott.com.br/S000003006/manifest_03.mpd");

        playButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent mpdIntent = new Intent(this, PlayerActivity.class)
                .setData(Uri.parse(mediaUrl.getText().toString()))
                .putExtra(PlayerActivity.CONTENT_ID_EXTRA, "")
                .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, Util.TYPE_DASH)
                .putExtra(PlayerActivity.PROVIDER_EXTRA, "widevine_test")
                .putExtra("issuer_url", issuerUrl.getText().toString());
        startActivity(mpdIntent);

    }
}
