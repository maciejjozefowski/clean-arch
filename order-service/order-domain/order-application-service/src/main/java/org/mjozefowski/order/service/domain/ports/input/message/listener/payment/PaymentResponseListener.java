package org.mjozefowski.order.service.domain.ports.input.message.listener.payment;

import org.mjozefowski.order.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseListener {
    void paymentCompleted(PaymentResponse paymentResponse);
    void paymentCancelled(PaymentResponse paymentResponse);
}
