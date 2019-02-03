/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Elvis Nogueira
 */
public class ConnectionFactory {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");

    public EntityManager getConnetion() {
        return emf.createEntityManager();
    }

}
