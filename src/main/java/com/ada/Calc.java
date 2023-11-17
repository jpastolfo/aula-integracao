package com.ada;


import org.springframework.stereotype.Service;

@Service
public class Calc {

    public int qtdeOperacoes = 0;

    public Calc() {}

    public int somar(int x, int y){
        qtdeOperacoes++;
        return x + y;
    }

    public int subtrair(int x, int y){
        qtdeOperacoes++;
        return x - y;
    }

    public float dividir(int x, int y){
        qtdeOperacoes++;
        return x / y;
    }
}
