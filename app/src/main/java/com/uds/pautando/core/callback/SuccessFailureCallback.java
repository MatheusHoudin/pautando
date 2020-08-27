package com.uds.pautando.core.callback;

public interface SuccessFailureCallback<T> {
    void onSuccess(T result);
    void onFailure(String message);
}
