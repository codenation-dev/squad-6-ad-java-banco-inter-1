package br.com.codenation.aceleradev.repository;

import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.dto.ErroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ErroRepository extends JpaRepository<Erro, Long>{
    @Query(value = " SELECT erro1.id AS id," +
            " erro1.create_at AS createdAt," +
            " erro1.ambiente AS ambiente," +
            " erro1.data AS data," +
            " erro1.detalhes AS detalhes," +
            " erro1.endereco AS endereco," +
            " erro1.level AS level," +
            " erro1.status AS status," +
            " erro1.titulo AS titulo," +
            " erro1.usuario_id AS usuarioId," +
            " frequencia FROM ERRO erro1" +
            " INNER JOIN (SELECT COUNT(e.id) AS frequencia, e.titulo FROM ERRO e GROUP BY e.titulo) erro2" +
            " ON erro1.titulo = erro2.titulo"
            , nativeQuery = true)
    Page<ErroDTO> findAllErroDTO(Pageable pageable);

    Page<Erro> findByTitulo(Pageable pageable, String titulo);

    Page<Erro> findByLevel(Pageable pageable, LevelEnum level);

    Page<Erro> findByUsuarioId(Pageable pageable, Long usuarioId);

    Page<Erro> findByAmbiente(Pageable pageable, AmbienteEnum ambienteEnum);

    Page<Erro> findByAmbienteAndTitulo(Pageable pageable, AmbienteEnum ambiente, String titulo);

    Page<Erro> findByAmbienteAndLevel(Pageable pageable, AmbienteEnum ambiente, LevelEnum level);

    Page<Erro> findByAmbienteAndUsuarioId(Pageable pageable, AmbienteEnum ambiente, Long usuarioId);

    Optional<Long> countDistinctByAmbienteAndLevelAndTitulo(AmbienteEnum ambiente, LevelEnum level, String titulo);
}
