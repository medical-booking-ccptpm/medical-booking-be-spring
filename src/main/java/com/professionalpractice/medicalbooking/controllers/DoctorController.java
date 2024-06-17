package com.professionalpractice.medicalbooking.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.professionalpractice.medicalbooking.config.RestApiV1;
import com.professionalpractice.medicalbooking.dtos.DoctorDTO;
import com.professionalpractice.medicalbooking.dtos.request.DoctorRequest;
import com.professionalpractice.medicalbooking.dtos.response.PaginationResponse;
import com.professionalpractice.medicalbooking.entities.common.DateAuditing;
import com.professionalpractice.medicalbooking.services.CloudinaryService;
import com.professionalpractice.medicalbooking.services.DoctorService;
import com.professionalpractice.medicalbooking.utils.CustomResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestApiV1
public class DoctorController extends DateAuditing {

    private final DoctorService doctorService;

    private final CloudinaryService cloudinaryService;

    @PostMapping("/doctors")
    public ResponseEntity<?> createDoctor(@ModelAttribute DoctorRequest doctorRequest,
            @RequestParam(value = "image", required = false) MultipartFile imageFile) {

        if (imageFile != null) {
            String imageUrl = cloudinaryService.uploadImage(imageFile);
            doctorRequest.setImageUrl(imageUrl);
        }

        DoctorDTO doctor = doctorService.createDoctor(doctorRequest);
        return CustomResponse.success(HttpStatus.CREATED, "Tạo bác sĩ mới thành công", doctor);
    }

    @GetMapping("/doctors")
    public ResponseEntity<?> getDoctors(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {
        PageRequest pageRequest = PageRequest.of(
                page - 1, limit,
                Sort.by("id").ascending());
        Page<DoctorDTO> doctorPage = doctorService.getDoctors(pageRequest);
        long totalPages = doctorPage.getTotalElements();
        List<DoctorDTO> doctors = doctorPage.getContent();
        return CustomResponse.success(new PaginationResponse(page, limit, totalPages, doctors));
    }

    @PutMapping("/doctors/{doctorId}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long doctorId,
            @ModelAttribute DoctorRequest doctorRequest,
            @RequestParam(value = "image", required = false) MultipartFile imageFile) {

        if (imageFile != null) {
            String imageUrl = cloudinaryService.uploadImage(imageFile);
            doctorRequest.setImageUrl(imageUrl);
        }

        DoctorDTO doctor = doctorService.updateDoctor(doctorId, doctorRequest);
        return CustomResponse.success("Cập nhật thành công", doctor);
    }

    @DeleteMapping("/doctors/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId) {
        doctorService.deleteDoctor(doctorId);
        return CustomResponse.success("Xóa thành công");
    }
}
