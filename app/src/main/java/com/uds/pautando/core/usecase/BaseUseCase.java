package com.uds.pautando.core.usecase;

public interface BaseUseCase<Type,Params> {
    Type call(Params params);
}
