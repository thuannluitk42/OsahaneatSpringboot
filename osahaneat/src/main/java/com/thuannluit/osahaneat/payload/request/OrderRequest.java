package com.thuannluit.osahaneat.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private int userId;
    private int restId;
    private int[] foodIds;
}
