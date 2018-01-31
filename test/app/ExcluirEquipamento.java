package app;

import java.util.List;
import java.util.Scanner;
import model.dao.EquipamentoDAO;
import model.domain.Equipamento;

/**
 *
 * @author cadilhe
 */
public class ExcluirEquipamento {

    public static void main(String[] args) {

        // cria objetos serviços
        System.out.println("Excluindo Equipamento...");
        EquipamentoDAO sdao = new EquipamentoDAO();

        Scanner entrada = new Scanner(System.in);

        System.out.println("1 - Obter a lista de serviços\n"
                + "--------------");

        List<Equipamento> equipamentos = sdao.findAll();

        System.out.println("Código - Nome do serviço");
        for (Equipamento equipamento : equipamentos) {
            System.out.println(equipamento.getId() + " - " + equipamento.getNome());
        }

        System.out.println("2 - Excluir serviço por ID\n"
                + "--------------");
        System.out.println("Id do serviço a ser excluido: ");
        Long codigo = entrada.nextLong();

        sdao.removeById(codigo);

        System.out.println("Nova Listagem:");
        List<Equipamento> equipamentos1 = sdao.findAll();
        System.out.println("Código - Nome do serviço");
        for (Equipamento equipamento : equipamentos1) {
            System.out.println(equipamento.getId() + " - " + equipamento.getNome());
        }
    }

}
