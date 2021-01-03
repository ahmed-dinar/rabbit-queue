package com.bs23.rabbit.repository;

import com.bs23.rabbit.model.FundTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ahmed Dinar
 * Created 1/3/2021
 */

@Repository
public interface FundTrasnferRepository extends JpaRepository<FundTransfer, Long> {
}
