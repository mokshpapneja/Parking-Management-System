package com.DAO;

import java.util.List;


import com.entity.SlotDtls;
import com.entity.Cart;

public interface CartDAO {
	
	public boolean addCart(Cart c);
	
	public List<Cart> getSlotByUser(int userId);
	
	public boolean deleteSlot(int bid,int uid,int cid);
	
	

}
