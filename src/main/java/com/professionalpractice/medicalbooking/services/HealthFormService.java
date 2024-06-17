package com.professionalpractice.medicalbooking.services;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.professionalpractice.medicalbooking.dtos.HealthFormDTO;
import com.professionalpractice.medicalbooking.dtos.request.HealthFormRequest;

import java.io.IOException;

public interface HealthFormService {

    HealthFormDTO createHealthForm(HealthFormRequest healthFormRequest);

    Page<HealthFormDTO> getHealthFormByUserId(Long userId, PageRequest pageRequest);

    Page<HealthFormDTO> getHealthForms(PageRequest pageRequest);

    HealthFormDTO updateHealthForm(Long healthFormId, HealthFormRequest healthFormRequest);

    void deleteHealthFormById(Long healthFormId);

    Page<HealthFormDTO> getHistory(String userEmail, Integer status, PageRequest pageRequest);

    Page<HealthFormDTO> getHealthFormsByStatus(Integer status, PageRequest pageRequest);

    HealthFormDTO updateStatusOfHealthForm(Long heathFormId, HealthFormRequest healthFormRequest);

    Page<HealthFormDTO> queryHealthForms(HealthFormRequest healthFormRequest, PageRequest pageRequest);

    void exportHealthForm(HttpServletResponse response) throws IOException;
    void createCell(Row row, int columnCount, Object value, CellStyle style);
}
