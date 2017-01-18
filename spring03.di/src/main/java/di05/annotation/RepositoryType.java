package di05.annotation;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import di00.model.Type;
import di04.collections.IRepositoryType;

@Repository("daoType")
public class RepositoryType implements IRepositoryType {

	private static final Logger logger = LoggerFactory.getLogger(RepositoryType.class);
	
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
