package com.inspur.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inspur.system.page.PO.PageRequest;
import com.inspur.system.page.PO.PageResult;
import com.inspur.system.page.utils.PageUtils;
import com.inspur.goods.DO.Goods;
import com.inspur.goods.DO.GoodsQueryModel;
import com.inspur.goods.dao.GoodsMapper;
import com.inspur.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhuanghuan
 * Date: 2020/2/15   16:31
 * Description:
 */
@Service
@CacheConfig(cacheNames = "goods")
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    @CachePut(key = "#goods.id")
    public void save(Goods goods) {
        if (goods.getId() == null || goods.getId().equals("")) {
            goods.setId(UUID.randomUUID().toString());
            goodsMapper.insertSelective(goods);
        } else {
            goodsMapper.update(goods);
        }
    }

    @Override
    public PageResult search(PageRequest pageRequest, GoodsQueryModel goodsQueryModel) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goodsList = goodsMapper.listGoods(goodsQueryModel);
        return PageUtils.getPageResult(pageRequest, new PageInfo<Goods>(goodsList));
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteById(String id) {
        goodsMapper.deleteById(id);
    }

    @Override
    @Cacheable(key = "#id")
    public Goods getById(String id) {
        return goodsMapper.getById(id);
    }
}