
package com.f1soft.task.assigner.dao;

import com.f1soft.task.assigner.entity.Feature;
import java.util.List;

/**
 *
 * @author sunita.joshi
 */
public interface FeatureDAO {
    List<Feature> findAll();
}
