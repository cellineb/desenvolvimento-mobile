package celline.lista07.contabancaria;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbContaPoupanca;
    private RadioButton rbContaEspecial;
    private EditText etSaldo;
    private EditText etTaxa;
    private EditText etSacar;
    private EditText etDepositar;
    private TextView tvSaida;
    private Button btnSacar;
    private Button btnDepositar;
    private Button btnRendimento;
    private Button btnMostraDados;
    private EditText etLimite;
    private EditText etNomeCliente;
    private EditText etNumConta;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbContaPoupanca = findViewById(R.id.rbContaPoupanca);
        rbContaPoupanca.setChecked(true);
        rbContaEspecial = findViewById(R.id.rbContaEspecial);
        etSaldo = findViewById(R.id.etSaldo);
        etTaxa = findViewById(R.id.etTaxa);
        etSacar = findViewById(R.id.etSacar);
        etDepositar = findViewById(R.id.etDepositar);
        tvSaida = findViewById(R.id.tvSaida);
        btnSacar = findViewById(R.id.btnSacar);
        btnDepositar = findViewById(R.id.btnDepositar);
        btnRendimento = findViewById(R.id.btnRendimento);
        btnMostraDados = findViewById(R.id.btnMostraDados);
        etLimite = findViewById(R.id.etLimite);
        etNomeCliente = findViewById(R.id.etNomeCliente);
        etNumConta = findViewById(R.id.etNumConta);

        ContaBancaria contaBancaria = new ContaBancaria();

        if (rbContaPoupanca.isChecked()){
            ContaPoupanca poupanca = new ContaPoupanca();
            poupanca.setCliente((etNomeCliente.getText()).toString());
            poupanca.setNumConta(Integer.parseInt((etNumConta.getText()).toString()));
            poupanca.setSaldo(Float.parseFloat((etSaldo.getText()).toString()));

            btnSacar.setOnClickListener(op -> {
                float sacar = poupanca.sacar(Float.parseFloat((etSacar.getText()).toString()));
                tvSaida.setText(String.valueOf(sacar));
            });
            btnDepositar.setOnClickListener(op -> {
                float depositar = poupanca.depositar(Float.parseFloat((etDepositar.getText()).toString()));
                tvSaida.setText(String.valueOf(depositar));
            });
            btnRendimento.setOnClickListener(op -> {
                float rendimento = poupanca.calcularNovoSaldo(Float.parseFloat((etTaxa.getText()).toString()));
                tvSaida.setText(String.valueOf(rendimento));
            });
            btnMostraDados.setOnClickListener(op -> {
                tvSaida.setText("Nome: " + poupanca.getCliente() + "\n Num Conta: " + poupanca.getNumConta() + "\n Saldo: " + poupanca.getSaldo());
            });
        }

        else if (rbContaEspecial.isChecked()) {
            ContaEspecial especial = new ContaEspecial();
            especial.setCliente((etNomeCliente.getText()).toString());
            especial.setNumConta(Integer.parseInt((etNumConta.getText()).toString()));
            especial.setSaldo(Float.parseFloat(etSaldo.toString()));

            btnSacar.setOnClickListener(op -> {
                float sacar = especial.sacar(Float.parseFloat((etSacar.getText()).toString()));
                tvSaida.setText(String.valueOf(sacar));
            });
            btnDepositar.setOnClickListener(op -> {
                float depositar = especial.depositar(Float.parseFloat((etDepositar.getText()).toString()));
                tvSaida.setText(String.valueOf(depositar));
            });
            btnMostraDados.setOnClickListener(op -> {tvSaida.setText("Nome: " + especial.getCliente() + "\n Num Conta: " + especial.getNumConta() + "\n Saldo: " + especial.getSaldo());});
            btnRendimento.setOnClickListener(op -> {tvSaida.setText("A conta especial não tem essa opção");});
        }


    }

}