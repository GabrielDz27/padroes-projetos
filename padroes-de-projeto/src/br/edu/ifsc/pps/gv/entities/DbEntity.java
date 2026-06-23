package br.edu.ifsc.pps.gv.entities;

import br.edu.ifsc.pps.gv.exceptions.InvalidEntityException;

public interface DbEntity {
	int getId();
	void setId(int id);
	
	void doSave() throws InvalidEntityException;
	void doUpdate() throws InvalidEntityException;
	void doDelete() throws InvalidEntityException;
}
