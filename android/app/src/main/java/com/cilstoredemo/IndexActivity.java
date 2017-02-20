package com.cilstoredemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Button jxBtn = (Button) findViewById(R.id.jxBtn);
        jxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, CILReactActivity.class);
                intent.putExtra(CILReactActivity.BundleName, "index.android");
                intent.putExtra(CILReactActivity.MainComponentName, "CILStoreDemo");
                startActivity(intent);
            }
        });

        Button sxBtn = (Button) findViewById(R.id.sxBtn);
        sxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, CILReactActivity.class);
                intent.putExtra(CILReactActivity.BundleName, "index.android2");
                intent.putExtra(CILReactActivity.MainComponentName, "CILStoreDemo2");
                startActivity(intent);
            }
        });
    }
}
