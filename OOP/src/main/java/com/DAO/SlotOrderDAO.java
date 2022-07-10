package com.DAO;

import java.util.List;


import com.entity.Slot_order;

public interface SlotOrderDAO {

	public boolean saveOrder(List<Slot_order> b);
	
	public List<Slot_order> getslot(String email);
	
	public List<Slot_order> getAllOrder();

}
