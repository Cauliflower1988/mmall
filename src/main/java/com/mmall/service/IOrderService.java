package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

/**
 * @Author: Geekerstar(jikewenku.com)
 * @Date: 2018/6/25 9:51
 * @Description:
 */
public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    ServerResponse createOrder(Integer userId, Integer shippingId);
}
