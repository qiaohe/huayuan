package com.huayuan.ops.web;

import com.huayuan.ops.domain.Dictionary;
import com.huayuan.ops.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by dell on 14-4-1.
 */
@Controller
public class DictionaryController {
    @Inject
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/dict", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Dictionary> getDictionary() {
        return dictionaryService.getAll();
    }
}
