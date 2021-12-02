package com.example.bookStore.repositories;

import com.example.bookStore.domain.SaleRecords;
import org.springframework.data.repository.CrudRepository;

public interface SaleRecordsRepository extends CrudRepository<SaleRecords, Long> {
}
