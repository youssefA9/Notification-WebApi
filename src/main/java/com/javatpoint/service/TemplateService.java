package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;

import com.javatpoint.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.repository.TemplatesRepository;


@Service
public class TemplateService {
    @Autowired
    TemplatesRepository TemplatesRepository;

    public List<Template> getAllTemplates() {
        List<Template> Templates = new ArrayList<Template>();
        TemplatesRepository.findAll().forEach(temp -> Templates.add(temp));
        return Templates;
    }

    public Template readTemplate(int id) {
        return TemplatesRepository.findById(id).get();
    }

    public void addTemplate(Template Template) {
        Template.setId(999999999);
        TemplatesRepository.save(Template);
        idCalibration();
    }

    public void deleteTemplate(int id) {
        TemplatesRepository.deleteById(id);
        idCalibration();
    }

    public void updateTemplate(Template newTemplate) {
        TemplatesRepository.save(newTemplate);
    }

    public void idCalibration() {
        List<Template> Templates = getAllTemplates();
        TemplatesRepository.deleteAll();
        Template temp;
        int min = 1;
        for (int i = 0; i < Templates.size(); i++) {
            temp = new Template(Templates.get(i), min);
            TemplatesRepository.save(temp);
            min++;
        }
    }

}