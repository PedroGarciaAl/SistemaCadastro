import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        boolean continuar = true;

        while(continuar) {
            switch (Menu.exibeMenu()) {
                case 1:
                    UsuarioFuncoes.cadastraUsuario();
                    break;
                case 2:
                    UsuarioFuncoes.listarUsuarios();
                    break;
                case 3:
                    FormularioFuncoes.adicionaPergunta();
                    break;
                case 4:
                    FormularioFuncoes.deletaPergunta();
                    break;
                case 5:
                    UsuarioFuncoes.buscaUsuario();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Digite um valor válido");
                    break;
            }
        }

    }
}