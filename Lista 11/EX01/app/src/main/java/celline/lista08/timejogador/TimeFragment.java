package celline.lista08.timejogador;

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
import java.time.LocalDate;
import java.util.List;

import celline.lista08.timejogador.controller.JogadorController;
import celline.lista08.timejogador.controller.TimeController;
import celline.lista08.timejogador.model.Jogador;
import celline.lista08.timejogador.model.Time;
import celline.lista08.timejogador.persistence.JogadorDao;
import celline.lista08.timejogador.persistence.TimeDao;

/*
 *@author: Celline
 */
public class TimeFragment extends Fragment {

    private View view;
    private EditText etNomeT;
    private EditText etCodT;
    private EditText etCidadeT;
    private Button btnBuscarT;
    private Button btnInserirT;
    private Button btnEditarT;
    private Button btnExcluirT;
    private Button btnListarT;
    private TextView tvSaidaT;
    private TimeController tCont;

    public TimeFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_time, container, false);

        etNomeT = view.findViewById(R.id.etNomeT);
        etCodT = view.findViewById(R.id.etCodT);
        etCidadeT = view.findViewById(R.id.etCidadeT);
        btnBuscarT = view.findViewById(R.id.btnBuscarT);
        btnInserirT = view.findViewById(R.id.btnInserirT);
        btnEditarT = view.findViewById(R.id.btnEditarT);
        btnExcluirT = view.findViewById(R.id.btnExcluirT);
        btnListarT = view.findViewById(R.id.btnListarT);
        tvSaidaT = view.findViewById(R.id.tvSaidaT);
        tvSaidaT.setMovementMethod(new ScrollingMovementMethod());

        tCont = new TimeController(new TimeDao(view.getContext()));

        btnInserirT.setOnClickListener(op -> inserir());
        btnEditarT.setOnClickListener(op -> editar());
        btnExcluirT.setOnClickListener(op -> excluir());
        btnBuscarT.setOnClickListener(op -> buscar());
        btnListarT.setOnClickListener(op -> listar());

        return view;
    }

    private void inserir() {
        Time time = montaTime();
        try {
            tCont.inserir(time);
            Toast.makeText(view.getContext(), "Time Cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void editar() {
        Time time = montaTime();
        try {
            tCont.editar(time);
            Toast.makeText(view.getContext(), "Time Atualizado com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void excluir() {
        Time time = montaTime();
        try {
            tCont.excluir(time);
            Toast.makeText(view.getContext(), "Time Excluído com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void buscar() {
        Time time = montaTime();
        try {
            time = tCont.buscar(time);
            if (time.getNome() != null){
                preencheCampos(time);
            } else {
                Toast.makeText(view.getContext(), "Time Não Encontrado :(", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void listar() {
        try {
            List<Time> times = tCont.listar();
            StringBuffer buffer = new StringBuffer();
            for (Time t : times){
                buffer.append(t.toString() + "\n");
            }
            tvSaidaT.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private Time montaTime(){
        Time time = new Time();
        time.setCodigo(Integer.parseInt(etCodT.getText().toString()));
        time.setNome(etNomeT.getText().toString());
        time.setCidade(etCidadeT.getText().toString());

        return time;
    }

    private void preencheCampos(Time time){
        etCodT.setText(time.getCodigo());
        etNomeT.setText(time.getNome());
        etCidadeT.setText(time.getCidade());
    }

    private void limpaCampos(){
        etCodT.setText("");
        etNomeT.setText("");
        etCidadeT.setText("");
    }
}