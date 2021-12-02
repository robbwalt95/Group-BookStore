package com.example.bookStore.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.bookStore.domain.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Long> {

}
