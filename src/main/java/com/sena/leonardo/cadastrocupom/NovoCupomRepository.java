package com.sena.leonardo.cadastrocupom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovoCupomRepository extends JpaRepository<Cupom, Long> {
}
