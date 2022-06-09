package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Model.persona;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {


    Button btnguardar;
    EditText nombre, apellido, correo, edad;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.IdNombre);
        apellido = findViewById(R.id.IdApellido);
        correo = findViewById(R.id.IdCorreo);
        edad = findViewById(R.id.IdEdad);
        btnguardar = (Button) findViewById(R.id.IdRegistrar);



        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DatabaseReference data=firebaseDatabase.getInstance().getReference();

                String nom = nombre.getText().toString();
                String ape = apellido.getText().toString();
                String corr = correo.getText().toString();
                String ed = edad.getText().toString();

                Map<String, Object> user = new HashMap<>();
                user.put("ID", UUID.randomUUID().toString());
                user.put("Nombre", nom);
                user.put("Apellido", ape);
                user.put("Correo", corr);
                user.put("Edad", ed);

                db.collection("users").add(user);
               /** persona p = new persona();
                p.setUid(UUID.randomUUID().toString());
                p.setNombre(nom);
                p.setApellodo(ape);
                p.setCorreo(corr);
                p.setEdad(ed);
                //data.child("persona").child(p.getUid()).setValue(p);
                db.collection("cris").add(p);**/

            }
        });

    }



}