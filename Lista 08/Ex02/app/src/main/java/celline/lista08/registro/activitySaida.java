package celline.lista08.registro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import celline.lista08.registro.model.Pessoa;

/*
 *@author:<Celline>
 */
public class activitySaida extends AppCompatActivity {

    private TextView tvSaida;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvSaida = findViewById(R.id.tvSaida);
        btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nome = bundle.getString("nome");
        Long cpf = bundle.getLong("cpf");
        String regiao = bundle.getString("regiao");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);

        tvSaida.setText("CPF: " + cpf + "\n Nome: " + nome + "\n " + regiao);
        btnVoltar.setOnClickListener(op -> voltar());
    }

    /*
     *@author:<Celline>
     */
    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}