package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javatpoint.model.Template;
import com.javatpoint.service.TemplateService;

@RestController
public class TemplateController {

    @Autowired
    TemplateService TemplateService;

    @GetMapping("/templates")
    private List<Template> getAllTemplates() {
        return TemplateService.getAllTemplates();
    }

    @GetMapping("/templates/read/{id}")
    private Template readTemplate(@PathVariable("id") int id) {
        return TemplateService.readTemplate(id);
    }

    @DeleteMapping("/templates/delete/{id}")
    private void deleteTemplate(@PathVariable("id") int id) {
        TemplateService.deleteTemplate(id);
    }

    @PostMapping("/templates/add")
    private String addTemplate(@RequestBody Template template) {
        TemplateService.addTemplate(template);
        return "Template Has Been Created";
    }

    @PutMapping("/templates/update")
    private Template updateTemplate(@RequestBody Template template) {
        TemplateService.updateTemplate(template);
        return template;
    }
}
