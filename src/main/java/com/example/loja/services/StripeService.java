package com.example.loja.services;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class StripeService {
    @Value("${stripe.api.key}")
    private String stripeApiKey;
    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeApiKey;
    }
    public PaymentIntent createPaymentIntent(long amountInCents, String currency) throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(amountInCents)
                        .setCurrency(currency)
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();
        return PaymentIntent.create(params);
    }
}
