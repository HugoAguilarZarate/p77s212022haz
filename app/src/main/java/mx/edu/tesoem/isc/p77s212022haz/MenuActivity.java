package mx.edu.tesoem.isc.p77s212022haz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MenuActivity extends AppCompatActivity {

    Button btnnat, btnobj;
    EditText txtedad, txtnombre;
    TextView lerror;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnnat = findViewById(R.id.btnnat);
        btnobj = findViewById(R.id.btnobj);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);

        lerror = findViewById(R.id.lerror);



        btnnat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(txtnombre.getText().toString().isEmpty() || txtedad.getText().toString().isEmpty()) {
                        lerror.setText("No se ha colocado un nombre o edad");
                    }else {
                        int edad = Integer.parseInt(txtedad.getText().toString());
                        String nombre = txtnombre.getText().toString();
                        Intent nat = new Intent(MenuActivity.this,NativoActivity.class);
                        nat.putExtra("nombre",nombre);
                        nat.putExtra("edad",edad);
                        startActivity(nat);
                        lerror.setText("");

                    }


            }
        });

        btnobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if(txtnombre.getText().toString().isEmpty()|| txtedad.getText().toString().isEmpty()){
                        lerror.setText("No se ha colocado un nombre o edad");
                    }else {
                        int edad = Integer.parseInt(txtedad.getText().toString());
                        String nombre = txtnombre.getText().toString();
                        Datos datost = new Datos(nombre,edad);
                        Datos datos = new Datos();
                        datos.setNombre(nombre);
                        datos.setEdad(edad);
                        Intent obj = new Intent(MenuActivity.this,ObjetoActivity.class);
                        obj.putExtra("datosp",datos);
                        startActivity(obj);
                        lerror.setText("");
                    }
                }


        });

    }
}