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

    public Template readTemplate(String subject, int numOfPlaceHolders) {
        List<Template> Templates = getAllTemplates();
        int id = 0;
        for (int i = 0; i < Templates.size(); i++) {
            if (Templates.get(i).getSubject().equalsIgnoreCase(subject)) {
                if (Templates.get(i).getNumOfPlaceholder() == numOfPlaceHolders) {
                    id = i + 1;
                    break;
                }
            }
        }
        if (id != 0) {
            return TemplatesRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public void addTemplate(Template Template) {
        Template.setId(999999999);
        Template.setNumOfPlaceholder(checkNumOfPlaceHolder(Template.getContent()));
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

    public int checkNumOfPlaceHolder(String c) {
        int count = 0;
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == '#') {
                count++;
            }
        }
        return count;
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