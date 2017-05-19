package org.foobarspam.cotxox.repository;

import org.foobarspam.cotxox.domain.Conductor;
import org.foobarspam.cotxox.domain.Valoracion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by palliser on 18/05/2017.
 */
public interface ValoracionRepository extends CrudRepository<Valoracion, Long> {


	List<Valoracion> findAllByConductor_Id(Integer id);


	Valoracion findFirstByConductor(Conductor c);

}
