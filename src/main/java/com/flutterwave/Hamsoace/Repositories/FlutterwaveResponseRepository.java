package com.flutterwave.Hamsoace.Repositories;

import com.flutterwave.Hamsoace.models.FlutterwaveResponse;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface FlutterwaveResponseRepository extends CrudRepository<FlutterwaveResponse, UUID> {
}
