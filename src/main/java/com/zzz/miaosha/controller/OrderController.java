package com.zzz.miaosha.controller;

import com.zzz.miaosha.domain.MiaoshaUser;
import com.zzz.miaosha.domain.OrderInfo;
import com.zzz.miaosha.redis.RedisService;
import com.zzz.miaosha.result.CodeMsg;
import com.zzz.miaosha.result.Result;
import com.zzz.miaosha.service.GoodsService;
import com.zzz.miaosha.service.MiaoshaUserService;
import com.zzz.miaosha.service.OrderService;
import com.zzz.miaosha.vo.GoodsVo;
import com.zzz.miaosha.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	MiaoshaUserService userService;
	
	@Autowired
	RedisService redisService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	GoodsService goodsService;
	
    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(MiaoshaUser user, @RequestParam("orderId") long orderId) {
    	if(user == null) {
    		return Result.error(CodeMsg.SESSION_ERROR);
    	}
    	OrderInfo order = orderService.getOrderById(orderId);
    	if(order == null) {
    		return Result.error(CodeMsg.ORDER_NOT_EXIST);
    	}
    	long goodsId = order.getGoodsId();
    	GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
    	OrderDetailVo vo = new OrderDetailVo();
    	vo.setOrder(order);
    	vo.setGoods(goods);
    	return Result.success(vo);
    }
}
