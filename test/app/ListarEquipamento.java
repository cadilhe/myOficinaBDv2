/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import model.dao.EquipamentoDAO;
import model.domain.Equipamento;

/**
 *
 * @author sigaln
 */
public class ListarEquipamento {

    public static void main(String[] args) {

        EquipamentoDAO sdao = new EquipamentoDAO();
        
        List<Equipamento> equipamentos = sdao.findAll();
        
        System.out.println("Lista de equipamentos\n"
                + "--------------------------------------");
        System.out.println("Código - Nome do equipamento");
        for(Equipamento equipamento : equipamentos) {
            System.out.println(equipamento.getId() + " - " + equipamento.getNome());
        }
    }

}
