package com.wcsp.pe.mstipocambio.infrastructure.dao.repository;

import com.wcsp.pe.mstipocambio.infrastructure.dao.entity.TipoCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCambioJpa extends JpaRepository<TipoCambioEntity, Integer> {
}
