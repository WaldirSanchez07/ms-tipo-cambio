package com.wcsp.pe.mstipocambio.infrastructure.rest;

import com.wcsp.pe.mstipocambio.application.service.TipoCambioExternalService;
import com.wcsp.pe.mstipocambio.domain.dto.request.TipoCambioRequest;
import com.wcsp.pe.mstipocambio.domain.dto.response.CustomResponse;
import com.wcsp.pe.mstipocambio.infrastructure.security.JwtProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/tipo-cambio")
public class TipoCambioApiRest {

  private final TipoCambioExternalService tipoCambioService;
  private final JwtProvider jwtProvider;

  @GetMapping(value = "listar")
  public ResponseEntity<CustomResponse> listarCambios() {
    return tipoCambioService.listarCambios();
  }

  @PostMapping(value = "calcular")
  public ResponseEntity<CustomResponse> calcularTipoCambio(
          @RequestBody @Valid TipoCambioRequest request,
          @RequestHeader("Authorization") String authorization) {
    if (jwtProvider.validarToken(authorization)) {
      return tipoCambioService.guardarCambio(request);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(CustomResponse.builder()
              .datos("Token inválido.")
              .estado(HttpStatus.UNAUTHORIZED.value())
              .build());
    }
  }

  @PostMapping(value = "generar-token")
  public ResponseEntity<CustomResponse> generarToken() {
    return ResponseEntity.ok(CustomResponse.builder()
            .datos(jwtProvider.generarToken())
            .estado(HttpStatus.OK.value())
            .build());
  }

}
