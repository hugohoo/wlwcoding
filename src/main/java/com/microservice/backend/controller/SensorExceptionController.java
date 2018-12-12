package com.microservice.backend.controller;

import com.microservice.backend.entity.SensorException;
import com.microservice.backend.service.SensorExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/sensorException")
public class SensorExceptionController extends BaseController{
    @Autowired
    SensorExceptionService sensorExceptionService = null;

    @RequestMapping(value="",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public HashMap getAllSensorException(){
        List<SensorException> sensorExceptions = new ArrayList<SensorException>();
        HashMap map = new HashMap();
        try {
            sensorExceptions = sensorExceptionService.findAll();
        }catch (Exception e){
            map = this.setResponse("error","db error",null);
            return map;
        }

        map = this.setResponse("success",null,sensorExceptions);
        return  map;
    }

    @RequestMapping(path = "/{dataFrom}{dataTo}",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public HashMap getAllSensorException(@PathVariable("dataFrom") String dataFrom, @PathVariable("dataTo") String dataTo){
        List<SensorException> sensorExceptions = new ArrayList<SensorException>();
        HashMap map = new HashMap();
        try {
            sensorExceptions = sensorExceptionService.findByTime(dataFrom, dataTo);
        }catch (Exception e){
            map = this.setResponse("error","db error",null);
            return map;
        }

        map = this.setResponse("success",null,sensorExceptions);
        return  map;
    }
}