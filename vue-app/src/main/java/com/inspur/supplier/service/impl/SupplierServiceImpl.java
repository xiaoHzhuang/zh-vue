package com.inspur.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inspur.system.page.PO.PageRequest;
import com.inspur.system.page.PO.PageResult;
import com.inspur.system.page.utils.PageUtils;
import com.inspur.supplier.DO.Supplier;
import com.inspur.supplier.DO.SupplierQueryModel;
import com.inspur.supplier.dao.SupplierMapper;
import com.inspur.supplier.service.ISupplierService;
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
 * Date: 2020/2/14   20:09
 * Description:
 */
@Service
@CacheConfig(cacheNames = "supplier")
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    @CachePut(key = "#supplier.id")
    public void save(Supplier supplier) {
        if (supplier.getId() != null) {
            supplierMapper.update(supplier);
        } else {
            supplier.setId(UUID.randomUUID().toString());
            supplierMapper.insertSelective(supplier);
        }
    }

    @Override
    public PageResult getAllSupplier(SupplierQueryModel supplierQueryModel, PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Supplier> supplierList = supplierMapper.listSuppliers(supplierQueryModel);
        return PageUtils.getPageResult(pageRequest, new PageInfo<Supplier>(supplierList));
    }

    @Override
    @Cacheable
    public Supplier getSupplierById(String id) {
        return supplierMapper.getSupplierById(id);
    }

    @Override
    @CacheEvict
    public void deleteSupplierById(String id) {
        supplierMapper.deleteSupplierById(id);
    }
}