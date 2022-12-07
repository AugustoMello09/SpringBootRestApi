package io.github.AugustoMello09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.AugustoMello09.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}
