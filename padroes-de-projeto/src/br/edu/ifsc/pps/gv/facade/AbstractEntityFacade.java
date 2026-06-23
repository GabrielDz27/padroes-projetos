package br.edu.ifsc.pps.gv.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.edu.ifsc.pps.gv.db.DB;
import br.edu.ifsc.pps.gv.entities.DbEntity;
import br.edu.ifsc.pps.gv.exceptions.InvalidEntityException;
import br.edu.ifsc.pps.gv.observers.EntityObserver;

public abstract class AbstractEntityFacade<T extends DbEntity> {
	protected final Class<T> entityClass;

    private final List<EntityObserver> observers = new ArrayList<>();

	protected AbstractEntityFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public void insert(T entity) throws InvalidEntityException {
		if (selectById(entity.getId()) != null) {
			throw new RuntimeException("Já existe um registro cadastrado com o ID " + entity.getId());
		}

        for (EntityObserver observer : observers) {
            observer.onBeforeInsert(entity);
        }

		entity.doSave();
		DB.getInstance().insert(entityClass, entity);

        for (EntityObserver observer : observers) {
            observer.onAfterInsert(entity);
        }
	}

	public void update(T entity) throws InvalidEntityException {
		entity.doUpdate();
		
		if (DB.getInstance().exists(entityClass, getByIdPredicate(entity))) {
			DB.getInstance().delete(entityClass, getByIdPredicate(entity));
		}
		
		DB.getInstance().insert(entityClass, entity);
	}
	
	public void delete(T entity) throws InvalidEntityException {
		entity.doDelete();
		DB.getInstance().delete(entityClass, getByIdPredicate(entity));
	}
	
	public T selectById(int id) {
		return selectFirst(getByIdPredicate(id));
	}
	
	public List<T> select(Predicate<T> where) {
		return DB.getInstance().where(entityClass, where);
	}
	
	public List<T> selectAll() {
		return DB.getInstance().selectAll(entityClass);
	}
	
	public T selectFirst(Predicate<T> where) {
		List<T> rows = DB.getInstance().where(entityClass, where);
		
		if (rows.size() < 1) {
			return null;
		}
		
		return rows.getFirst();
	}
	
	private Predicate<T> getByIdPredicate(T entity) {
		return getByIdPredicate(entity.getId());
	}
	
	private Predicate<T> getByIdPredicate(int id) {
		return row -> row.getId() == id;
	}

    public void addObserver(EntityObserver observer) {
        if (observer != null) {
            this.observers.add(observer);
        }
    }

    public void removeObserver(EntityObserver observer) {
        this.observers.remove(observer);
    }
}
