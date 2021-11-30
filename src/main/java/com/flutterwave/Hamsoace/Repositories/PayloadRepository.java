package com.flutterwave.Hamsoace.Repositories;

import com.flutterwave.Hamsoace.models.Payload;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PayloadRepository extends CrudRepository<Payload, UUID> {
    Payload findByRef(String fromString);
}
