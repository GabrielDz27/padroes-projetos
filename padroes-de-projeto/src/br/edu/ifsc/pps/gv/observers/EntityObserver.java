package br.edu.ifsc.pps.gv.observers;

import br.edu.ifsc.pps.gv.entities.DbEntity;

public interface EntityObserver {
	void onBeforeInsert(DbEntity entity);
	void onAfterInsert(DbEntity entity);

}
