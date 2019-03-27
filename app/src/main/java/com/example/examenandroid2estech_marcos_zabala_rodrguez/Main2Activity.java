package com.example.examenandroid2estech_marcos_zabala_rodrguez;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    Button button;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.introducirEnemigos);

        String nombre = getIntent().getStringExtra("NOMBRE");
        String edad = getIntent().getStringExtra("EDAD");
        String descripcion = getIntent().getStringExtra("DESCRIPCION");

        Enemigos enemigos_datos[] = new Enemigos[]{
                new Enemigos(nombre,edad,descripcion)
        };

        EnemigosAdapter adapter = new EnemigosAdapter(this, R.layout.listview_enemies,enemigos_datos);

        listView = findViewById(R.id.listView);

        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row,null);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

}
