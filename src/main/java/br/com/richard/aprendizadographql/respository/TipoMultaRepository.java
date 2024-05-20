package br.com.richard.aprendizadographql.respository;

import br.com.richard.aprendizadographql.entity.TipoMultaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoMultaRepository extends CrudRepository<TipoMultaEntity, Long> {

    List<TipoMultaEntity> findAllByAtivo(boolean ativo);

}
