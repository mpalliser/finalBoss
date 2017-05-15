package org.foobarspam.cotxox;

import org.foobarspam.cotxox.domain.Conductor;
import org.foobarspam.cotxox.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by palliser on 15/05/2017.
 */
@Component
public class DataLoader {

    private ConductorRepository poolConductores;

    @Autowired
    public DataLoader(ConductorRepository poolConductores) {
        this.poolConductores = poolConductores;
    }

    @PostConstruct
    private void loadData() {
        poolConductores.deleteAll();
        poolConductores.save(new Conductor("Samantha", "4ABC123", "Chevy Malibu"));
        poolConductores.save(new Conductor("Fox", "SDHJ44", "Toyota Prius"));
        poolConductores.save(new Conductor("Mola", "7JKK555", "Mercedes A"));

    }
}
