package com.professionalpractice.medicalbooking.repositories;

import com.professionalpractice.medicalbooking.entities.Doctor;
import com.professionalpractice.medicalbooking.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT u FROM Doctor u")
    Page<Doctor> queryDoctors(Pageable pageable);
}
