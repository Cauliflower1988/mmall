package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * @Author: Geekerstar(jikewenku.com)
 * @Date: 2018/6/23 11:11
 * @Description:
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId,String categoryName);
}
