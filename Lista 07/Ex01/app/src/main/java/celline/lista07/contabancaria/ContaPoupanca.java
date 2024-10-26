package celline.lista07.contabancaria;

import android.content.Context;

/*
 *@author:<Celline>
 */
public class ContaPoupanca extends ContaBancaria {

    private int diaRendimento;

    public int getDiaRendimento() {
        return diaRendimento;
    }
    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }

    public float calcularNovoSaldo(float taxaRendimento){
        taxaRendimento = taxaRendimento/100;
        taxaRendimento = getSaldo() * taxaRendimento;
        setSaldo(getSaldo() +  taxaRendimento);
        return getSaldo();
    }

    @Override
    public float sacar(float valorSacar) {
        return super.sacar(valorSacar);
    }
    @Override
    public float depositar(float valorDepositar) {
        return super.depositar(valorDepositar);
    }
}
