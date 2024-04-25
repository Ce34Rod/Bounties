package org.CERN.bounties.controllers;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class BountyController {


    @GetMapping("")
    public String createRecord(Model model){
        model.addAttribute(new Record());
        model.addAttribute(new DataPoint());
        return "records/create";
    }

    @PostMapping("create")
    public String processCreateRecord(@ModelAttribute @Valid Record record, @ModelAttribute DataPoint dataPoint){

//        dataPointRepository.save(dataPoint);
//        Record record1 = new Record(record.getName(), dataPoint);
//        recordRepository.save(record1);
//        dataPoint.setRecord(record1);
        dataPointRepository.save(dataPoint);

        Record record1 = new Record(record.getName(), dataPoint);
        recordRepository.save(record1);

        // Set the Record in the DataPoint
        dataPoint.setRecord(record1);

        // Set the DataPoint in the Record
        record1.getDataPointsList().add(dataPoint);


        return "redirect:/records/index";
    }
}
