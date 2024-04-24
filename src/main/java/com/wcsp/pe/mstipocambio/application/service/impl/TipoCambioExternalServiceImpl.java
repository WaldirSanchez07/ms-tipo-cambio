package com.wcsp.pe.mstipocambio.application.service.impl;

import com.wcsp.pe.mstipocambio.application.service.TipoCambioExternalService;
import com.wcsp.pe.mstipocambio.domain.feign.TipoCambioFeign;
import com.wcsp.pe.mstipocambio.domain.mapper.TipoCambioMapper;
import com.wcsp.pe.mstipocambio.domain.model.TipoCambio;
import com.wcsp.pe.mstipocambio.domain.dto.request.TipoCambioRequest;
import com.wcsp.pe.mstipocambio.domain.dto.response.CustomResponse;
import com.wcsp.pe.mstipocambio.domain.dto.response.TipoCambioFeignResponse;
import com.wcsp.pe.mstipocambio.domain.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TipoCambioExternalServiceImpl implements TipoCambioExternalService {

  private final TipoCambioService tipoCambioService;
  private final TipoCambioFeign tipoCambioFeign;

  @Override
  public ResponseEntity<CustomResponse> listarCambios() {
    return ResponseEntity.ok(CustomResponse.builder()
            .datos(tipoCambioService.listarCambios())
            .estado(HttpStatus.OK.value())
            .build());
  }

  @Override
  public ResponseEntity<CustomResponse> guardarCambio(TipoCambioRequest request) {
    try {
      TipoCambioFeignResponse response = tipoCambioFeign.findTipoCambio(request.getMonedaDestino());

      if (response.getResult().equals("error")) {
        throw new RuntimeException("La moneda destino es incorrecta.");
      }

      TipoCambio tipoCambio = TipoCambioMapper.INSTANCE.toModel(request);
      tipoCambio.setTipoCambio(response.getRates().get(request.getMonedaOrigen()));
      tipoCambio.setFechaCambio(LocalDateTime.now());

      return ResponseEntity.ok(CustomResponse.builder()
              .datos(tipoCambioService.guardarCambio(tipoCambio))
              .estado(HttpStatus.OK.value())
              .build());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CustomResponse.builder()
              .estado(HttpStatus.INTERNAL_SERVER_ERROR.value())
              .mensaje("Error al consultar API. " + e.getMessage())
              .build());
    }
  }

}
