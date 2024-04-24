package com.wcsp.pe.mstipocambio.domain.service;

import com.wcsp.pe.mstipocambio.domain.model.TipoCambio;

import java.util.List;

public interface TipoCambioService {

  List<TipoCambio> listarCambios();
  TipoCambio guardarCambio(TipoCambio tipoCambio);

}
