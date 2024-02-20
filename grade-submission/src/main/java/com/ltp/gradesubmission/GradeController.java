package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {

    List<Grade> grades = new ArrayList<>();

    @GetMapping(path="/")
    public String gradeForm(Model model){
        model.addAttribute("grade", new Grade());
        return "form";
    }

    @GetMapping(path="/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", grades);
        return "grades";
    }

    @PostMapping(path="/handleSubmit")
    public String submitForm(Grade grade){
        grades.add(grade);
        return "redirect:/grades";
    }
}
