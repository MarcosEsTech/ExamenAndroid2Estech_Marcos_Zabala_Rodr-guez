package com.example.examenandroid2estech_marcos_zabala_rodrguez;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;

public class EnemigosAdapter extends ArrayAdapter<Enemigos> {
    Context myContext;
    int myLayoutResourceID;
    Enemigos mydata[]=null;

    public EnemigosAdapter(Context context, int layoutResourceID, Enemigos[] data){
        super(context,layoutResourceID,data);

        this.myContext=context;
        this.mydata=data;
        this.myLayoutResourceID=layoutResourceID;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View row=convertView;
        EnemigosHolder holder = null;

        if(row==null){
            LayoutInflater inflater = ((Activity)myContext).getLayoutInflater();

            row = inflater.inflate(myLayoutResourceID,parent,false);

            holder = new EnemigosHolder();

            holder.textViewNombre=(TextView)row.findViewById(R.id.nombreEnem);
            holder.textViewEdad=(TextView)row.findViewById(R.id.edadEnem);
            holder.textViewDescripcion=(TextView)row.findViewById(R.id.descripcionEnem);

            row.setTag(holder);

        }else{
            holder = (EnemigosHolder)row.getTag();
        }

        Enemigos enemigos = mydata[position];
        holder.textViewNombre.setText(enemigos.nombre);
        holder.textViewEdad.setText(enemigos.edad);
        holder.textViewDescripcion.setText(enemigos.descricion);

        return row;
    }

    static class EnemigosHolder{
        TextView textViewNombre;
        TextView textViewEdad;
        TextView textViewDescripcion;
    }
}
