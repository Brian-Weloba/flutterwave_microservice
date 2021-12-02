package com.mctv.flutterwave.repositories;

import com.mctv.flutterwave.models.Payload;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * The interface Payload repository. Creates a persistence layer for the Payload model.
 */
public interface PayloadRepository extends CrudRepository<Payload, UUID> {
    /**
     * @param fromString The UUID of the Payload to be retrieved.
     * @return The Payload with the given UUID.
     */
    Payload findByRef(String fromString);
}
