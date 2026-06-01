
class ContaBancaria {

    // Atributos privados
    private String numeroConta;
    private String titular;
    private double saldo;

    // Construtor
    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    // Getters
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Setter apenas para titular
    public void setTitular(String titular) {
        this.titular = titular;
    }

    // Método depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Erro: valor de depósito inválido.");
        }
    }

    // Método sacar
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Erro: saldo insuficiente ou valor inválido.");
        }
    }
}
class Main {
  public static void main(String[] args){
    ContaBancaria B1= new ContaBancaria("5", "Iago");
    B1.depositar(50.000);
    B1.sacar(49.000);
}
}

