package com.exchange.payment_methods_management.service;

import com.exchange.payment_methods_management.domain.PaymentMethod;
import com.exchange.payment_methods_management.repository.PaymentMethodRepository;
import com.exchange.payment_methods_management.util.exceptions.PaymentMethodNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentMethodCrudServiceBean implements CrudService<PaymentMethod, Long> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void update(PaymentMethod paymentMethod, Long id) {
        paymentMethodRepository.findById(id)
                .map(pm -> {
                    pm.setName(paymentMethod.getName());
                    pm.setDescription(paymentMethod.getDescription());
                    pm.setImage(paymentMethod.getImage());
                    return paymentMethodRepository.save(pm);
                })
                .orElseThrow(() -> new PaymentMethodNotFoundException("Payment method with ID: " + id + "is not found"));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new PaymentMethodNotFoundException("Payment method with ID: " + id + "is not found"));
        paymentMethodRepository.delete(paymentMethod);
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public PaymentMethod get(Long id) {
        return paymentMethodRepository.findById(id)
                .orElseThrow(() -> new PaymentMethodNotFoundException("Payment method with ID: " + id + "is not found"));
    }
}
