/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;
import model.dao.EquipamentoDAO;
import model.domain.Equipamento;

/**
 *
 * @author sigaln
 */
public class BuscarPorID {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        EquipamentoDAO sdao = new EquipamentoDAO();

        System.out.println("Encontrando o Equipamento por Id\n"
                + "---------------------------");

        System.out.print("Digite o número do código: ");
        Long codigo = entrada.nextLong();

        Equipamento servico = sdao.getById(codigo);

        System.out.println("Equipamento de Código: " + servico.getId() + "\nNome: " + servico.getNome());

    }

}
