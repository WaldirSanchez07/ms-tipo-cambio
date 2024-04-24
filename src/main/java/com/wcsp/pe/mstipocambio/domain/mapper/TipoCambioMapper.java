package com.wcsp.pe.mstipocambio.domain.mapper;

import com.wcsp.pe.mstipocambio.domain.model.TipoCambio;
import com.wcsp.pe.mstipocambio.domain.dto.request.TipoCambioRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoCambioMapper {

  TipoCambioMapper INSTANCE = Mappers.getMapper(TipoCambioMapper.class);

  TipoCambio toModel(TipoCambioRequest request);

}
