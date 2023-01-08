package com.exchange.market.service.validation;

import com.exchange.market.domain.BuyAdvert;
import com.exchange.market.util.configuration.MarketConfig;
import com.exchange.market.util.exceptions.ClientIsNotVerifiedException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuyAdvertValidationServiceBean implements AdvertValidationService<BuyAdvert> {

    private final MarketConfig marketConfig;

    @Override
    public void validate(BuyAdvert advert) {
        validateVerification(advert.getClientEmail());
    }

    private void validateVerification(String email) {
        String uri = marketConfig.isVerifiedClient();
        boolean verification = Boolean.TRUE.equals(
                marketConfig.restTemplate().getForObject(uri, boolean.class, email)
        );
        if (!verification) throw new ClientIsNotVerifiedException("Client with email: " + email + "is not verified");
    }

}
