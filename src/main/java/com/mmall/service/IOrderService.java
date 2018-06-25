package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * @Author: Geekerstar(jikewenku.com)
 * @Date: 2018/6/25 9:51
 * @Description:
 */
public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId, String path);

}
