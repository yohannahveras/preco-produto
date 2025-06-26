import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produto> listaProdutos = new ArrayList<>();
        System.out.println("Digite a quantidade de produtos: ");
        int n = sc.nextInt();
        for (int i = 1; i<= n; i++) {
            System.out.println("Dados do produto " + i + ":");
            System.out.print("Comum, usado ou importado? (c/u/i): ");
            char tipo = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Preço: ");
            Double preco = sc.nextDouble();
            if (tipo == 'c') {
                listaProdutos.add(new Produto(nome, preco));
            }
            else if (tipo == 'u') {
                sc.nextLine();
                System.out.print("Data de fabricação: ");
                LocalDate dataFabricacao = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                listaProdutos.add(new ProdutoUsado(nome, preco, dataFabricacao));
            }
            else {
                sc.nextLine();
                System.out.print("Taxa da alfândega: ");
                Double taxaAlfandega = sc.nextDouble();
                listaProdutos.add(new ProdutoImportado(nome, preco, taxaAlfandega));
            }
        }

        System.out.println("TAG DE PREÇOS:");
        for (Produto produtos : listaProdutos){
            System.out.println(produtos.tagPreco());
        }

        sc.close();
    }
}