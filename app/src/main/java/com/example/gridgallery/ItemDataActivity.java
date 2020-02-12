package com.example.gridgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ItemDataActivity extends AppCompatActivity {

    TextView nasaName;
    ImageView nasaImage;
    TextView nasaCopyright;
    TextView nasaExplanation;
    TextView nasaMedia;
    TextView nasaUrl;
    TextView nasaDate;
    TextView nasaHdurl;
    TextView nasaVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_data);

        nasaImage=findViewById(R.id.image);

        nasaName=findViewById(R.id.name);
        nasaCopyright=findViewById(R.id.cr);
        nasaExplanation=findViewById(R.id.exp);
        nasaDate=findViewById(R.id.date);
        nasaUrl=findViewById(R.id.url);
        nasaHdurl=findViewById(R.id.hdurl);
        nasaMedia=findViewById(R.id.media);
        nasaVersion=findViewById(R.id.version);


        Intent intent = getIntent();
        String name= intent.getStringExtra("name");
        String image=intent.getStringExtra("image");
        String cr=intent.getStringExtra("cr");
        String exp=intent.getStringExtra("exp");
        String date=intent.getStringExtra("date");
        String url=intent.getStringExtra("url");
        String hdurl=intent.getStringExtra("hdurl");
        String media=intent.getStringExtra("media");
        String version=intent.getStringExtra("version");




        nasaName.setText("Title: "+name);
        nasaCopyright.setText("Copyright: "+cr);
        nasaExplanation.setText("Explanation: "+exp);
        nasaDate.setText("Date: "+date);
        nasaUrl.setText("URL: "+url);
        nasaHdurl.setText("HDURL: "+hdurl);
        nasaMedia.setText("Media Type: "+media);
        nasaVersion.setText("Service Version: "+version);




        Glide.with(this)
                .load(image)
                .into(nasaImage);




    }
}
