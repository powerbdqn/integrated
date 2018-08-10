package com.integrate.service.dictionaries;

import java.util.List;

import com.integrate.pojo.dictionaries.Stage;

public interface StageService {

	List<Stage> liststages();

	Integer getStageIdByStageName(String name);


}
