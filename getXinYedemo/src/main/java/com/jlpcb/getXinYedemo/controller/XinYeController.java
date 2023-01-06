package com.jlpcb.getXinYedemo.controller;

import com.jlpcb.getXinYedemo.domain.XinYe;
import com.jlpcb.getXinYedemo.service.IXinYeService;
import com.jlpcb.getXinYedemo.web.JsonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xinye")
public class XinYeController {

    @Autowired
    private IXinYeService iXinYeService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "lh", value = "料号", dataType = "String", required = true)
    })
    @GetMapping("/get")
    public JsonResult<XinYe> getNewData(String lh,String xb) {

        XinYe newData = iXinYeService.getNewData(lh,xb);

        return JsonResult.ok(newData);
    }
}
