package celline.trabalhosemestral.agenda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import celline.trabalhosemestral.agenda.controller.CompromissosController;
import celline.trabalhosemestral.agenda.model.Compromissos;
import celline.trabalhosemestral.agenda.persistence.CompromissosDao;

/*
 *@author: Celline
 */
public class CompromissosFragment extends Fragment {

    private View view;
    private EditText etNomeC;
    private EditText etIdC;
    private EditText etDataC;
    private EditText etHoraC;
    private EditText etObservacoesC;
    private Button btnBuscarC;
    private Button btnInserirC;
    private Button btnEditarC;
    private Button btnExcluirC;
    private Button btnListarC;
    private TextView tvSaidaC;
    private CompromissosController cCont;

    public CompromissosFragment() {
        super();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_compromissos, container, false);

        etNomeC = view.findViewById(R.id.etNomeC);
        etIdC = view.findViewById(R.id.etIdC);
        etDataC = view.findViewById(R.id.etDataC);
        etHoraC = view.findViewById(R.id.etHoraC);
        etObservacoesC = view.findViewById(R.id.etObservacoesC);
        btnBuscarC = view.findViewById(R.id.btnBuscarC);
        btnInserirC = view.findViewById(R.id.btnInserirC);
        btnEditarC = view.findViewById(R.id.btnEditarC);
        btnExcluirC = view.findViewById(R.id.btnExcluirC);
        btnListarC = view.findViewById(R.id.btnListarC);
        tvSaidaC = view.findViewById(R.id.tvSaidaC);
        tvSaidaC.setMovementMethod(new ScrollingMovementMethod());

        cCont = new CompromissosController(new CompromissosDao(view.getContext()));

        btnInserirC.setOnClickListener(op -> inserir());
        btnEditarC.setOnClickListener(op -> editar());
        btnExcluirC.setOnClickListener(op -> excluir());
        btnBuscarC.setOnClickListener(op -> buscar());
        btnListarC.setOnClickListener(op -> listar());

        return view;
    }

    private void inserir() {
        Compromissos compromisso = montaCompromisso();
        try {
            cCont.inserir(compromisso);
            Toast.makeText(view.getContext(), "Compromisso Cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void editar() {
        Compromissos compromisso = montaCompromisso();
        try {
            cCont.editar(compromisso);
            Toast.makeText(view.getContext(), "Compromisso Editado com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void excluir() {
        Compromissos compromisso = montaCompromisso();
        try {
            cCont.excluir(compromisso);
            Toast.makeText(view.getContext(), "Compromisso Excluído com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void buscar() {
        Compromissos compromisso = montaCompromisso();
        try {
            compromisso = cCont.buscar(compromisso);
            if (compromisso.getNome() != null){
                preencheCampos(compromisso);
            } else {
                Toast.makeText(view.getContext(), "Compromisso Não Encontrado :(", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void listar() {
        try {
            List<Compromissos> compromissos = cCont.listar();
            StringBuffer buffer = new StringBuffer();
            for (Compromissos c : compromissos){
                buffer.append(c.toString() + "\n");
            }
            tvSaidaC.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private Compromissos montaCompromisso() {
        Compromissos c = new Compromissos();
        c.setId(Integer.parseInt(etIdC.getText().toString()));
        c.setNome(etNomeC.getText().toString());
        c.setData(Float.parseFloat(etDataC.getText().toString()));
        c.setHora(etHoraC.getText().toString());
        c.setObs(etObservacoesC.getText().toString());

        return c;
    }

    private void preencheCampos(Compromissos compromisso) {
        etIdC.setText(compromisso.getId());
        etNomeC.setText(compromisso.getNome());
        etDataC.setText(String.valueOf(compromisso.getData()));
        etHoraC.setText(compromisso.getHora());
        etObservacoesC.setText(compromisso.getObs());
    }

    private void limpaCampos() {
        etIdC.setText("");
        etNomeC.setText("");
        etDataC.setText("");
        etHoraC.setText("");
        etObservacoesC.setText("");
    }

}