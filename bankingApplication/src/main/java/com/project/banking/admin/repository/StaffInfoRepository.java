package com.project.banking.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.banking.admin.entities.StaffInfo;


public interface StaffInfoRepository extends JpaRepository<StaffInfo, Integer> {

}
