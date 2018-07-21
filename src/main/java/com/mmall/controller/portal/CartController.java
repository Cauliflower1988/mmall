package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICartService;
import com.mmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: Geekerstar(jikewenku.com)
 * @Date: 2018/6/24 8:46
 * @Description:
 */
@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private ICartService iCartService;


    /*
     * @Description: 添加到购物车
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 20:39
     * @param: [session, count, productId]
     * @return: com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
     */
    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse<CartVo> add(HttpSession session, Integer count, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.add(user.getId(), productId, count);
    }

    /*
     * @Description: 更新购物车(用加号减号改变购物车数量)
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 20:41
     * @param: [session, count, productId]
     * @return: com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
     */
    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse<CartVo> update(HttpSession session, Integer count, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.update(user.getId(), productId, count);
    }

    /*
     * @Description: 购物车中删除产品
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 20:46   
     * @param: [session, productIds]
     * @return: com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
     */
    @RequestMapping("delete_product.do")
    @ResponseBody
    public ServerResponse<CartVo> deleteProduct(HttpSession session, String productIds) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.deleteProduct(user.getId(), productIds);
    }

    /*
     * @Description: 查询
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 20:19
     * @param: [session]
     * @return: com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<CartVo> list(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.list(user.getId());
    }

    /*
     * @Description: 全选
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 20:51   
     * @param: [session]
     * @return: com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
     */
    @RequestMapping("select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> selectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), null, Const.Cart.CHECKED);
    }

    /*
     * @Description: 全反选
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 20:51   
     * @param: [session]
     * @return: com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
     */
    @RequestMapping("un_select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), null, Const.Cart.UN_CHECKED);
    }

    /*
     * @Description: 单独选
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 20:51
     * @param: [session, productId]
     * @return: com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
     */
    @RequestMapping("select.do")
    @ResponseBody
    public ServerResponse<CartVo> select(HttpSession session, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), productId, Const.Cart.CHECKED);
    }


    /*
     * @Description: 单独反选
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 20:52   
     * @param: [session, productId]
     * @return: com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
     */
    @RequestMapping("un_select.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelect(HttpSession session, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), productId, Const.Cart.UN_CHECKED);
    }

    /*
     * @Description: 获取购物车中产品数量：查询当前用户的购物车里面的产品数量,如果一个产品有10个,
     *               那么数量就是10.不安商品种类算，按数量算，这是电商的通用做法
     *
     * @auther: Geekerstar(jikewenku.com)
     * @date: 2018/7/21 20:52
     * @param: [session]
     * @return: com.mmall.common.ServerResponse<java.lang.Integer>
     */
    @RequestMapping("get_cart_product_count.do")
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getId());
    }
}
