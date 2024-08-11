package com.lojaonline;

import java.util.List;
import java.util.Scanner;

public class CadastroDeProduto {
    private List<Produto> produtos;

    public CadastroDeProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public static void pesquisarProduto(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o código do produto");
        String codigo = scanner.nextLine();
    }
}
