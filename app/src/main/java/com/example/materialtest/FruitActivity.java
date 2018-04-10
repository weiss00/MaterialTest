package com.example.materialtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {


    public static final String FRUIT_NAME = "fruit_name" ;
    public static final String FRUIT_IMAGE_ID = "fruit_image_id" ;

    private Toolbar toolBar;

    private CollapsingToolbarLayout collapsingToolbar;

    private ImageView fruitImageView;

    private TextView fruitContentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        Intent intent = getIntent();
        String fruitName = intent.getStringExtra(FRUIT_NAME);  //用Intent获取传入的水果名字和水果图片的id
        int fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID,0);
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        fruitImageView = (ImageView) findViewById(R.id.fruit_image_parent);
        fruitContentText = (TextView) findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {  //设置一个返回箭头 (默认)
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(fruitName);  //将水果名字设置成为标题
        Glide.with(this).load(fruitImageId).into(fruitImageView);//Gild.with()方法传入一个this参数，
        // 调用load()方法加载图片，最后调用into()方法将图片设置具体某一个ImageView。
        String fruitContent = generateFruitContent(fruitName);
        fruitContentText.setText(fruitContent);
    }

    private String generateFruitContent(String fruitName) {   // 文本信息为水果名字循环拼写500次
        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            fruitContent.append(fruitName);
        }
        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

