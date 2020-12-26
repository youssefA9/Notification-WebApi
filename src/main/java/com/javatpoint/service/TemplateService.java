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
    List<Template> temps;

    public List<Template> getAllTemplates() {
        List<Template> Templates = new ArrayList<Template>();
        TemplatesRepository.findAll().forEach(temp -> Templates.add(temp));
        return Templates;
    }

    public Template readTemplate(int id) {
        return TemplatesRepository.findById(id).get();
    }

    public void addTemplate(Template Template) {
        TemplatesRepository.save(Template);
    }

    public void deleteTemplate(int id) {

        TemplatesRepository.deleteById(id);
    }

    public void updateTemplate(Template newTemplate) {
        TemplatesRepository.save(newTemplate);
    }
}