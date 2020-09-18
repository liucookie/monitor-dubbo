package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.Dictionary;
import com.cast.serviceman.api.entity.common.ResponseModel;

import java.util.List;

public interface DictionaryService {


    ResponseModel<List<Dictionary>> queryTypeCode(String dictionaryTypeCode);

}
