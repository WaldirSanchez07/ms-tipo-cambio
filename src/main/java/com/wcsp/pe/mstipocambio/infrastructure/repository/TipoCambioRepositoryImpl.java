package com.wcsp.pe.mstipocambio.infrastructure.repository;

import com.wcsp.pe.mstipocambio.domain.model.TipoCambio;
import com.wcsp.pe.mstipocambio.domain.repository.TipoCambioRepository;
import com.wcsp.pe.mstipocambio.infrastructure.dao.repository.TipoCambioJpa;
import com.wcsp.pe.mstipocambio.infrastructure.mapper.TipoCambioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TipoCambioRepositoryImpl implements TipoCambioRepository {

  private final TipoCambioJpa tipoCambioJpa;

  @Override
  public List<TipoCambio> listarCambios() {
    return tipoCambioJpa.findAll().stream()
            .map(TipoCambioMapper.INSTANCE::toModel).toList();
  }

  @Override
  public TipoCambio guardarCambio(TipoCambio tipoCambio) {
    return TipoCambioMapper.INSTANCE.toModel(tipoCambioJpa
            .save(TipoCambioMapper.INSTANCE.toEntity(tipoCambio)));
  }

}
