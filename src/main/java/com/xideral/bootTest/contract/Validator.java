package com.xideral.bootTest.contract;

public interface Validator<T> {

	boolean isValid(T value);

}
