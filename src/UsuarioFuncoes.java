import java.io.*;
import java.util.Scanner;

public class UsuarioFuncoes {

    public static void cadastraUsuario(){
        Scanner sc = new Scanner(System.in);

        File fileFormulario = new File("arquivos/formulario.txt");
        String[] perguntas = new String[FormularioFuncoes.numeroPergunta()-1];
        String[] respostas = new String[FormularioFuncoes.numeroPergunta()-1];

        try (FileReader frFormulario = new FileReader(fileFormulario);
             BufferedReader brFormulario = new BufferedReader(frFormulario)){
                String pergunta;
                int i = 0;
                while ((pergunta = brFormulario.readLine()) != null) {
                    perguntas[i] = pergunta;
                    System.out.println(perguntas[i]);
                    String info = sc.nextLine();

                    if (i == 0) { //Verificando se é o nome
                        if (info.length() >= 10) {
                            respostas[i] = info;
                            i++;
                            continue;
                        } else
                            throw new IllegalArgumentException("Por favor, insira um nome com no mínimo 10 caracteres");
                    }

                    if (i==1){
                            
                    }

                    respostas[i] = info;
                    i++;
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Usuario usuario1 = new Usuario(respostas[0],
                respostas[1],
                Integer.parseInt(respostas[2]),
                Double.parseDouble(respostas[3]));

        File fileUsuario = new File("usuarios/"
                + numeroUsuario() + " - "
                + usuario1.getNome().toUpperCase() +
                ".txt");

        try (FileWriter fwUsuario = new FileWriter(fileUsuario);
             BufferedWriter bwUsuario = new BufferedWriter(fwUsuario)){

            if (fileUsuario.createNewFile())
                System.out.println("Usuário cadastrado com sucesso");

            for (String resposta : respostas) {
                bwUsuario.write(resposta);
                bwUsuario.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarUsuarios(){
        Scanner sc = new Scanner(System.in);
        File pastaUsuarios = new File("usuarios");
        File[] usuarios = pastaUsuarios.listFiles();

        System.out.println("\n====== Usuarios Cadastrados ======");
        for (File usuario : usuarios) {
            try (FileReader frLeitorUsuario = new FileReader(usuario);
                 BufferedReader bwLeitorUsuario = new BufferedReader(frLeitorUsuario)){
                System.out.println(bwLeitorUsuario.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("==================================");
        do {
            System.out.print("Digite 0 para voltar: ");
        } while(!sc.nextLine().equals("0"));
    }

    public static void buscaUsuario(){
        Scanner sc = new Scanner(System.in);

        File pastaUsuarios = new File("usuarios");
        File[] usuarios = pastaUsuarios.listFiles();
        String usuarioDesejado = null;

        System.out.println("Qual usuário você está buscando?");
        usuarioDesejado = sc.nextLine();

        for (File usuario : usuarios) {
            try (FileReader frLeitorUsuario = new FileReader(usuario);
                 BufferedReader bwLeitorUsuario = new BufferedReader(frLeitorUsuario)){
                String linha = null;

                if ((linha = bwLeitorUsuario.readLine()).startsWith(usuarioDesejado)){
                    System.out.println("--------------------");
                    System.out.println(linha);
                    while ((linha = bwLeitorUsuario.readLine()) != null){
                        System.out.println(linha);
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static int numeroUsuario(){
        File pastaUsuarios = new File("usuarios");
        String[] usuarios = pastaUsuarios.list();
        int numeroUsuarios = 1;

        for (String usuario : usuarios) {
            numeroUsuarios++;
        }

        return numeroUsuarios;
    }
}