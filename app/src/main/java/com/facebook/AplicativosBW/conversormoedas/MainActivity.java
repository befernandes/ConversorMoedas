package com.facebook.AplicativosBW.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_Dolar);
        this.mViewHolder.textEuro =  findViewById(R.id.text_Euro);
        this.mViewHolder.textKwanza =findViewById(R.id.text_Kwanza);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_Calculate);


        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.clearValues();

    }

    @Override
    public void onClick(View view) {
        //Verifica em qual ID esta sendo implementado o OnClick
        if (view.getId()== R.id.button_Calculate){
            //Criado uma variavel para verificar o valor do EditText
            String value = this.mViewHolder.editValue.getText().toString();

            //Verifica se o valor esta vazio
            if ("".equals(value)){
                Toast.makeText(this, R.string.Informe_valor,Toast.LENGTH_LONG).show();
            }
            if (".".equals(value)){
                Toast.makeText(this, R.string.Informe_valor,Toast.LENGTH_LONG).show();
            }
            else {
                //Converter o valor do EditText em Double
                Double real = Double.valueOf(value);

                //"%.2" passa duas casas decimais
                this.mViewHolder.textDolar.setText(toString().format("%.2f", (real / 5.49)));
                this.mViewHolder.textEuro.setText(toString().format("%.2f", (real / 6.56)));
                this.mViewHolder.textKwanza.setText(toString().format("%.2f", (real / 0.009127)));


            }
        }

    }



    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textKwanza.setText("");
    }
    private  static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        TextView textKwanza;
        Button buttonCalculate;
    }
}