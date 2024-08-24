import model.Pessoas;
import dao.PessoasDao;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    boolean verifica = true;
    Scanner scanner = new Scanner(System.in);
    PessoasDao dao = new PessoasDao();
    while (verifica){
      System.out.println("1 - Cadastrar pessoa");
      System.out.println("2 - Listar pessoas");
      System.out.println("3 - Deletar pessoa");
      System.out.println("4 - Sair");
      int opcao = scanner.nextInt();

      switch (opcao){
        case 1:
          System.out.println("Digite o nome: ");
          String nome = scanner.next();
          System.out.println("Digite o email: ");
          String email = scanner.next();
          Pessoas pessoa = new Pessoas(nome, email);
          if(dao.salvar(pessoa)){
            System.out.println("Pessoa cadastrada com sucesso"); 
          }
          else{
            System.out.println("Falha ao cadastrar pessoa");
          }
          break;
        case 2:
          dao.ListarPessoas();
          break;
        case 3:
          System.out.println("Digite o email da pessoa que deseja deletar: ");
          String emailDeletar = scanner.next();
          if(dao.deletar(emailDeletar)){
            System.out.println("Pessoa deletada com sucesso");
          }
          else{
            System.out.println("Falha ao deletar pessoa");
          }
          break;
        case 4: 
          verifica = false;
      }
    }
    
  }
}