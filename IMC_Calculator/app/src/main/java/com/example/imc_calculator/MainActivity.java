package com.example.imc_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultadoIMC = findViewById(R.id.imc);
        TextView peso = findViewById(R.id.peso);
        TextView altura = findViewById(R.id.altura);
        TextView seuIMC = findViewById(R.id.yourIMC);

        Button meuBotao = findViewById(R.id.calcular);
        meuBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result = imcCalc(Double.parseDouble(peso.getText().toString()), Double.parseDouble(altura.getText().toString()));
                if (resultadoIMC.getVisibility() == View.VISIBLE) {
                    resultadoIMC.setText(Double.valueOf(result).toString());
                } else {
                    seuIMC.setVisibility(View.VISIBLE);
                    resultadoIMC.setVisibility(View.VISIBLE);
                    resultadoIMC.setText((Double.valueOf(result).toString()));
                }
            }
        });
    }



    public Double imcCalc(Double weight, Double height){
        return (weight/(height * height));
    }
}