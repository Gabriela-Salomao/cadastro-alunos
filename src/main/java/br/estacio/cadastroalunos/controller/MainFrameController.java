package br.estacio.cadastroalunos.controller;

import br.estacio.cadastroalunos.model.Client;
import br.estacio.cadastroalunos.service.MainFrameService;
import java.util.ArrayList;

/**
 *
 * @author Gabi
 */
public class MainFrameController {
    private ArrayList<Client> clientes;
    
    public MainFrameController(){
        this.clientes = new ArrayList<>();
    }
    
    public Boolean addAluno(Client client){
        boolean valid = true;
        
        for(var c : this.getAlunos()) {
            if(c.getNome().equals(client.getNome())){
                valid = false;
                break;
            }
        }
        
        if(valid) {
            MainFrameService.inserir(client);
        }
        return valid;
    }
    
    public Boolean removeAluno(Client client){
        boolean remove = this.clientes.remove(client);
        return remove;
    }
    
    public ArrayList<Client> getAlunos() {
        this.clientes = MainFrameService.getAll();
        return this.clientes;
    }
}
