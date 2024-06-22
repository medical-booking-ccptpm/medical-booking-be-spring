package com.professionalpractice.medicalbooking.repositories;

import com.professionalpractice.medicalbooking.entities.Department;
import com.professionalpractice.medicalbooking.entities.Shift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {

    @Query("SELECT u FROM Shift u")
    Page<Shift> queryShift(Pageable pageable);
}
