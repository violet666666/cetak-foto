package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements KeranjangBelanjaListener{

    private RecyclerView rvKatalogFoto;
    private KatalogFotoListAdapter adapter;
    private Button btnKeranjangBelanja;
    public class MyApp extends Application {

        public MyApp() {
            if(BuildConfig.DEBUG)
                StrictMode.enableDefaults();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KatalogFotoUtil.init();
        OrderFotoUtil.init();

        rvKatalogFoto = findViewById(R.id.rv_katalog_foto);
        adapter = new KatalogFotoListAdapter(this);

        rvKatalogFoto.setAdapter((adapter));
        rvKatalogFoto.setLayoutManager(new LinearLayoutManager(this));

        btnKeranjangBelanja = findViewById(R.id.btn_keranjang_belanja);
        orderChanged();
        btnKeranjangBelanja.setOnClickListener(view -> {
            Intent intent = new Intent(this, KeranjangBelanjaActivity.class);
            startActivity(intent);
        });

        OrderFotoUtil.addKbListener(this);
    }

    @Override
    public void orderChanged() {
        String kbCountStr = "Keranjang Belanja: " + OrderFotoUtil.getOrderCount();
        btnKeranjangBelanja.setText(kbCountStr);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "App telah di-resume",Toast.LENGTH_SHORT).show();
    }
}