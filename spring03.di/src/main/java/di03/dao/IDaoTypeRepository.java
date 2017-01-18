package di03.dao;

import di00.model.*;

public interface IDaoTypeRepository {
    
	public Type[] getAll();
	
	public Type findById(String id);
}
