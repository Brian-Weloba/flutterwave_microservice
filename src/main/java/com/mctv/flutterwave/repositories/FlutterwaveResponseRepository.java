package com.mctv.flutterwave.repositories;

import com.mctv.flutterwave.models.FlutterwaveResponse;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

/**
 * The interface Flutterwave response repository. Creates a persistence layer for the FlutterwaveResponse model.
 */
public interface FlutterwaveResponseRepository extends CrudRepository<FlutterwaveResponse, UUID> {
}
