package banco_atv6;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void chamarMenu(){
        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        Random rand = new Random();
        Random rand2 = new Random();

        //CONTA CORRENTE
        //GERA UM VALOR ALEATORIO PARA O SALDO DA CONTA ENTRE 100,00 E 10.000,00
        double saldoAleatorio2 = 100 + (10000 - 100) * rand2.nextDouble();
        contaCorrente.setSaldo(saldoAleatorio2);
        //GERA UM VALOR ALEATORIO PARA O CREDITO ESPECIAL DA CONTA
        double limiteAleatorio2 = 100 +(1000 - 100) * rand2.nextDouble();
        contaCorrente.setLimiteEspecial(limiteAleatorio2);
        contaCorrente.setTotalDisponivel(saldoAleatorio2 + limiteAleatorio2);

        //CONTA POUPANCA
        //GERA UM VALOR ALEATORIO PARA O SALDO DA CONTA ENTRE 100,00 E 10.000,00
        double saldoAleatorio = 100 + (10000 - 100) * rand2.nextDouble();
        contaPoupanca.setSaldo(saldoAleatorio);
        int diaAleatorio = rand.nextInt(31) + 1;
        contaPoupanca.setDiaAniversario(diaAleatorio);

        //CADASTRO DO TITULAR DA CONTA
        contaCorrente.cadastroTitular();
        contaPoupanca.cadastroTitular();
        int opc = 0;
        do {
            Scanner in = new Scanner (System.in);
            System.out.println("============ BANCO OAK ============" +
                    "\nDigite sua opcao: " +
                    "\n1-CONTA CORRENTE" +
                    "\n2-CONTA POUPANCA" +
                    "\n3-SAIR" +
                    "\n===================================");
            opc = in.nextInt();
            if(opc == 3){
                System.out.println("Saindoooo...\n\t\t\tVolte sempre!!!");
                break;
            }
            switch (opc){
                case 1:
                    System.out.println("============ BANCO OAK ============" +
                            "\n============ CORRENTE ============");
                    System.out.println("Digite sua opcao: " +
                            "\n1-SACAR" +
                            "\n2-DEPOSITAR" +
                            "\n3-CONSULTAR SALDO" +
                            "\n4-CANCELAR CONTA" +
                            "\n5-DADOS DO TITULAR DA CONTA" +
                            "\n6-SAIR" +
                            "\n===================================");
                    opc = in.nextInt();
                    switch (opc){
                        case 1: //SACAR
                            contaCorrente.fazerSaque();
                            break;
                        case 2: // DEPOSITAR
                            contaCorrente.fazerDeposito();
                            break;
                        case 3:// CONSULTAR SALDO
                            contaCorrente.consultarSaldo();
                            break;
                        case 4: // CANCELAR CONTA
                            System.out.println("Voce deseja ativar ou cancelar sua conta: " +
                                    "\n1-CANCELAR" +
                                    "\n2-ATIVAR");
                            int opc2 = in.nextInt();
                            if(opc2 == 1){
                                contaCorrente.setAtiva(false);
                                System.out.println("Conta desativada com sucesso!");
                            } else if (opc2 == 2) {
                                contaCorrente.setAtiva(true);
                                System.out.println("Conta ativada com sucesso!");
                            }
                            break;
                        case 5://IMPRIMIR OS DADOS DO TITULAR DA CONTA
                            System.out.println(contaCorrente.titular.imprimirDados());
                            break;
                        case 6:
                            System.out.println("Saindoooo...\n\t\t\tVolte sempre!!!");
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("============ BANCO OAK ============" +
                            "\n============ POUPANCA ============");
                    System.out.println("Digite sua opcao: " +
                            "\n1-SACAR" +
                            "\n2-DEPOSITAR" +
                            "\n3-CONSULTAR SALDO" +
                            "\n4-CANCELAR CONTA" +
                            "\n5-DADOS DO TITULAR DA CONTA" +
                            "\n6-SAIR" +
                            "\n===================================");
                    opc = in.nextInt();
                    switch (opc){
                        case 1: //SACAR
                            contaPoupanca.fazerSaque();
                            break;
                        case 2: // DEPOSITAR
                            contaPoupanca.fazerDeposito();
                            break;
                        case 3:// CONSULTAR SALDO
                            contaPoupanca.consultarSaldo();
                            break;
                        case 4: // CANCELAR CONTA
                            System.out.println("Voce deseja ativar ou cancelar sua conta: " +
                                    "\n1-CANCELAR" +
                                    "\n2-ATIVAR");
                            int opc2 = in.nextInt();
                            if(opc2 == 1){
                                contaPoupanca.setAtiva(false);
                                System.out.println("Conta desativada com sucesso!");
                            } else if (opc2 == 2) {
                                contaPoupanca.setAtiva(true);
                                System.out.println("Conta ativada com sucesso!");
                            }
                            break;
                        case 5://IMPRIMIR OS DADOS DO TITULAR DA CONTA
                            System.out.println(contaPoupanca.titular.imprimirDados());
                            break;
                        case 6:
                            System.out.println("Saindoooo...\n\t\t\tVolte sempre!!!");
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente!");
                    break;
            }
        }while (opc != 6);

}
}
