package com.wcsp.pe.mstipocambio.infrastructure.mapper;

import com.wcsp.pe.mstipocambio.domain.model.TipoCambio;
import com.wcsp.pe.mstipocambio.infrastructure.dao.entity.TipoCambioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoCambioMapper {

  TipoCambioMapper INSTANCE = Mappers.getMapper(TipoCambioMapper.class);

  default TipoCambio toModel(TipoCambioEntity entity) {
   return TipoCambio.builder()
           .monto(entity.getMonto())
           .montoTipoCambio(entity.getMonto() * entity.getTipoCambio())
           .monedaOrigen(entity.getMonedaOrigen())
           .monedaDestino(entity.getMonedaDestino())
           .tipoCambio(entity.getTipoCambio())
           .fechaCambio(entity.getFechaCambio())
           .build();
  }

  TipoCambioEntity toEntity(TipoCambio tipoCambio);

}
