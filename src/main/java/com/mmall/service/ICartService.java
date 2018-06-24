package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 * @Author: Geekerstar(jikewenku.com)
 * @Date: 2018/6/24 8:48
 * @Description:
 */
public interface ICartService {

    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
}
