package com.silo.backend.command.domain.service;

import org.springframework.stereotype.Service;

import com.structurizr.Workspace;
import com.structurizr.model.Container;
import com.structurizr.model.Model;
import com.structurizr.model.Person;
import com.structurizr.model.SoftwareSystem;

@Service
public class WorkspaceService {

    public void generate() {
        Workspace workspace = new Workspace("AKBANK IT", "AKBANK Bankacılık Sistemi");
        workspace.addProperty("structurizr.groupSeparator", "/");
        Model model = workspace.getModel();

        /* Add Actor */
        Person customer = model.addPerson("Banka Müşterisi", "Bankacılık işlemlerini gerçekleştiren banka müşterisi");
        Person person = model.addPerson("Banka Personeli", "Bankacılık işlemlerini gerçekleştiren banka personeli");

        /* Add System */
        SoftwareSystem branchSoftwareSystem = model.addSoftwareSystem("Şube Sistemi", "Şube bankacılık işlemi");
        Container app = branchSoftwareSystem.addContainer(null, null, null);
        app.addComponent(null, null, null);
    
        SoftwareSystem atmSoftwareSystem = model.addSoftwareSystem("ATM Sistemi", "ATM bankacılık işlemleri");
        SoftwareSystem internetSoftwareSystem = model.addSoftwareSystem("İnternet Bankacılığı Sistemi",
                "İnternet bankacılığı işlemleri");
        SoftwareSystem mobileSoftwareSystem = model.addSoftwareSystem("Mobil Bankacılık Sistemi",
                "Mobil bankacılık işlemleri");
        SoftwareSystem callcenterSoftwareSystem = model.addSoftwareSystem("Çağrı Merkezi Sistemi",
                "Çağrı merkezi işlemleri");
        SoftwareSystem openBankingSoftwareSystem = model.addSoftwareSystem("Açık Bankacılık Sistemi",
                "Açık bankacılık işlemleri");

               

        // Upload to a Structurizr on-premises installation
        // WorkspaceApiClient client = new
        // WorkspaceApiClient("http://localhost:8080/api", "key", "secret");
        // client.putWorkspace(id, workspace);

        // Export to a JSON file
        // WorkspaceUtils.saveWorkspaceToJson(workspace, new File("workspace.json"));
    }
 
}
