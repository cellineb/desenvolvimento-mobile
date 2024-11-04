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
import celline.lista08.cadastroatletas.controller.OperacaoOutros;
import celline.lista08.cadastroatletas.model.Outros;

public class OutrosFragment extends Fragment {

    private View view;
    private EditText etNomeOutros;
    private EditText etNascOutros;
    private EditText etBairroOutros;
    private EditText etAcademiaOutros;
    private EditText etRecordOutros;
    private Button btnCadastrarOutros;
    private TextView tvListaOutros;

    public OutrosFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_outros, container, false);

        etNomeOutros = view.findViewById(R.id.etNomeOutros);
        etNascOutros = view.findViewById(R.id.etNascOutros);
        etBairroOutros = view.findViewById(R.id.etBairroOutros);
        etAcademiaOutros = view.findViewById(R.id.etRecordOutros);
        etRecordOutros = view.findViewById(R.id.etRecordOutros);
        btnCadastrarOutros = view.findViewById(R.id.btnCadastrarOutros);
        tvListaOutros = view.findViewById(R.id.tvListaOutros);

        btnCadastrarOutros.setOnClickListener(op -> cadastro());

        return view;
    }

    private void cadastro() {

        Outros outros = new Outros();

        outros.setNome(etNomeOutros.getText().toString());
        outros.setData(etNascOutros.getText().toString());
        outros.setBairro(etBairroOutros.getText().toString());
        outros.setAcademia(etAcademiaOutros.getText().toString());
        outros.setRecord(Integer.parseInt(etRecordOutros.getText().toString()));

        IOperacao<Outros> op = new OperacaoOutros();
        op.cadastrar(outros);
        List<Outros> lista = op.listar();

        StringBuffer buffer = new StringBuffer();
        for (Outros o : lista){
            buffer.append(o.toString() + "\n");
        }

    }
}