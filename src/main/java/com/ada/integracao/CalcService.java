package com.ada.integracao;

import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public int qtdeOperacoes = 0;

    public CalcService() {}

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
