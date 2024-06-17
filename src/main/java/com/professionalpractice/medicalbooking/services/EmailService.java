package com.professionalpractice.medicalbooking.services;

import com.professionalpractice.medicalbooking.dtos.HealthFormDTO;

public interface EmailService {
    void sendMessage(String to, String subject, String content);

    void sendHealthFormConfirmation(HealthFormDTO healthFormDto);

    void sendHealthFormRejection(HealthFormDTO healthFormDto);
}
