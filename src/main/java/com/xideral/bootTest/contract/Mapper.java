package com.xideral.bootTest.contract;

public interface Mapper<From, To> {

	To map(From input);

}


