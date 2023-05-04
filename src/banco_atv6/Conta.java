package banco_atv6;

import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class Conta  {
    protected int numeroConta;
    protected Titular titular;
    protected double saldo;
    protected boolean ativa;
    public Conta() {
        this.ativa = true;
        this.titular = new Titular();
    }
    public void cadastroTitular(){
        titular.cadastroTitular();
    }
    public void fazerSaque(){
        DecimalFormat df = new DecimalFormat("#.00");
        Scanner input = new Scanner(System.in);
        System.out.println("============SACAR============");
        System.out.println("Digite o valor que deseja sacar: ");
        double saque = input.nextDouble();
        if(this.ativa){
            if (saque < getSaldo()){
                System.out.println("Saldo insuficiente!");
            } else if (saque >= getSaldo()) {
                setSaldo(getSaldo() - saque);
                String numeroFormatado = df.format(getSaldo());
                System.out.println("Saque efetuado!" +
                        "\nSaldo atual agora de: R$" + numeroFormatado);
            }
        }else {
            System.out.println("Conta esta desativada.");
        }
    }
    public void fazerDeposito(){
        DecimalFormat df = new DecimalFormat("#.00");
        if (this.ativa){
            Scanner input = new Scanner(System.in);
            System.out.println("============DEPOSITO============");
            System.out.println("Digite o valor que deseja depositar: ");
            double deposito = input.nextDouble();
            setSaldo(getSaldo() + deposito);
            String numeroFormatado = df.format(getSaldo());
            System.out.println("Deposito realizado com sucesso, seu saldo agora e de: R$" + numeroFormatado);
        }
        else {
            System.out.println("Conta esta desativada.");
        }
    }
    public void consultarSaldo(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("============CONSULTA============");
        System.out.println("Ola, " + titular.getNomeCompleto());
        String numeroFormatado = df.format(getSaldo());
        System.out.println("Seu saldo e de: R$" + numeroFormatado);
    }
    public int getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public boolean isAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
