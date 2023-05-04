package banco_atv6;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Titular {
    private String nome;
    private String sobrenome;
    private int dia;
    private int mes;
    private int ano;
    private int idade;
    private  String nomeCompleto;
    public Titular(){
        setNome("");
        setSobrenome("");
        setIdade(0);
        setAno(0);
        setMes(0);
        setDia(0);
        setNomeCompleto("");
    }

    public void cadastroTitular(){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);

        //CADASTRANDO NOME E SOBRENOME
        System.out.println("============CADASTRO TITULAR============");
        System.out.println("Digite seu primeiro nome: ");
        String nome = in2.nextLine();
        setNome(nome);
        System.out.println("Digite seu sobrenome: ");
        String sobrenome = in.nextLine();
        setSobrenome(sobrenome);
        setNomeCompleto(getNome() + " " + getSobrenome());

        //CADASTRANDO DATA DE NASCIMENTO
        System.out.println("Digite seu dia de nascimento: ");
        int dia = inInt.nextInt();
        setDia(dia);
        System.out.println("Digite seu mes de nascimento: ");
        int mes = inInt.nextInt();
        setMes(mes);
        System.out.println("Digite seu ano de nascimento: ");
        int ano = inInt.nextInt();
        setAno(ano);
        System.out.println("===================================");

        //ALGORITIMO PARA CALULAR IDADE
        LocalDate hoje = LocalDate.now(); //PEGA DIA DE HOJE
        LocalDate dataNascimento = LocalDate.of(getAno(),getMes(), getDia()); //RECEBE DIA, MES E ANO COMO PARAMETRO
        setIdade(Period.between(dataNascimento, hoje).getYears()); //FAZA A SUBTRACAO DA DATA DE NASCIMENTO PELO DIA DE HJ, OBTENDO O A IDADE
    }

    public String imprimirDados(){
        System.out.println("============DADOS DO TITULAR============");
     return "Nome: " + getNome() +
             "\nSobrenome: " + getSobrenome()+
             "\nIdade: " + getIdade()+
             "\nData de nascimento: " +getDia() + "/"+getMes() + "/" + getAno();

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}
