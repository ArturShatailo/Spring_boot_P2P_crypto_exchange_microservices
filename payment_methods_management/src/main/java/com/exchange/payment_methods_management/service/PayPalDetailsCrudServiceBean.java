package com.exchange.payment_methods_management.service;

import com.exchange.payment_methods_management.domain.PayPalDetails;
import com.exchange.payment_methods_management.repository.PayPalDetailsRepository;
import com.exchange.payment_methods_management.util.exceptions.PayPalDetailsNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayPalDetailsCrudServiceBean implements DetailsCrudService<PayPalDetails, Long>{

    private final PayPalDetailsRepository payPalDetailsRepository;

    @Override
    public void add(PayPalDetails payPalDetails) {
        payPalDetailsRepository.save(payPalDetails);
    }

    @Override
    public void update(PayPalDetails payPalDetails, Long id) {
        payPalDetailsRepository.findPayPalDetailsByIdAndClientEmail(id, payPalDetails.getClientEmail())
                .map(ppd ->{
                    ppd.setName(payPalDetails.getName());
                    ppd.setEmail(payPalDetails.getEmail());
                    ppd.setSurname(payPalDetails.getSurname());
                    return payPalDetailsRepository.save(ppd);
                })
                .orElseThrow(() -> new PayPalDetailsNotFoundException("Can't find PayPal details with email: " + payPalDetails.getClientEmail() + " and id: " + id));
    }

    @Override
    public void delete(Long id, String email) {
        payPalDetailsRepository.findPayPalDetailsByIdAndClientEmail(id, email)
                .map(ppd -> {
                    ppd.setDeleted(true);
                    return payPalDetailsRepository.save(ppd);
                });
    }

    @Override
    public PayPalDetails get(Long id, String email) {
        return payPalDetailsRepository.findPayPalDetailsByIdAndClientEmail(id, email)
                .orElseThrow(() -> new PayPalDetailsNotFoundException("Can't find PayPal details with email: " + email + " and id: " + id));
    }

}
