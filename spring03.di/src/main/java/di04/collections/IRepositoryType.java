package di04.collections;

import di00.model.*;

public interface IRepositoryType {
    
	public Type[] getAll();
	
	public Type findById(String id);
}
