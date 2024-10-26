package celline.lista08.ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import celline.lista08.ingressos.model.Ingresso;
import celline.lista08.ingressos.model.VIP;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbComum;
    private RadioButton rbVIP;
    private Button btnComprar;


    /*
     *@author:<Celline>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbComum = findViewById(R.id.rbComum);
        rbComum.setChecked(true);
        rbVIP = findViewById(R.id.rbVIP);
        btnComprar = findViewById(R.id.btnComprar);

        btnComprar.setOnClickListener(op -> comprar());
    }

    private void comprar() {

        Random random = new Random();
        float valorFinal = 0;
        Ingresso ingresso = null;
        String tipo = " ";

        if (rbComum.isChecked()){
            ingresso = new Ingresso();
            tipo = "Comum";

        } else if (rbVIP.isChecked()) {
            ingresso = new VIP();
            tipo = "VIP";
        }

        ingresso.setId(String.valueOf(1000+random.nextInt(9000)));
        String id = ingresso.getId();
        ingresso.setValor(25);
        valorFinal = ingresso.valorFinal(10);

        Bundle bundle = new Bundle();
        bundle.putFloat("valorFinal", valorFinal);
        bundle.putString("tipo", tipo);
        bundle.putString("id", id);

        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent i = new Intent(this, ActivityDadosCompra.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}