package celline.lista08.cadastroatletas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import celline.lista08.cadastroatletas.controller.IOperacao;
import celline.lista08.cadastroatletas.controller.OperacaoJuvenil;
import celline.lista08.cadastroatletas.model.Juvenil;

public class JuvenilFragment extends Fragment {

    private View view;
    private EditText etNomeJuvenil;
    private EditText etNascJuvenil;
    private EditText etBairroJuvenil;
    private EditText etAnosPraticandoJuvenil;
    private Button btnCadastrarJuvenil;
    private TextView tvListaJuvenil;

    public JuvenilFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_juvenil, container, false);
        etNomeJuvenil = view.findViewById(R.id.etNomeJuvenil);
        etNascJuvenil = view.findViewById(R.id.etNascJuvenil);
        etBairroJuvenil = view.findViewById(R.id.etBairroJuvenil);
        etAnosPraticandoJuvenil = view.findViewById(R.id.etAnosPraticandoJuvenil);
        btnCadastrarJuvenil = view.findViewById(R.id.btnCadastrarJuvenil);
        tvListaJuvenil = view.findViewById(R.id.tvListaJuvenil);
        tvListaJuvenil.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCadastrarJuvenil.setOnClickListener(op -> cadastro());
        return view;
    }

    private void cadastro() {
        Juvenil juvenil = new Juvenil();

        juvenil.setNome(etNomeJuvenil.getText().toString());
        juvenil.setData(etNascJuvenil.getText().toString());
        juvenil.setBairro(etBairroJuvenil.getText().toString());
        juvenil.setAnosPraticando(Integer.parseInt(etAnosPraticandoJuvenil.getText().toString()));

        IOperacao<Juvenil> op = new OperacaoJuvenil();
        op.cadastrar(juvenil);
        List<Juvenil> lista = op.listar();

        StringBuffer buffer = new StringBuffer();
        for (Juvenil j : lista) {
            buffer.append(j.toString() + "\n");
        }

        tvListaJuvenil.setText(buffer.toString());
        limpaCampos();
    }

    private void limpaCampos() {
        etNomeJuvenil.setText("");
        etNascJuvenil.setText("");
        etBairroJuvenil.setText("");
        etAnosPraticandoJuvenil.setText("");
    }
}