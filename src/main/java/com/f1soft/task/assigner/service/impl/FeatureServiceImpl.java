
package com.f1soft.task.assigner.service.impl;

import com.f1soft.task.assigner.entity.Feature;
import com.f1soft.task.assigner.repository.FeatureRepository;
import com.f1soft.task.assigner.service.FeatureService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunita.joshi
 */@Service
 @Transactional
 public class FeatureServiceImpl  implements FeatureService{
     @Autowired
     FeatureRepository featureRepository;
     
//    @Override
//    public Feature findById(Long id) {
//        return featureRepository.findOne(id);
//    }

    @Override
    public List<Feature> fetchAllFeature() {
        return featureRepository.findAll();
    }

    @Override
    public Feature findFeatureById(Long id) {
        return  featureRepository.findOne(id);
    }
    
}
