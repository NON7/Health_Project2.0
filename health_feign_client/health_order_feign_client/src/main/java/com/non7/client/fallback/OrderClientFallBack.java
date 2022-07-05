package com.non7.client.fallback;

import com.non7.client.order.OrderClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderClientFallBack implements FallbackFactory<OrderClient> {



    @Override
    public OrderClient create(Throwable cause) {
        return null;
    }
}
