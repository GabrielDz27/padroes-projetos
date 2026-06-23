package br.edu.ifsc.pps.gv.entities;

import br.edu.ifsc.pps.gv.exceptions.InvalidEntityException;

public abstract class AbstractDbEntity implements DbEntity {
	protected static int currentId = 1;
	
	protected int id;
	
	@Override
	public void doSave() throws InvalidEntityException {
		id = currentId++;
	}
	
	@Override
	public void doDelete() throws InvalidEntityException {
		
	}
	
	@Override
	public void doUpdate() throws InvalidEntityException {
		
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
}
