package com.example.project1301.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1301.R;

public class ConfigActivity extends AppCompatActivity {
  public EditText et_direccion;
  public Button btn_guardar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_config);

    btn_guardar=findViewById(R.id.btn_guardar);
    et_direccion=findViewById(R.id.et_direccion);

    btn_guardar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (et_direccion.getText().toString().equals("")){
          Toast.makeText(ConfigActivity.this, "Ingresa tu direccion", Toast.LENGTH_SHORT).show();
        } else{
          Intent intent = new Intent(ConfigActivity.this,MainActivity.class);
          intent.putExtra("et_direccion",et_direccion.getText().toString());
          startActivity(intent);
        }
      }
    });
  }
}
