package celline.trabalhosemestral.agenda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import celline.trabalhosemestral.agenda.controller.DisciplinaController;
import celline.trabalhosemestral.agenda.model.Disciplina;
import celline.trabalhosemestral.agenda.persistence.DisciplinasDao;

public class DisciplinaFragment extends Fragment {

    private View view;
    private EditText etIdD;
    private EditText etNomeD;
    private TextView tvSaidaD;
    private DisciplinaController dCont;
    private Button btnBuscarD;
    private Button btnInserirD;
    private Button btnEditarD;
    private Button btnExcluirD;
    private Button btnListarD;

    public DisciplinaFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_disciplina, container, false);

        etIdD = view.findViewById(R.id.etIdD);
        Log.i("MainActivity", "id encontrado");
        etNomeD = view.findViewById(R.id.etNomeD);
        tvSaidaD = view.findViewById(R.id.tvSaidaD);
        tvSaidaD.setMovementMethod(new ScrollingMovementMethod());
        btnBuscarD = view.findViewById(R.id.btnBuscarD);
        btnInserirD = view.findViewById(R.id.btnInserirD);
        btnEditarD = view.findViewById(R.id.btnEditarD);
        btnExcluirD = view.findViewById(R.id.btnExcluirD);
        btnListarD = view.findViewById(R.id.btnListarD);

        dCont = new DisciplinaController(new DisciplinasDao(view.getContext()));

        btnInserirD.setOnClickListener(op -> inserir());
        btnEditarD.setOnClickListener(op -> editar());
        btnExcluirD.setOnClickListener(op -> excluir());
        btnBuscarD.setOnClickListener(op -> buscar());
        btnListarD.setOnClickListener(op -> listar());

        return view;
    }

    private void inserir() {
        Disciplina disciplina = new Disciplina();
        disciplina = montaDisciplina();
        try {
            dCont.inserir(disciplina);
            Log.i("MainActivity", "inserido");
            Toast.makeText(view.getContext(), "Disciplina Cadastrada com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            Log.i("MainActivity", "erro");
        }
        limpaCampos();
    }

    private void editar() {
        Disciplina disciplina = new Disciplina();
        disciplina = montaDisciplina();
        try {
            dCont.editar(disciplina);
            Log.i("MainActivity", "editada");
            Toast.makeText(view.getContext(), "Disciplina Editada com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void excluir() {
        Disciplina disciplina = new Disciplina();
        disciplina = montaDisciplina();
        try {
            dCont.excluir(disciplina);
            Log.i("MainActivity", "excluida");
            Toast.makeText(view.getContext(), "Disciplina Excluída com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void buscar() {
        Disciplina disciplina = montaDisciplina();
        try {
            disciplina = dCont.buscar(disciplina);
            if (disciplina.getNome() != null){
                preencheCampos(disciplina);
            } else {
                Toast.makeText(view.getContext(), "Disciplina Não Encontrado :(", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void listar() {
        try {
            List<Disciplina> disciplinas = dCont.listar();
            StringBuffer buffer = new StringBuffer();
            for (Disciplina d : disciplinas){
                buffer.append(d.toString() + "\n");
            }
            Log.i("MainActivity", "lista");
            tvSaidaD.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private Disciplina montaDisciplina() {
        Disciplina d = new Disciplina();
        d.setId(Integer.parseInt(etIdD.getText().toString()));
        d.setNome(etNomeD.getText().toString());

        return d;
    }

    private void preencheCampos(Disciplina disciplina) {
        etIdD.setText(String.valueOf(disciplina.getId()));
        Log.i("MainActivity", "pegar o nome");
        etNomeD.setText(disciplina.getNome());
    }

    private void limpaCampos() {
        etIdD.setText("");
        etNomeD.setText("");
    }
}