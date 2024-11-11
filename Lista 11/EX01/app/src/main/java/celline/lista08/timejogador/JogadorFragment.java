package celline.lista08.timejogador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
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
public class JogadorFragment extends Fragment {

    private View view;
    private EditText etNomeJ;
    private EditText etCodJ;
    private EditText etNascJ;
    private EditText etAlturaJ;
    private EditText etPesoJ;
    private Spinner spnTimeJ;
    private Button btnBuscarJ;
    private Button btnInserirJ;
    private Button btnEditarJ;
    private Button btnExcluirJ;
    private Button btnListarJ;
    private TextView tvSaidaJ;
    private JogadorController jCont;
    private TimeController tCont;
    private List<Time> times;

    public JogadorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_jogador, container, false);

        etNomeJ = view.findViewById(R.id.etNomeJ);
        etCodJ = view.findViewById(R.id.etCodJ);
        etNascJ = view.findViewById(R.id.etNascJ);
        etAlturaJ = view.findViewById(R.id.etAlturaJ);
        etPesoJ = view.findViewById(R.id.etPesoJ);
        spnTimeJ = view.findViewById(R.id.spnTimeJ);
        btnBuscarJ = view.findViewById(R.id.btnBuscarJ);
        btnInserirJ = view.findViewById(R.id.btnInserirJ);
        btnEditarJ = view.findViewById(R.id.btnEditarJ);
        btnExcluirJ = view.findViewById(R.id.btnExcluirJ);
        btnListarJ = view.findViewById(R.id.btnListarJ);
        tvSaidaJ = view.findViewById(R.id.tvSaidaJ);
        tvSaidaJ.setMovementMethod(new ScrollingMovementMethod());

        jCont = new JogadorController(new JogadorDao(view.getContext()));
        tCont = new TimeController(new TimeDao(view.getContext()));
        preencheSpinner();

        btnInserirJ.setOnClickListener(op -> inserir());
        btnEditarJ.setOnClickListener(op -> editar());
        btnExcluirJ.setOnClickListener(op -> excluir());
        btnBuscarJ.setOnClickListener(op -> buscar());
        btnListarJ.setOnClickListener(op -> listar());

        return view;
    }

    private void inserir() {
        int spnPos = spnTimeJ.getSelectedItemPosition();
        if (spnPos > 0){
            Jogador jogador = montaJogador();
            try {
                jCont.inserir(jogador);
                Toast.makeText(view.getContext(), "Jogador Cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            limpaCampos();
        } else {
            Toast.makeText(view.getContext(), "Selecione um Time", Toast.LENGTH_LONG).show();
        }
    }

    private void editar() {
        int spnPos = spnTimeJ.getSelectedItemPosition();
        if (spnPos > 0){
            Jogador jogador = montaJogador();
            try {
                jCont.editar(jogador);
                Toast.makeText(view.getContext(), "Jogador Atualizado com Sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            limpaCampos();
        } else {
            Toast.makeText(view.getContext(), "Selecione um Time", Toast.LENGTH_LONG).show();
        }
    }

    private void excluir() {
        Jogador jogador = montaJogador();
        try {
            jCont.excluir(jogador);
            Toast.makeText(view.getContext(), "Jogador Excluído com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void buscar() {
        Jogador jogador = montaJogador();
        try {
            times = tCont.listar();
            jogador = jCont.buscar(jogador);
            if (jogador.getNome() != null){
                preencheCampos(jogador);
            } else {
                Toast.makeText(view.getContext(), "Jogador Não Encontrado :(", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void listar() {
        try {
            List<Jogador> jogadores = jCont.listar();
            StringBuffer buffer = new StringBuffer();
            for (Jogador j : jogadores){
                buffer.append(j.toString() + "\n");
            }
            tvSaidaJ.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private Jogador montaJogador(){
        Jogador jogador = new Jogador();
        jogador.setId(Integer.parseInt(etCodJ.getText().toString()));
        jogador.setNome(etNomeJ.getText().toString());
        jogador.setDataNasc(LocalDate.parse(etNascJ.getText().toString()));
        jogador.setAltura(Float.parseFloat(etAlturaJ.getText().toString()));
        jogador.setPeso(Float.parseFloat(etPesoJ.getText().toString()));
        jogador.setCodTime((Time) spnTimeJ.getSelectedItem());

        return jogador;
    }

    private void preencheCampos(Jogador jogador){
        etCodJ.setText(jogador.getId());
        etNomeJ.setText(jogador.getNome());
        etNascJ.setText(jogador.getDataNasc().toString());
        etAlturaJ.setText((int) jogador.getAltura());
        etPesoJ.setText((int) jogador.getPeso());

        int cont = 1;
        for (Time t : times){
            if (t.getCodigo() == jogador.getCodTime().getCodigo()){
                spnTimeJ.setSelection(cont);
            } else {
                cont++;
            }
        }
        if (cont > times.size()){
            spnTimeJ.setSelection(0);
        }
    }

    private void limpaCampos(){
        etCodJ.setText("");
        etNomeJ.setText("");
        etNascJ.setText("");
        etAlturaJ.setText("");
        etPesoJ.setText("");
        spnTimeJ.setSelection(0);
    }

    private void preencheSpinner() {
        Time t0 = new Time();
        t0.setCodigo(0);
        t0.setNome("Selecione um time");
        t0.setCidade("");

        try {
            times = tCont.listar();
            times.add(0, t0);

            ArrayAdapter ad = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, times);
            ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnTimeJ.setAdapter(ad);
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}