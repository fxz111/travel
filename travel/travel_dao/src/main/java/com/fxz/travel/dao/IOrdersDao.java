package com.fxz.travel.dao;

import com.fxz.travel.domain.Member;
import com.fxz.travel.domain.Orders;
import com.fxz.travel.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "com.fxz.travel.dao.IProductDao.findById")),
            @Result(column = "memberId",property = "member",javaType = Member.class,one = @One(select = "com.fxz.travel.dao.IMemberDao.findById"))
    })
    public List<Orders> findAll();
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "com.fxz.travel.dao.IProductDao.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select = "com.fxz.travel.dao.ITravellerDao.findByOrdersId")),
            @Result(column = "memberId",property = "member",javaType = Member.class,one = @One(select = "com.fxz.travel.dao.IMemberDao.findById"))
    })
    public Orders findById(String id);
}
