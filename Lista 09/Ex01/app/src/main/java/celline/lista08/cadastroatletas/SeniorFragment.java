package celline.lista08.cadastroatletas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import celline.lista08.cadastroatletas.controller.IOperacao;
import celline.lista08.cadastroatletas.controller.OperacaoSenior;
import celline.lista08.cadastroatletas.model.Senior;

public class SeniorFragment extends Fragment {

    private View view;
    private EditText etNomeSenior;
    private EditText etNascSenior;
    private EditText etBairroSenior;
    private RadioButton rbSimSenior;
    private RadioButton rbNaoSenior;
    private Button btnCadastrarSenior;
    private TextView tvListaSenior;

    public SeniorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_senior, container, false);

        etNomeSenior = view.findViewById(R.id.etNomeSenior);
        etNascSenior = view.findViewById(R.id.etNascSenior);
        etBairroSenior = view.findViewById(R.id.etBairroSenior);
        rbSimSenior = view.findViewById(R.id.rbSimSenior);
        rbSimSenior.setChecked(true);
        rbNaoSenior = view.findViewById(R.id.rbNaoSenior);
        btnCadastrarSenior = view.findViewById(R.id.btnCadastrarSenior);
        tvListaSenior = view.findViewById(R.id.tvListaSenior);
        tvListaSenior.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCadastrarSenior.setOnClickListener(op -> cadastro());

        return view;
    }

    private void cadastro() {

        Senior senior = new Senior();

        senior.setNome(etNomeSenior.getText().toString());
        senior.setData(etNascSenior.getText().toString());
        senior.setBairro(etBairroSenior.getText().toString());

        if (rbSimSenior.isChecked()){
            senior.setProblemasCard(true);
        }
        else if (rbNaoSenior.isChecked()){
            senior.setProblemasCard(false);
        }

        IOperacao<Senior> op = new OperacaoSenior();
        op.cadastrar(senior);
        List<Senior> lista = op.listar();

        StringBuffer buffer = new StringBuffer();
        for (Senior s : lista) {
            buffer.append(s.toString() + "\n");
        }

        tvListaSenior.setText(buffer.toString());
        limpaCampos();

    }

    private void limpaCampos() {
        etNomeSenior.setText("");
        etNascSenior.setText("");
        etNascSenior.setText("");
        rbSimSenior.setChecked(true);
    }
}