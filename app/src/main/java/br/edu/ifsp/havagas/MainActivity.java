package br.edu.ifsp.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import br.edu.ifsp.havagas.model.Formulario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button salvarBt;
    private Button limparBt;
    private CheckBox recebeEmailCb;
    private CheckBox celularCb;
    private EditText nomeEt;
    private EditText emailEt;
    private EditText telefoneEt;
    private EditText celularEt;
    private EditText anoFormaturaEt;
    private EditText anoConclusaoGraduacaoEspecializacaoEt;
    private EditText instituicaoGraduacaoEspecializacaoEt;
    private EditText anoConclusaoMestradoDoutoradoEt;
    private EditText instituicaoMestradoDoutoradoEt;
    private EditText tituloMonografiaEt;
    private EditText orientadorEt;
    private EditText vagasEt;
    private EditText dataNascimentoEt;
    private LinearLayout celularLl;
    private LinearLayout fundamentalMedioLl;
    private LinearLayout graduacaoEspecializacaoLl;
    private LinearLayout mestradoDoutoradoLl;
    private RadioButton comercialRb;
    private RadioButton masculinoRb;
    private Spinner formacaoSp;

    private ArrayList<String> formacaoList;

    @Override
    public void onClick(View view) {
        Formulario formulario = buildFormulario();
        String message = formulario.toString();
        if (view.getId() == R.id.salvarBt) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.limparBt) {
            limparTodosOsCampos();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        formacaoList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.formacao)));
        ArrayAdapter<String> formacaoAdapter =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, formacaoList);
        formacaoSp.setAdapter(formacaoAdapter);

        formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long id) {
                if (formacaoList.get(posicao).equals("Fundamental") || formacaoList.get(posicao).equals("Médio")) {
                    fundamentalMedioLl.setVisibility(View.VISIBLE);
                    graduacaoEspecializacaoLl.setVisibility(View.GONE);
                    mestradoDoutoradoLl.setVisibility(View.GONE);
                } else if (formacaoList.get(posicao).equals("Graduação") || formacaoList.get(posicao).equals("Especialização")) {
                    fundamentalMedioLl.setVisibility(View.GONE);
                    graduacaoEspecializacaoLl.setVisibility(View.VISIBLE);
                    mestradoDoutoradoLl.setVisibility(View.GONE);
                } else {
                    fundamentalMedioLl.setVisibility(View.GONE);
                    graduacaoEspecializacaoLl.setVisibility(View.GONE);
                    mestradoDoutoradoLl.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                fundamentalMedioLl.setVisibility(View.GONE);
                graduacaoEspecializacaoLl.setVisibility(View.GONE);
                mestradoDoutoradoLl.setVisibility(View.GONE);
            }
        });

        celularCb.setOnClickListener(view -> {
            if (celularLl.getVisibility() == View.GONE) {
                celularLl.setVisibility(View.VISIBLE);
            } else {
                celularLl.setVisibility(View.GONE);
            }
        });
    }

    private void limparTodosOsCampos() {
        recebeEmailCb.setChecked(false);
        celularCb.setChecked(false);
        nomeEt.setText("");
        emailEt.setText("");
        telefoneEt.setText("");
        celularEt.setText("");
        anoFormaturaEt.setText("");
        anoConclusaoGraduacaoEspecializacaoEt.setText("");
        instituicaoGraduacaoEspecializacaoEt.setText("");
        anoConclusaoMestradoDoutoradoEt.setText("");
        instituicaoMestradoDoutoradoEt.setText("");
        tituloMonografiaEt.setText("");
        orientadorEt.setText("");
        vagasEt.setText("");
        dataNascimentoEt.setText("");
        celularLl.setVisibility(View.GONE);
        fundamentalMedioLl.setVisibility(View.GONE);
        graduacaoEspecializacaoLl.setVisibility(View.GONE);
        mestradoDoutoradoLl.setVisibility(View.GONE);
        comercialRb.setChecked(true);
        masculinoRb.setChecked(true);
        formacaoSp.setSelection(0);
    }

    private Formulario buildFormulario() {
        String nome = nomeEt.getText().toString();
        String sexo = masculinoRb.isChecked()?"Masculino":"Feminino";
        String email = emailEt.getText().toString();
        boolean recebeEmail = recebeEmailCb.isChecked();
        String telefone = telefoneEt.getText().toString();
        String tipoTelefone = comercialRb.isChecked()?"Comercial":"Residencial";
        boolean addCelular = celularCb.isChecked();
        String celular = celularEt.getText().toString();
        String nascimento = dataNascimentoEt.getText().toString();
        String formacao = ((TextView)formacaoSp.getSelectedView()).getText().toString();
        String anoDeFormatura = anoFormaturaEt.getText().toString();
        String anoGraduacao = anoConclusaoGraduacaoEspecializacaoEt.getText().toString();
        String anoMestrado = anoConclusaoMestradoDoutoradoEt.getText().toString();
        String instituicao = instituicaoGraduacaoEspecializacaoEt.getText().toString();
        String monografia = tituloMonografiaEt.getText().toString();
        String orientador = orientadorEt.getText().toString();
        String vagas = vagasEt.getText().toString();

        return new Formulario(nome, sexo, email, recebeEmail, telefone, tipoTelefone, addCelular,
                celular, nascimento, formacao, anoDeFormatura, anoGraduacao, anoMestrado,
                instituicao, monografia,orientador, vagas);
    }

    private void bindViews() {
        salvarBt = findViewById(R.id.salvarBt);
        limparBt = findViewById(R.id.limparBt);
        recebeEmailCb = findViewById(R.id.recebeEmailCb);
        celularCb = findViewById(R.id.celularCb);
        nomeEt = findViewById(R.id.nomeEt);
        emailEt = findViewById(R.id.emailEt);
        telefoneEt = findViewById(R.id.telefoneEt);
        celularEt = findViewById(R.id.celularEt);
        anoFormaturaEt = findViewById(R.id.anoFormaturaEt);
        anoConclusaoGraduacaoEspecializacaoEt = findViewById(R.id.anoConclusaoGraduacaoEspecializacaoEt);
        instituicaoGraduacaoEspecializacaoEt = findViewById(R.id.instituicaoGraduacaoEspecializacaoEt);
        anoConclusaoMestradoDoutoradoEt = findViewById(R.id.anoConclusaoMestradoDoutoradoEt);
        instituicaoMestradoDoutoradoEt = findViewById(R.id.instituicaoMestradoDoutoradoEt);
        tituloMonografiaEt = findViewById(R.id.tituloMonografiaEt);
        orientadorEt = findViewById(R.id.orientadorEt);
        vagasEt = findViewById(R.id.vagasEt);
        dataNascimentoEt = findViewById(R.id.dataNascimentoEt);
        celularLl = findViewById(R.id.celularLl);
        fundamentalMedioLl = findViewById(R.id.fundamentalMedioLl);
        graduacaoEspecializacaoLl = findViewById(R.id.graducaoEspecializacaoLl);
        mestradoDoutoradoLl = findViewById(R.id.mestradoDoutoradoLl);
        comercialRb = findViewById(R.id.comercialRb);
        masculinoRb = findViewById(R.id.masculinoRb);
        formacaoSp = findViewById(R.id.formacaoSp);

        salvarBt.setOnClickListener(this);
        limparBt.setOnClickListener(this);
    }
}