/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author monizia
 */
public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(String nome, LocalDateTime dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
        
        DecimalFormat numFormatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = numFormatter.getDecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        numFormatter.setDecimalFormatSymbols(symbols);

        
        return nome + " | " + dataNascimento.format(formatter) + " | " + numFormatter.format(salario) + " | " + funcao;
    }
    
    public void ajustaSal(double porcentagem){
        double salario = this.salario.doubleValue();
        this.salario = new BigDecimal(salario + (salario * (porcentagem/100))).setScale(2, RoundingMode.HALF_UP);
    }
}
