
package com.f1soft.task.assigner.service;

import com.f1soft.task.assigner.entity.Feature;
import java.util.List;

/**
 *
 * @author sunita.joshi
 */
public interface FeatureService {
     
     List<Feature> fetchAllFeature();
     
     Feature findFeatureById(Long id);

   
     
}
