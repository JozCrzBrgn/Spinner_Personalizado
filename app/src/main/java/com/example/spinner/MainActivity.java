package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2;
    private Spinner sp1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Relación de valores entre la parte gráfica y la parte lógica
        ed1 = (EditText)findViewById(R.id.txt_num1);
        ed2 = (EditText)findViewById(R.id.txt_num2);
        sp1 = (Spinner)findViewById(R.id.sp_oper);
        tv1 = (TextView)findViewById(R.id.tv_resul);

        // Configuramos lo que mostrara el Spinner
        String [] opciones = {"Sumar","Restar","Multiplicar","Dividir"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item_operadores,opciones);
        sp1.setAdapter(adapter);
    }

    public void Calcular(View view){
        //Nos traemos el texto de la parte gráfica (llegan en formato String)
        String strNum1 = ed1.getText().toString();
        String strNum2 = ed2.getText().toString();

        //Pasamos los valores a enteros para poder hacer operaciones
        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        // Obtenemos la seleccion del usuario en el spinner
        String sp_seleccion = sp1.getSelectedItem().toString();

        //Hacemos los cálculos
        if(sp_seleccion.equals("Sumar")){
            int suma = num1 + num2;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        }
        if(sp_seleccion.equals("Restar")){
            int resta = num1 - num2;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        }
        if(sp_seleccion.equals("Multiplicar")){
            int mult = num1 * num2;
            String resultado = String.valueOf(mult);
            tv1.setText(resultado);
        }
        if(sp_seleccion.equals("Dividir") && num2 != 0){
            int div = num1 / num2;
            String resultado = String.valueOf(div);
            tv1.setText(resultado);
        }
        if(sp_seleccion.equals("Dividir") && num2 == 0){
            Toast.makeText(this,"No se puede dividir entre cero",Toast.LENGTH_LONG).show();
        }
    }
}