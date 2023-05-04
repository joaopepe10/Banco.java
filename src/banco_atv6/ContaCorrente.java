package banco_atv6;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class ContaCorrente extends Conta{
    private double totalDisponivel;
    private double limiteEspecial;
    private double limiteEspecialUtilizado;
    private boolean limiteUtilizado;
    public ContaCorrente(){
    }
    @Override
    public void fazerDeposito(){
        DecimalFormat df = new DecimalFormat("#.00");
        if (this.ativa){
            System.out.println("============DEPOSITAR============");
            Scanner input = new Scanner(System.in);

            //CASO TENHA SIDO USADO UM LIMITE ESPECIAL, SERA DEBITADO O CREDITO ESPECIAL DO DEPOSITO
            if (this.limiteUtilizado){
                System.out.println("Digite o valor que deseja depositar: ");
                double deposito = input.nextDouble();
                String numFormat = df.format(getLimiteEspecialUtilizado());
                System.out.println("Devido voce ter utilizado o limite especial, nos estamos debitando o mesmo no valor do deposito, debito de: R$" +
                        numFormat + ".");
                deposito = deposito - getLimiteEspecialUtilizado();
                setSaldo(getSaldo() + deposito);
                setLimiteEspecial(getLimiteEspecial() + getLimiteEspecialUtilizado());
                setTotalDisponivel(getSaldo() + getLimiteEspecial());
            }else {
                System.out.println("Digite o valor que deseja depositar: ");
                double deposito = input.nextDouble();
                setSaldo(getSaldo() + deposito);
                setTotalDisponivel(getSaldo() + getLimiteEspecial());
                String numFormat = df.format(getSaldo());
                System.out.println("Deposito realizado com sucesso, seu saldo agora e de: R$" + numFormat);
            }
        }
        else {
            System.out.println("Conta esta desativada.");
        }
    }
    @Override
    public void fazerSaque(){
        DecimalFormat df = new DecimalFormat("#.00");
        Scanner input = new Scanner(System.in);
        System.out.println("============SACAR============");
        System.out.println("Digite o valor que deseja sacar: ");
        double saque = input.nextDouble();
        if(this.ativa){
            if (saque <= getTotalDisponivel()){
                if (saque <= getSaldo()){
                    setSaldo(getSaldo() - saque);
                    String numFormat = df.format(getSaldo());
                    System.out.println("Saque realizado com sucesso!" +
                            "\nSeu saldo atual e de: R$" + numFormat);
                    setTotalDisponivel(getSaldo() + getLimiteEspecial());
                }else if (saque <= getTotalDisponivel()){
                    //QUANDO UTILIZA O CREDITO ESPECIAL ENTRA NESSA CONDICAO
                    setSaldo(getSaldo() - getSaldo());
                    this.limiteUtilizado = true;
                    double antigoLimiteEspecial = getLimiteEspecial();
                    setLimiteEspecial(getTotalDisponivel() - saque);
                    //VARIAVEL UTILIZADO E PARA RECEBER O VALOR ANTIGO DO LIMITE ESPECIAL SUBTRAIDO PELO VALOR ATUAL DO LIMITE ESPECIAL
                    //PARA VER QUANTO QUE FOI UTILIZADO
                    double utilizado = antigoLimiteEspecial - getLimiteEspecial();
                    String numFormat = df.format(utilizado);
                    System.out.println("R$" + numFormat + " do limite especial utilizado, agora voce tem ");
                    setLimiteEspecialUtilizado(antigoLimiteEspecial - getLimiteEspecial());
                    setTotalDisponivel(getSaldo() + getLimiteEspecial());
                    String numFormat1 = df.format(getLimiteEspecial());
                    System.out.print("R$" + numFormat1+ " de limite especial.\n");
                }

            }else {
                System.out.println("Saldo da conta corrente insuficiente!" +
                        "\nVoce tem o saldo de : R$" + getSaldo());
            }
        }else {
            System.out.println("Conta esta desativada.");
        }

    }

    @Override
    public void consultarSaldo(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("============CONSULTA============");
        System.out.println("Ola, " + titular.getNomeCompleto());
        String numFormat = df.format(getSaldo());
        String numFormat1 = df.format(getLimiteEspecial());
        String numFormat2 = df.format(getTotalDisponivel());
        System.out.println("Seu saldo e de: R$" + numFormat +
        "\nSeu limite especial e de: R$" + numFormat1+
                "\nO total disponivel e de: R$" + numFormat2);
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }

    public double getTotalDisponivel() {
        return totalDisponivel;
    }

    public void setTotalDisponivel(double totalDisponivel) {
        this.totalDisponivel = totalDisponivel;
    }

    public double getLimiteEspecialUtilizado() {
        return limiteEspecialUtilizado;
    }

    public void setLimiteEspecialUtilizado(double limiteEspecialUtilizado) {
        this.limiteEspecialUtilizado = limiteEspecialUtilizado;
    }
}
