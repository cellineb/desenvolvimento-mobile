package celline.trabalhosemestral.agenda;

import static kotlin.text.Typography.times;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import celline.trabalhosemestral.agenda.controller.DisciplinaController;
import celline.trabalhosemestral.agenda.controller.TarefasController;
import celline.trabalhosemestral.agenda.model.Disciplina;
import celline.trabalhosemestral.agenda.model.Tarefas;
import celline.trabalhosemestral.agenda.persistence.DisciplinasDao;
import celline.trabalhosemestral.agenda.persistence.TarefasDao;

/*
 *@author: Celline
 */
public class TarefasFragment extends Fragment {

    private View view;
    private EditText etNomeT;
    private EditText etIdT;
    private EditText etDataT;
    private EditText etHoraT;
    private EditText etTipoT;
    private Button btnBuscarT;
    private Button btnInserirT;
    private Button btnEditarT;
    private Button btnExcluirT;
    private Button btnListarT;
    private TextView tvSaidaT;
    private TarefasController tCont;
    private DisciplinaController dCont;
    private List tipoTarefas;
    private Spinner spn;
    private List<Disciplina> disciplinas;

    public TarefasFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tarefas, container, false);

        etNomeT = view.findViewById(R.id.etNomeT);
        etIdT = view.findViewById(R.id.etIdT);
        etDataT = view.findViewById(R.id.etDataT);
        etHoraT = view.findViewById(R.id.etHoraT);
        etTipoT = view.findViewById(R.id.etTipoT);
        btnBuscarT = view.findViewById(R.id.btnBuscarT);
        btnInserirT = view.findViewById(R.id.btnInserirT);
        btnEditarT = view.findViewById(R.id.btnEditarT);
        btnExcluirT = view.findViewById(R.id.btnExcluirT);
        btnListarT = view.findViewById(R.id.btnListarT);
        tvSaidaT = view.findViewById(R.id.tvSaidaT);
        spn = view.findViewById(R.id.spn);
        tvSaidaT.setMovementMethod(new ScrollingMovementMethod());

        tCont = new TarefasController(new TarefasDao(view.getContext()));
        dCont = new DisciplinaController(new DisciplinasDao(view.getContext()));
        preencheSpinner();

        btnInserirT.setOnClickListener(op -> inserir());
        btnEditarT.setOnClickListener(op -> editar());
        btnExcluirT.setOnClickListener(op -> excluir());
        btnBuscarT.setOnClickListener(op -> buscar());
        btnListarT.setOnClickListener(op -> listar());

        return view;
    }

    private void inserir() {
        int spnPos = spn.getSelectedItemPosition();
        if (spnPos > 0){
            Tarefas tarefa = montaTarefa();
            try {
                tCont.inserir(tarefa);
                Log.i("MainActivity", "inserido");
                Toast.makeText(view.getContext(), "Tarefa Cadastrada com Sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            limpaCampos();
        } else {
            Toast.makeText(view.getContext(), "Selecione uma Disciplina", Toast.LENGTH_LONG).show();
        }
    }

    private void editar() {
        int spnPos = spn.getSelectedItemPosition();
        if (spnPos > 0){
            Tarefas tarefa = montaTarefa();
            try {
                tCont.editar(tarefa);
                Log.i("MainActivity", "editado");
                Toast.makeText(view.getContext(), "Tarefa Editada com Sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            limpaCampos();
        } else {
            Toast.makeText(view.getContext(), "Selecione uma Disciplina", Toast.LENGTH_LONG).show();
        }
    }

    private void excluir() {
        Tarefas tarefas = new Tarefas();
        tarefas = montaTarefa();
        try {
            tCont.excluir(tarefas);
            Log.i("MainActivity", "excluida");
            Toast.makeText(view.getContext(), "Disciplina Excluída com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void buscar() {
        Tarefas tarefas = montaTarefa();
        try {
            tarefas = tCont.buscar(tarefas);
            if (tarefas.getNome() != null){
                preencheCampos(tarefas);
            } else {
                Toast.makeText(view.getContext(), "Tarefa Não Encontrada :(", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void listar() {
        try {
            List<Tarefas> tarefas = tCont.listar();
            Log.i("MainActivity", "lista");
            StringBuffer buffer = new StringBuffer();
            for (Tarefas t : tarefas){
                buffer.append(t.toString() + "\n");
            }
            tvSaidaT.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private Tarefas montaTarefa() {
        Tarefas t = new Tarefas();
        t.setId(Integer.parseInt(etIdT.getText().toString()));
        t.setNome(etNomeT.getText().toString());
        t.setData(etDataT.getText().toString());
        t.setHora(etHoraT.getText().toString());
        t.setTipoTarefa(etTipoT.getText().toString());
        t.setDisciplina((Disciplina) spn.getSelectedItem());

        return t;
    }

    private void preencheCampos(Tarefas tarefa) {
        etIdT.setId(tarefa.getId());
        etNomeT.setText(tarefa.getNome());
        etDataT.setText(String.valueOf(tarefa.getData()));
        etHoraT.setText(tarefa.getHora());
        etTipoT.setText(tarefa.getTipoTarefa());

        int cont = 1;
        for (Disciplina d : disciplinas){
            if (d.getId() == tarefa.getDisciplina().getId()){
                spn.setSelection(cont);
            } else {
                cont++;
            }
        }
        if (cont > disciplinas.size()){
            spn.setSelection(0);
        }

    }

    private void limpaCampos() {
        etIdT.setText("");
        etNomeT.setText("");
        etDataT.setText("");
        etHoraT.setText("");
        etTipoT.setText("");
        spn.setSelection(0);
    }

    private void preencheSpinner() {
        Disciplina d0 = new Disciplina();
        d0.setId(0);
        d0.setNome("Selecione uma disciplina");

        try {
            disciplinas = dCont.listar();
            disciplinas.add(0, d0);

            ArrayAdapter ad = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, disciplinas);
            ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spn.setAdapter(ad);
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}