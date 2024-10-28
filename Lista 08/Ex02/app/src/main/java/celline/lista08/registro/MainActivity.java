package celline.lista08.registro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import celline.lista08.registro.model.Pessoa;

/*
 *@author:<Celline>
 */
public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etCpf;
    private Button btnVerificar;

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

        etNome = findViewById(R.id.etNome);
        etCpf = findViewById(R.id.etCpf);
        btnVerificar = findViewById(R.id.btnVerificar);

        btnVerificar.setOnClickListener(op -> verifica());

    }

    /*
     *@author:<Celline>
     */
    private void verifica() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(String.valueOf(etNome.getText()));
        pessoa.setCpf(Long.parseLong(String.valueOf(etCpf.getText())));

        String nome = pessoa.getNome();
        long cpf = pessoa.getCpf();
        int n = (int) ((cpf / 100)% 10);

        String regiao = procuraRegiao(n);

        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putLong("cpf", cpf);
        bundle.putString("regiao", regiao);

        troca(bundle);
    }

    /*
     *@author:<Celline>
     */
    private void troca(Bundle bundle) {
        Intent i = new Intent(this, activitySaida.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }

    /*
     *@author:<Celline>
     */
    private String procuraRegiao(long n) {
        if (n == 0) {
            return "Seu CPF foi emitido em: \n\nRio Grande do Sul";
        } else if (n == 1) {
            return "Seu CPF foi emitido em: \n\nDistrito Federal ou \nGoiás ou\nMato Grosso ou \nMato Grosso do Sul ou \nTocantins";
        } else if (n == 2) {
            return "Seu CPF foi emitido em: \n\nPará ou \nAmazonas ou \nAcre ou \nAmapá ou \nRondônia ou \nRoraima";
        } else if (n == 3) {
            return "Seu CPF foi emitido em: \n\nCeará ou \nMaranhão ou \nPiauí";
        } else if (n == 4) {
            return "Seu CPF foi emitido em: \n\nPernambuco ou \nRio Grande do Norte ou \nParaíba ou \nAlagoas";
        } else if (n == 5) {
            return "Seu CPF foi emitido em: \n\nBahia ou \nSergipe";
        } else if (n == 6) {
            return "Seu CPF foi emitido em: \n\nMinas Gerais";
        } else if (n == 7) {
            return "Seu CPF foi emitido em: \n\nRio de Janeiro ou \nEspírito Santo";
        } else if (n == 8) {
            return "Seu CPF foi emitido em: \n\nSão Paulo";
        } else if (n == 9) {
            return "Seu CPF foi emitido em: \n\nParaná ou \nSanta Catarina";
        }
        return " ";
    }
}