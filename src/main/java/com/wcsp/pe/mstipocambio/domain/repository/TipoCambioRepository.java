package com.wcsp.pe.mstipocambio.domain.repository;

import com.wcsp.pe.mstipocambio.domain.model.TipoCambio;

import java.util.List;

public interface TipoCambioRepository {

  List<TipoCambio> listarCambios();
  TipoCambio guardarCambio(TipoCambio tipoCambio);

}
