package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2990.entities.Empregado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
    @Query(nativeQuery = true, value = "SELECT empregados.cpf, empregados.nome, departamento.dnome "
            + "FROM empregados "
            + "INNER JOIN departamentos ON empregados.dnumero = departamentos.dnumero "
            + "LEFT JOIN trabalha ON trabalha.cpf_emp = empregado.cpf "
            + "WHERE trabalha.cpf_emp IS NULL "
            + "ORDER BY empregados.cpf")
    List<EmpregadoDeptProjection> search1();

   @Query(value = "SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO(obj.cpf, obj.nome, obj.departamento.dnome "
            + "FROM Empregado obj "
            + "INNER JOIN departamentos ON empregados.dnumero = departamentos.dnumero "
            + "LEFT JOIN trabalha ON trabalha.cpf_emp = empregado.cpf "
            + "WHERE trabalha.cpf_emp IS NULL "
            + "ORDER BY empregados.cpf")
    List<EmpregadoDeptDTO> search2();

}
