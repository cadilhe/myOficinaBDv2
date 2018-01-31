package app;

import java.util.Scanner;
import model.dao.EquipamentoDAO;
import model.domain.Equipamento;

/**
 *
 * @author cadilhe
 */
public class NovoEquipamento {

    public static void main(String[] args) {

        // cria objetos equipamento
        System.out.println("Criando objetos da Entidade Equipamento...");

        Scanner entrada = new Scanner(System.in);
        Equipamento e1 = new Equipamento();

        System.out.println("Digite o nome do equipamento: ");
        String nome = entrada.next();
        e1.getNome();

        EquipamentoDAO edao = new EquipamentoDAO();
        edao.salvarAtualizar(e1);

        System.out.println("Novo equipamento adicionado: \n"
                + "Código: " + e1.getId() + "\nNome: " + e1.getNome());

    }

}
