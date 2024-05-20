package br.com.richard.aprendizadographql.respository;

import br.com.richard.aprendizadographql.entity.TipoContaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContaRepository extends CrudRepository<TipoContaEntity, Long> {
}
