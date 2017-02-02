
package com.f1soft.task.assigner.dao.impl;

import com.f1soft.task.assigner.dao.FeatureDAO;
import com.f1soft.task.assigner.entity.Feature;
import com.f1soft.task.assigner.repository.FeatureRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sunita.joshi
 */
public class FeatureDAOImpl implements FeatureDAO{

    @Autowired
    private FeatureRepository featureRepository;
    
    @Override
    public List<Feature> findAll() {
        return featureRepository.findAll();
        
    }
    
}
