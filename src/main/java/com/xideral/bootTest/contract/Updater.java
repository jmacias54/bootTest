package com.xideral.bootTest.contract;

public interface Updater<ToUpdate, Input> {

	ToUpdate update(ToUpdate entity, Input data);

}

