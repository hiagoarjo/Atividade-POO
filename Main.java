import java.util.ArrayList;

abstract class Contribuinte {
    protected String nome;
    protected double rendaBruta;

    public Contribuinte(String nome, double rendaBruta) {
        this.nome = nome;
        this.rendaBruta = rendaBruta;
    }

    public String getNome() {
        return nome;
    }

    public double getRendaBruta() {
        return rendaBruta;
    }

    public abstract double calcularImposto();
}

class PessoaFisica extends Contribuinte {

    public PessoaFisica(String nome, double rendaBruta) {
        super(nome, rendaBruta);
    }

    @Override
    public double calcularImposto() {
        double aliquota;
        double deducao;

        if (rendaBruta <= 1400) {
            aliquota = 0;
            deducao = 0;
        } else if (rendaBruta <= 2100) {
            aliquota = 0.10;
            deducao = 100;
        } else if (rendaBruta <= 2800) {
            aliquota = 0.15;
            deducao = 270;
        } else if (rendaBruta <= 3600) {
            aliquota = 0.25;
            deducao = 500;
        } else {
            aliquota = 0.30;
            deducao = 700;
        }

        return (rendaBruta * aliquota) - deducao;
    }
}

class PessoaJuridica extends Contribuinte {

    public PessoaJuridica(String nome, double rendaBruta) {
        super(nome, rendaBruta);
    }

    @Override
    public double calcularImposto() {
        return rendaBruta * 0.10;
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<Contribuinte> contribuintes = new ArrayList<>();

        contribuintes.add(new PessoaFisica("João", 1200));
        contribuintes.add(new PessoaFisica("Maria", 2500));
        contribuintes.add(new PessoaFisica("Pedro", 4000));

        contribuintes.add(new PessoaJuridica("Empresa A", 10000));
        contribuintes.add(new PessoaJuridica("Empresa B", 15000));
        contribuintes.add(new PessoaJuridica("Empresa C", 20000));

        double totalImpostos = 0;
        double somaPF = 0, somaPJ = 0;
        int qtdPF = 0, qtdPJ = 0;

        Contribuinte maiorContribuinte = null;
        double maiorImposto = 0;

        for (Contribuinte c : contribuintes) {
            double imposto = c.calcularImposto();

            System.out.println("Nome: " + c.getNome());
            System.out.println("Tipo: " + c.getClass().getSimpleName());
            System.out.println("Renda Bruta: R$ " + c.getRendaBruta());
            System.out.println("Imposto: R$ " + imposto);
            System.out.println("-----------------------");

            totalImpostos += imposto;

            if (c instanceof PessoaFisica) {
                somaPF += imposto;
                qtdPF++;
            } else {
                somaPJ += imposto;
                qtdPJ++;
            }

            if (imposto > maiorImposto) {
                maiorImposto = imposto;
                maiorContribuinte = c;
            }
        }

        System.out.println("\n=== RELATÓRIO FINAL ===");
        System.out.println("Total arrecadado: R$ " + totalImpostos);
        System.out.println("Maior imposto: R$ " + maiorImposto +
                " (" + maiorContribuinte.getNome() + ")");
        System.out.println("Média PF: R$ " + (somaPF / qtdPF));
        System.out.println("Média PJ: R$ " + (somaPJ / qtdPJ));
    }
}
