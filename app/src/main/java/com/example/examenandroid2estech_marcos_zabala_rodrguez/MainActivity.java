package com.example.examenandroid2estech_marcos_zabala_rodrguez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonLista;
    Button buttonEnemigos;

    EditText editTextNombre;
    EditText editTextEdad;
    EditText editTextDescricion;

    boolean nombreB=false;
    boolean edadEmpty=false;
    boolean edadNum=false;
    boolean edadCorrecta=false;
    boolean edadTotal=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextDescricion = findViewById(R.id.editTextDescripcion);

        buttonLista = findViewById(R.id.verEnemigos);
        buttonEnemigos = findViewById(R.id.buttonValidar);

        buttonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        buttonEnemigos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String nombre = editTextNombre.getText().toString();
                String edad = editTextEdad.getText().toString();

                if(TextUtils.isEmpty(nombre)){
                    editTextNombre.setError(getString(R.string.error_campo_obligatorio));
                    editTextNombre.requestFocus();
                    return;
                }else{
                    nombreB=true;
                }

                if(TextUtils.isEmpty(edad)){
                    editTextEdad.setError(getString(R.string.error_campo_obligatorio));
                    editTextEdad.requestFocus();
                    return;
                }else{
                    edadEmpty=true;
                }

                if(TextUtils.isDigitsOnly(edad)){
                    edadNum=true;
                }else{
                    editTextEdad.setError(getString(R.string.error_campo_numerico));
                    editTextEdad.requestFocus();
                    return;
                }

                int edadInt = Integer.parseInt(edad);

                if(edadInt<0 || edadInt>150){
                    editTextEdad.setError(getString(R.string.error_edad_incorrecta));
                    editTextEdad.requestFocus();
                    return;
                }else{
                    edadCorrecta=true;
                }
                if(edadCorrecta && edadNum && edadEmpty){
                    edadTotal= true;
                }

                if(edadTotal && nombreB){
                    Toast.makeText(getApplicationContext(), "Se ha añadido correctamente.", Toast.LENGTH_SHORT).show();
                    String nombreEnemigo = editTextNombre.getText().toString();
                    String edadEnemigo = editTextEdad.getText().toString();
                    String descripcionEnemigo = editTextDescricion.getText().toString();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("NOMBRE",nombreEnemigo);
                    intent.putExtra("EDAD",edadEnemigo);
                    intent.putExtra("DESCRIPCION",descripcionEnemigo);
                    startActivity(intent);
                    editTextDescricion.setText("");
                    editTextEdad.setText("");
                    editTextNombre.setText("");
                }
            }
        });
    }

}
