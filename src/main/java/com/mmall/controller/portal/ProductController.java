package com.mmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.service.IProductService;
import com.mmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Geekerstar(jikewenku.com)
 * @Date: 2018/6/23 17:18
 * @Description:
 */
@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    /*
     * @Description: 商品详情
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 17:19
     * @param: [productId]
     * @return: com.mmall.common.ServerResponse<com.mmall.vo.ProductDetailVo>
     */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    /*
     * @Description: 商品列表
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 17:19
     * @param: [keyword, categoryId, pageNum, pageSize, orderBy]
     * @return: com.mmall.common.ServerResponse<com.github.pagehelper.PageInfo>
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        return iProductService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }

}

