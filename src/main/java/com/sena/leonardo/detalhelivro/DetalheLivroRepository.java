package com.sena.leonardo.detalhelivro;

import com.sena.leonardo.novolivro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalheLivroRepository extends JpaRepository<Livro, Long> {
}
