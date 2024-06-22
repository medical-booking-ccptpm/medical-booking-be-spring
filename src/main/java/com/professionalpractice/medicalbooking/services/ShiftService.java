package com.professionalpractice.medicalbooking.services;

import com.professionalpractice.medicalbooking.dtos.ShiftDTO;
import com.professionalpractice.medicalbooking.dtos.request.ShiftRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ShiftService {

    ShiftDTO createShift(ShiftRequest shiftRequest);

    ShiftDTO getShiftById(Long shiftId);

    Page<ShiftDTO> getShifts(PageRequest pageRequest);

    ShiftDTO updateShift(Long shiftId, ShiftRequest shiftRequest);

    void deleteShiftById(Long shiftId);
}
