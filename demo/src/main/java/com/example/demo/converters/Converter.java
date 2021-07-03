package com.example.demo.converters;

import org.apache.commons.lang.NotImplementedException;

import java.util.List;

public interface Converter<BO, DTO> {

    default DTO convertToDto(BO bo) {
        throw new NotImplementedException();
    }

    default BO convertToBo(DTO dto) {
        throw new NotImplementedException();
    }

    default List<DTO> convertToDtoList(BO bo) {
        throw new NotImplementedException();
    }

    default List<BO> convertToBoList(DTO dto) {
        throw new NotImplementedException();
    }

}
