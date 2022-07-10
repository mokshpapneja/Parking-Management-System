package com.DAO;


import java.util.ArrayList;


import java.util.List;

import com.entity.SlotDtls;

public interface SlotDAO {
	
	public boolean addSlots(SlotDtls b);

	public List<SlotDtls> getAllSlots();

	public SlotDtls getslotById(int id);

	public boolean updateEditslots(SlotDtls b);

	public boolean deleteslots(int id);
	
	public List<SlotDtls> getslotBySerch(String ch);

}
