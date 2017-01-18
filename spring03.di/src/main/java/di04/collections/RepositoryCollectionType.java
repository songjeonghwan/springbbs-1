package di04.collections;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import di00.model.*;

public class RepositoryCollectionType implements IRepositoryType {

	private static final Logger logger = LoggerFactory.getLogger(RepositoryCollectionType.class);
	
	private Map<String, Type> types = null;

	public Map<String, Type> getTypes() {
		return types;
	}

	public void setTypes(Map<String, Type> types) {
		this.types = types;
	}


    @Override
    public Type[] getAll() {
        return types.values().toArray(new Type[types.values().size()]);
    }

    @Override
	public Type findById(String id) {
		if (logger.isDebugEnabled())
			logger.debug("Start <findById> Params: " + id);

		Type type = types.get(id);

		if (logger.isDebugEnabled())
			logger.debug("End <findById> Params: " + type);
		
		return type;
	}

}
