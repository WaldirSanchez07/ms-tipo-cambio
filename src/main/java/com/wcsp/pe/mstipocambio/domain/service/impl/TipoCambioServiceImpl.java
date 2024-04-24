package com.wcsp.pe.mstipocambio.domain.service.impl;

import com.wcsp.pe.mstipocambio.domain.model.TipoCambio;
import com.wcsp.pe.mstipocambio.domain.repository.TipoCambioRepository;
import com.wcsp.pe.mstipocambio.domain.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoCambioServiceImpl implements TipoCambioService {

  private final TipoCambioRepository tipoCambioRepository;

  @Override
  public List<TipoCambio> listarCambios() {
    return tipoCambioRepository.listarCambios();
  }

  @Override
  public TipoCambio guardarCambio(TipoCambio tipoCambio) {
    return tipoCambioRepository.guardarCambio(tipoCambio);
  }

}
