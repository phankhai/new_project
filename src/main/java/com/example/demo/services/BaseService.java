package com.example.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface BaseService<DTO, REQUEST, RESPONSE> {
    default Optional<RESPONSE> create(DTO dto){
        return Optional.empty();
    };

    default Optional<RESPONSE> update(DTO dto, UUID uuid){
        return Optional.empty();
    };

    default Optional<RESPONSE> get(UUID uuid){
        return Optional.empty();
    };

    default Page<RESPONSE> list(String search, REQUEST request, Pageable pageable){
        return Page.empty();
    };

    default void delete(UUID uuid){ };

    default void deleteRow(UUID uuid){};
}
