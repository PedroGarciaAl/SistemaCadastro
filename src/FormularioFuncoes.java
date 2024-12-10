import java.io.*;
import java.util.Scanner;

public class FormularioFuncoes {

    public static void adicionaPergunta(){
        File formulario = new File("arquivos/formulario.txt");
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual pergunta gostaria de adicionar?");
        String pergunta = sc.nextLine();

        try (FileWriter fwFormulario = new FileWriter(formulario, true);
             BufferedWriter bwFormulario = new BufferedWriter(fwFormulario)){
            bwFormulario.write(numeroPergunta() + " - " + pergunta);
            bwFormulario.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deletaPergunta() {
        Scanner sc = new Scanner(System.in);
        File formularioAntigo = new File("arquivos/formulario.txt");
        File formularioNovo = new File("arquivos/FormularioNovo.txt");

        int opcao;

        do {
            System.out.print("Digite o número da pergunta que deseja deletar:");
            opcao = sc.nextInt();
        } while ( opcao <= 4);


        // MUDAR DEPOIS:
        // SE TIVER MAIS DE 2 DIGITOS DE PERGUNTAS ELE NÃO RECONHECE POR SÓ PEGAR O CHAR NA PRIMEIRA POSIÇÃO

        try (FileReader frFormularioAntigo = new FileReader(formularioAntigo);
             BufferedReader brFormularioAntigo = new BufferedReader(frFormularioAntigo);
             FileWriter frFormularioNovo = new FileWriter(formularioNovo);
             BufferedWriter bwFormularioNovo = new BufferedWriter(frFormularioNovo)) {

            formularioNovo.createNewFile();

            String linha = null;
            while ((linha = brFormularioAntigo.readLine()) != null){
                if (!linha.startsWith(opcao + " -")){
                    bwFormularioNovo.write(linha);
                    bwFormularioNovo.newLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        formularioAntigo.delete();
        formularioNovo.renameTo(formularioAntigo);
    }

    public static int numeroPergunta(){
        File formulario = new File("arquivos/formulario.txt");
        int numPergunta = 1;

        try (FileReader frFormulario = new FileReader(formulario);
             BufferedReader brFormulario = new BufferedReader(frFormulario)){
            while (brFormulario.readLine() != null){
                numPergunta++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return numPergunta;
    }
}
