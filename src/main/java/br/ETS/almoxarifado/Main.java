package br.ETS.almoxarifado;


import br.ETS.almoxarifado.produto.DadosProduto;
import br.ETS.almoxarifado.produto.ProdutoService;
import java.util.Scanner;


public class Main {
    private static ProdutoService produtoService = new ProdutoService();
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private static int exibirMenu() {
        System.out.println("""
                                
                ░█████╗░██╗░░░░░███╗░░░███╗░█████╗░██╗░░██╗░█████╗░██████╗░██╗███████╗░█████╗░██████╗░░█████╗░
                ██╔══██╗██║░░░░░████╗░████║██╔══██╗╚██╗██╔╝██╔══██╗██╔══██╗██║██╔════╝██╔══██╗██╔══██╗██╔══██╗
                ███████║██║░░░░░██╔████╔██║██║░░██║░╚███╔╝░███████║██████╔╝██║█████╗░░███████║██║░░██║██║░░██║
                ██╔══██║██║░░░░░██║╚██╔╝██║██║░░██║░██╔██╗░██╔══██║██╔══██╗██║██╔══╝░░██╔══██║██║░░██║██║░░██║
                ██║░░██║███████╗██║░╚═╝░██║╚█████╔╝██╔╝╚██╗██║░░██║██║░░██║██║██║░░░░░██║░░██║██████╔╝╚█████╔╝
                ╚═╝░░╚═╝╚══════╝╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░░░░╚═╝░░╚═╝╚═════╝░░╚════╝░
                                
                ███████╗████████╗░██████╗
                ██╔════╝╚══██╔══╝██╔════╝
                █████╗░░░░░██║░░░╚█████╗░
                ██╔══╝░░░░░██║░░░░╚═══██╗
                ███████╗░░░██║░░░██████╔╝
                ╚══════╝░░░╚═╝░░░╚═════╝░
                                
                """);
        System.out.println("""
                Selecione uma opção:
                1-) Inserir novo produto no almoxarifado
                2-) Listar produtos do almoxarifado
                3-) Adicionar determinada quantidade de um produto no almoxarifado
                4-) Remover determinada quantidade de um produto do almoxarifado
                5-) Remover um produto do almoxarifado
                6-) Encerrar aplicação
                """);

        return Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {
        var opcao =exibirMenu();

            while (opcao!= 6){
                try{
                switch (opcao){
                    case 1 -> adicionarNovoProduto();
                    case 2 -> exibirProdutosCadastrados();
                    case 3 -> adicionarQuantidadeDeUmProduto();
                    case 4 -> removerQuantidadeDeUmProduto();
                    case 5 -> removerOProdutoDoAlmoxarifado();
                }


        }catch (RegraDaAplicacaoException e){
            System.out.println(e.getMessage());
            System.out.println("Pressione ENTER para voltar ao menu principal");
            scanner.nextLine();
        }
        opcao=exibirMenu();
}

   }

   private static void adicionarNovoProduto(){
       System.out.print("Insira o ID do produto que deseja cadastrar: ");
       var id = Integer.parseInt(scanner.nextLine());
       System.out.print("Insira o nome do produto que deseja cadastrar: ");
       var produto = scanner.nextLine();
       System.out.print("Insira o PARTNUMBER do produto que deseja cadastrar: ");
       var partNumber = scanner.nextLine();
       System.out.print("Insira a divisão do produto que deseja cadastrar: ");
       var divisao = scanner.nextLine();
       System.out.print("Insira a quantidade desse produto: ");
       var quantidade = Integer.parseInt(scanner.nextLine());

       produtoService.adicionarNovoProduto(new DadosProduto(id,produto,partNumber,divisao,quantidade));
       System.out.printf("O produto %s foi cadastado com sucesso\n",produto);
       System.out.println("Pressione ENTER para voltar ao menu principal");
       scanner.nextLine();
   }


   private static void exibirProdutosCadastrados(){
       var produtos = produtoService.exibirProdutosDoAlmoxarifado();
       produtos.forEach(System.out::println);
       System.out.println("Pressione ENTER para voltar ao menu principal");
       scanner.nextLine();
   }


   private static void adicionarQuantidadeDeUmProduto(){
       System.out.print("Digite o id do produto que deseja adicionar: ");
       var id=Integer.parseInt(scanner.nextLine());
       System.out.print("Digite a quantidade que deseja inserir desse produto: ");
       var quantidade = Integer.parseInt(scanner.nextLine());
       produtoService.adicionarQuantidadeDeUmProduto(id,quantidade);
       System.out.println("Pressione ENTER para voltar ao menu principal");
       scanner.nextLine();
   }
   private static void removerQuantidadeDeUmProduto(){
       System.out.println("Digite o id do produto que deseja retirar: ");
       var id=Integer.parseInt(scanner.nextLine());
       System.out.print("Digite a quantidade que deseja retirar desse produto: ");
       var quantidade = Integer.parseInt(scanner.nextLine());
       produtoService.removerQuantidadeDeUmProduto(id,quantidade);
       System.out.print("Pressione ENTER para voltar ao menu principal");
       scanner.nextLine();
   }

   private static void removerOProdutoDoAlmoxarifado(){
       System.out.print("Digita o ID do produto que deseja remover do almoxarifado: ");
       var id = Integer.parseInt(scanner.nextLine());
       produtoService.removerOProdutoDoAlmoxarifado(id);
       System.out.print("Pressione ENTER para voltar ao menu principal");
       scanner.nextLine();
   }
}



