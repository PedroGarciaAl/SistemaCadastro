import java.util.Scanner;

public class Menu {
    public static int exibeMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========= Menu Principal =========\n" +
                "1 - Cadastrar novo usuário\n" +
                "2 - Listar usuários cadastrados\n" +
                "3 - Cadastrar nova pergunta do formulário\n" +
                "4 - Deletar pergunta do formulário\n" +
                "5 - Pesquisar usuário pelo nome\n" +
                "0 - Sair\n" +
                "==================================");
        return sc.nextInt();
    }

}
