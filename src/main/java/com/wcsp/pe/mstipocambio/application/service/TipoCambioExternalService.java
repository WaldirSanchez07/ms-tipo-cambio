package com.wcsp.pe.mstipocambio.application.service;

import com.wcsp.pe.mstipocambio.domain.dto.request.TipoCambioRequest;
import com.wcsp.pe.mstipocambio.domain.dto.response.CustomResponse;
import org.springframework.http.ResponseEntity;

public interface TipoCambioExternalService {

  ResponseEntity<CustomResponse> listarCambios();
  ResponseEntity<CustomResponse> guardarCambio(TipoCambioRequest request);

}
