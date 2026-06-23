package br.edu.ifsc.pps.gv;

import br.edu.ifsc.pps.gv.entities.DbEntity;
import br.edu.ifsc.pps.gv.entities.Flight;
import br.edu.ifsc.pps.gv.exceptions.InvalidEntityException;
import br.edu.ifsc.pps.gv.facade.FlightFacade;
import br.edu.ifsc.pps.gv.observers.EntityObserver;

public class Program {

    public static void main(String[] args) throws InvalidEntityException {
        FlightFacade facade = new FlightFacade();

        facade.addObserver(new EntityObserver() {
            @Override
            public void onBeforeInsert(DbEntity entity) {
                System.out.println("Alerta: Uma entidade está prestes a ser salva. ID atual: " + entity.getId());
            }

            @Override
            public void onAfterInsert(DbEntity entity) {
                System.out.println("Sucesso: Entidade salva no banco de dados! Novo ID gerado: " + entity.getId());
            }
        });

        Flight flight = new Flight.Builder()
                .withNumber("G3 1500")
                .withCompany("GOL")
                .withFrom("Guarulhos (GRU)")
                .withTo("Navegantes (NVT)")
                .withCapacity(180)
                .build();

        facade.insert(flight);
    }
}
