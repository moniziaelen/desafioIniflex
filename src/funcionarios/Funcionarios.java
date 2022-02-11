/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author monizia
 */
public class Funcionarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionariosList = new ArrayList();
        Map<String, ArrayList<Funcionario>> funcionariosMap = new HashMap<>();

        //3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        funcionariosList.add(new Funcionario(
                "Maria",
                LocalDateTime.of(2000, 10, 18, 0, 0),
                new BigDecimal(2009.44).setScale(2, RoundingMode.HALF_UP),
                "Operador"));

        funcionariosList.add(new Funcionario(
                "João",
                LocalDateTime.of(1990, 05, 12, 0, 0),
                new BigDecimal(2284.38).setScale(2, RoundingMode.HALF_UP),
                "Operador"));

        funcionariosList.add(new Funcionario(
                "Caio",
                LocalDateTime.of(1961, 05, 02, 0, 0),
                new BigDecimal(9836.14).setScale(2, RoundingMode.HALF_UP),
                "Coordenador"));

        funcionariosList.add(new Funcionario(
                "Miguel",
                LocalDateTime.of(1988, 10, 14, 0, 0),
                new BigDecimal(19119.88).setScale(2, RoundingMode.HALF_UP),
                "Diretor"));

        funcionariosList.add(new Funcionario(
                "Alice",
                LocalDateTime.of(1995, 01, 05, 0, 0),
                new BigDecimal(2234.68).setScale(2, RoundingMode.HALF_UP),
                "Recepcionista"));

        funcionariosList.add(new Funcionario(
                "Heitor",
                LocalDateTime.of(1999, 11, 19, 0, 0),
                new BigDecimal(1582.72).setScale(2, RoundingMode.HALF_UP),
                "Operador"));

        funcionariosList.add(new Funcionario(
                "Arthur",
                LocalDateTime.of(1993, 03, 31, 0, 0),
                new BigDecimal(4071.84).setScale(2, RoundingMode.HALF_UP),
                "Contador"));

        funcionariosList.add(new Funcionario(
                "Laura",
                LocalDateTime.of(1994, 07, 8, 0, 0),
                new BigDecimal(3017.45).setScale(2, RoundingMode.HALF_UP),
                "Gerente"));

        funcionariosList.add(new Funcionario(
                "Heloísa",
                LocalDateTime.of(2003, 05, 24, 0, 0),
                new BigDecimal(1606.85).setScale(2, RoundingMode.HALF_UP),
                "Eletricista"));

        funcionariosList.add(new Funcionario(
                "Helena",
                LocalDateTime.of(1996, 9, 2, 0, 0),
                new BigDecimal(2799.93).setScale(2, RoundingMode.HALF_UP),
                "Gerente"));

        //3.2 – Remover o funcionário “João” da lista.
        funcionariosList.removeIf(f -> f.getNome().equals("João"));

        /*
        3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
            • informação de data deve ser exibido no formato dd/mm/aaaa;
            • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
         */
        for (Funcionario funcionario : funcionariosList) {
            System.out.println(funcionario.toString());
        }

        //3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        for (Funcionario funcionario : funcionariosList) {
            funcionario.ajustaSal(10);
            System.out.println(funcionario.toString());
        }

        //3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        for (Funcionario funcionario : funcionariosList) {
            funcionariosMap.put(funcionario.getFuncao(), new ArrayList<>());
        }
        for (Funcionario funcionario : funcionariosList) {
            funcionariosMap.get(funcionario.getFuncao()).add(funcionario);
        }

        //3.6 – Imprimir os funcionários, agrupados por função.
        System.out.println(funcionariosMap);

        //3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        for (Funcionario funcionario : funcionariosList) {
            if (funcionario.getDataNascimento().getMonthValue() == 10
                    || funcionario.getDataNascimento().getMonthValue() == 12) {
                System.out.println(funcionario.toString());
            }
        }

        //3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        int maior = 0;
        Funcionario maisVelho = null;
        for (Funcionario funcionario : funcionariosList) {
            int atual = (int) ChronoUnit.YEARS.between(funcionario.getDataNascimento(), LocalDateTime.now());
            if (maior < atual) {
                maior = atual;
                maisVelho = funcionario;
            }
        }
        System.out.println(maisVelho.getNome() + " | " + maior);

        //3.10 – Imprimir a lista de funcionários por ordem alfabética.
        Collections.sort(funcionariosList, new Comparator() {
            public int compare(Object o1, Object o2) {
                Funcionario f1 = (Funcionario) o1;
                Funcionario f2 = (Funcionario) o2;
                return f1.getNome().compareToIgnoreCase(f2.getNome());
            }
        });

        for (Funcionario funcionario : funcionariosList) {
            System.out.println(funcionario.toString());
        }

        //3.11 – Imprimir o total dos salários dos funcionários.
        double totalSal = 0.0;
        for (Funcionario funcionario : funcionariosList) {
            totalSal += funcionario.getSalario().doubleValue();
        }
        System.out.println(totalSal);

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        for (Funcionario funcionario : funcionariosList) {
            double qtd = funcionario.getSalario().doubleValue() / 1212.00;

            System.out.println(funcionario.getNome() + " - " + numberFormat.format(qtd) + " salários");
        }

    }

}
