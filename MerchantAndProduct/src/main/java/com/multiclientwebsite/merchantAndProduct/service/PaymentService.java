package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCustomerExistsException;

public interface PaymentService {

    public String orderProductsFromCart(Long customerId) throws NoSuchCustomerExistsException;

//    public Order getOrderDetailsById(Integer orderId) throws NoSuchOrderExists;
//
//    public List<Order> getAllOrderDetails() throws NoSuchOrderExists;
//
//    public String cancelOnlineOrder(Integer orderId) throws NoSuchOrderExists;
//
//    public Payment makeOnlinePayment(PaymentDTO paymentDTO, Integer orderId)
//            throws PaymentFailedException, NoSuchOrderExists;
}
