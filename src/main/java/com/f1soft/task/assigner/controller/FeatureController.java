package com.f1soft.task.assigner.controller;

import com.f1soft.task.assigner.entity.Feature;
import com.f1soft.task.assigner.exception.GenericException;
import com.f1soft.task.assigner.request.dto.ErrorResponse;
import com.f1soft.task.assigner.service.FeatureService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunita.joshi
 */
@RestController
@RequestMapping(value = "/feature")
public class FeatureController {

    @Autowired
    private FeatureService featureService;


    @RequestMapping(value = "/getfeature", method = RequestMethod.GET)
    public ResponseEntity<List<Feature>> fetchAllFeature() {

        List<Feature> features = featureService.fetchAllFeature();
        if (features.isEmpty()) {
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.EXPECTATION_FAILED.value(),
                            HttpStatus.EXPECTATION_FAILED,
                            "Sorry! feature not found",
                            "Error while fetching features"
                    )
            );

        } else {
            return new ResponseEntity<>(features, HttpStatus.OK);
        }
    }
}
