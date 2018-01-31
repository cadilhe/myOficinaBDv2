/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;
import model.dao.ClienteDAO;
import model.dao.EquipamentoDAO;
import model.domain.Cliente;
import model.domain.Equipamento;

/**
 *
 * @author cadilhe
 */
public class BuscarPorID {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        EquipamentoDAO edao = new EquipamentoDAO();
        ClienteDAO cdao = new ClienteDAO();

        System.out.println("Encontrando os objetos por Id\n"
                + "---------------------------");

        System.out.print("Digite o número do código do cliente: ");
        Long codigoCliente = entrada.nextLong();

        Cliente cliente = cdao.getById(codigoCliente);

        System.out.println("Código do cliente: " + cliente.getId() + "\nNome: " + cliente.getNome());

        System.out.print("Digite o número do código do equipamento: ");
        Long codigo = entrada.nextLong();

        Equipamento equipamento = edao.getById(codigo);

        System.out.println("Equipamento de Código: " + equipamento.getId() + "\nNome: " + equipamento.getNome());

    }
}
