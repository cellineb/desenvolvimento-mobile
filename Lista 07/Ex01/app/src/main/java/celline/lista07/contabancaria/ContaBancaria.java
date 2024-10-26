package celline.lista07.contabancaria;

public class ContaBancaria {

    private String cliente;
    private int numConta;
    private float saldo;

    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public float sacar(float valorSacar){
        float saldo = getSaldo();
        if((saldo-valorSacar)<0){
            return Float.parseFloat("Erro: Não foi possível sacar, pois a conta ficaria negativa");
        }
        else {
            float saldoAtual = saldo - valorSacar;
            setSaldo(saldoAtual);
            return saldoAtual;
        }
    }

    public float depositar(float valorDepositar){
        float novoSaldo = getSaldo() +valorDepositar;
        setSaldo(novoSaldo);
        return novoSaldo;
    }
}
