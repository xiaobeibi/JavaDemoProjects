package service;

import java.util.List;

import pojo.Checkout;

public interface CheckoutService {
public void insertcheckout(Checkout checkout);
public List<Checkout> getallcheckout();
public void deletecheckout(Integer id);
}
