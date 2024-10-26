package celline.lista08.ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import celline.lista08.ingressos.model.Ingresso;
import celline.lista08.ingressos.model.VIP;


public class ActivityDadosCompra extends AppCompatActivity {

    private TextView tvSaida;
    private Button btnVoltar;


    /*
     *@author:<Celline>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dados_compra);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvSaida = findViewById(R.id.tvSaida);
        btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String tipo = bundle.getString("tipo");
        float valorFinal = bundle.getFloat("valorFinal");
        Ingresso ingresso = null;

        if (tipo.equals("Comum")) {
            ingresso = new Ingresso();
        } else if (tipo.equals("VIP")) {
            ingresso = new VIP();
        }

        ingresso.setId(bundle.getString("id"));

        tvSaida.setText("ID do Ingresso: " + ingresso.getId() +"\n Tipo do Ingresso: " + tipo + "\n Valor total da compra: " + valorFinal);
        btnVoltar.setOnClickListener(op -> voltar());

    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}