package br.ulbra.apppagamento;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome, edtSB, edtNFilhos;
    private RadioGroup rgSexo;
    private TextView txtResultado;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtSB = findViewById(R.id.edtSB);
        edtNFilhos = findViewById(R.id.edtNFilhos);
        rgSexo = findViewById(R.id.rgSexo);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularSalario();
            }
        });
    }

    private void calcularSalario() {
        try {
            String nome = edtNome.getText().toString();
            if (nome.isEmpty()) {
                Toast.makeText(this, "Nome não pode ser vazio", Toast.LENGTH_SHORT).show();
                return;
            }

            double salarioBruto = Double.parseDouble(edtSB.getText().toString());
            if (salarioBruto <= 0) {
                Toast.makeText(this, "Salário bruto deve ser maior que zero", Toast.LENGTH_SHORT).show();
                return;
            }

            int numeroFilhos = Integer.parseInt(edtNFilhos.getText().toString());
            if (numeroFilhos < 0) {
                Toast.makeText(this, "Número de filhos inválido", Toast.LENGTH_SHORT).show();
                return;
            }
            String tratamento;
            if (rgSexo.getCheckedRadioButtonId() == R.id.rMasculino) {
                tratamento = "Sr.";
            } else {
                tratamento = "Sra.";
            }

            double descontoINSS;
            if (salarioBruto <= 1212.00) {
                descontoINSS = salarioBruto * 0.075;
            } else if (salarioBruto <= 2427.35) {
                descontoINSS = salarioBruto * 0.09;
            } else if (salarioBruto <= 3641.03) {
                descontoINSS = salarioBruto * 0.12;
            } else {
                descontoINSS = salarioBruto * 0.14;
            }

            double descontoIR;
            if (salarioBruto <= 1903.98) {
                descontoIR = 0;
            } else if (salarioBruto <= 2826.65) {
                descontoIR = salarioBruto * 0.075;
            } else if (salarioBruto <= 3751.05) {
                descontoIR = salarioBruto * 0.15;
            } else {
                descontoIR = salarioBruto * 0.225;
            }

            // Salário-Família
            double salarioFamilia = 0;
            if (salarioBruto <= 1212.00) {
                salarioFamilia = 56.47 * numeroFilhos;
            }

            // Cálculo do Salário Líquido
            double salarioLiquido = salarioBruto - (descontoINSS + descontoIR) + salarioFamilia;

            // Exibição dos resultados
            String resultado = String.format(
                    "%s %s\nINSS: R$ %.2f\nIR: R$ %.2f\nSalário Líquido: R$ %.2f",
                    tratamento, nome, descontoINSS, descontoIR, salarioLiquido
            );
            txtResultado.setText(resultado);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Erro de formato numérico", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Erro inesperado: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

