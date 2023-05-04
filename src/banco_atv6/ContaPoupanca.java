package banco_atv6;

import java.text.DecimalFormat;

public class ContaPoupanca extends Conta{
    private int diaAniversario;
    private double saldoDiaAniversario;
    private double taxaRemuneracaoMensal;

    public ContaPoupanca() {
        setTaxaRemuneracaoMensal(1.12);
    }

    @Override
    public void consultarSaldo(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("============CONSULTA============");
        System.out.println("Ola, " + titular.getNomeCompleto());
        String numeroFormatado = df.format(getSaldo());
        System.out.println("Seu saldo e de: R$" + numeroFormatado);
        System.out.println("Sua taxa de remuneracao mensal e de: " + getTaxaRemuneracaoMensal() + "% ao mes.");
        String n = df.format(getSaldo() * getTaxaRemuneracaoMensal());
        setSaldoDiaAniversario((getSaldo() * getTaxaRemuneracaoMensal()) - getSaldo());
        String m = df.format(getSaldoDiaAniversario());
        System.out.println("Esse mes, seu saldo rendera: R$" + m);

        System.out.println("Dia de aniversario: " + getDiaAniversario() + "\nSeu saldo no dia do aniversario sera de: R$" + n);

    }
    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public double getTaxaRemuneracaoMensal() {
        return taxaRemuneracaoMensal;
    }

    public void setTaxaRemuneracaoMensal(double taxaRemuneracaoMensal) {
        this.taxaRemuneracaoMensal = taxaRemuneracaoMensal;
    }

    public double getSaldoDiaAniversario() {
        return saldoDiaAniversario;
    }

    public void setSaldoDiaAniversario(double saldoDiaAniversario) {
        this.saldoDiaAniversario = saldoDiaAniversario;
    }
}
