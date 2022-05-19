package com.albiscomglobal.inventorysystem.repository;

import com.albiscomglobal.inventorysystem.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository  extends JpaRepository<Brand, Long> {

}
