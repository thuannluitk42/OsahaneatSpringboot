package com.thuannluit.osahaneat.service.imp;

import com.thuannluit.osahaneat.payload.request.OrderRequest;

public interface OrderServiceImp {
    boolean insertOrder(OrderRequest orderRequest);
}
