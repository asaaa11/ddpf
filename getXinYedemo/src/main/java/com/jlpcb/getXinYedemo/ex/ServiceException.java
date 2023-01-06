package com.jlpcb.getXinYedemo.ex;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private Integer state;

    public ServiceException(Integer state, String message) {
        super(message);
        this.state = state;
    }

}
