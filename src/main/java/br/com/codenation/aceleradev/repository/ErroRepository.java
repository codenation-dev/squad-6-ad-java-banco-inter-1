package br.com.codenation.aceleradev.repository;

import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.dto.ErroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ErroRepository extends JpaRepository<Erro, Long> {
    Page<Erro> findByTitulo(Pageable pageable, String titulo);

    @Query(value = "SELECT new br.com.codenation.aceleradev.dto.ErroDTO(" +
            " erro1.id," +
            " erro1.createAt," +
            " erro1.ambiente," +
            " erro1.data," +
            " erro1.detalhes," +
            " erro1.endereco," +
            " erro1.level," +
            " erro1.status," +
            " erro1.titulo," +
            " erro1.usuario.id," +
            " u.token," +
            " count(erro2.id)) " +
            " FROM Erro erro1 JOIN Erro erro2 ON erro1.titulo = erro2.titulo AND erro1.status = :status" +
            " INNER JOIN Usuario u ON u.id = erro1.usuario.id" +
            " GROUP BY erro1.id, u.token")
    Page<ErroDTO> findAllErroDTO(Pageable pageable, @Param("status") StatusEnum status);

    Page<Erro> findByLevel(Pageable pageable, LevelEnum level);

    Page<Erro> findByUsuarioId(Pageable pageable, Long usuarioId);

    @Query(value = "SELECT new br.com.codenation.aceleradev.dto.ErroDTO(" +
            " erro1.id," +
            " erro1.createAt," +
            " erro1.ambiente," +
            " erro1.data," +
            " erro1.detalhes," +
            " erro1.endereco," +
            " erro1.level," +
            " erro1.status," +
            " erro1.titulo," +
            " erro1.usuario.id," +
            " u.token," +
            " count(erro2.id)) " +
            " FROM Erro erro1 JOIN Erro erro2 ON erro1.titulo = erro2.titulo AND erro2.ambiente = :ambiente AND erro2.status = :status " +
            " INNER JOIN Usuario u ON u.id = erro1.usuario.id" +
            " GROUP BY erro1.id, u.token")
    Page<Erro> findByAmbiente(Pageable pageable, @Param("ambiente") AmbienteEnum ambienteEnum, @Param("status") StatusEnum status);

    Page<Erro> findByAmbienteAndTitulo(Pageable pageable, AmbienteEnum ambiente, String titulo);

    Page<Erro> findByAmbienteAndLevel(Pageable pageable, AmbienteEnum ambiente, LevelEnum level);

    Page<Erro> findByAmbienteAndUsuarioId(Pageable pageable, AmbienteEnum ambiente, Long usuarioId);

    Optional<Long> countDistinctByAmbienteAndLevelAndTitulo(AmbienteEnum ambiente, LevelEnum level, String titulo);
}
