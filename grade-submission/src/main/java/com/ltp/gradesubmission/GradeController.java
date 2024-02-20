package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {

    List<Grade> grades = new ArrayList<>();

    @GetMapping(path="/")
    public String gradeForm(Model model,@RequestParam(required = false) String id){
        int index = getGradeIndex(id);
        model.addAttribute("grade", index == -1 ? new Grade() : grades.get(index));
        return "form";
    }

    @GetMapping(path="/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", grades);
        return "grades";
    }

    @PostMapping(path="/handleSubmit")
    public String submitForm(Grade grade){
        int index = getGradeIndex(grade.getId());
        if (index == -1) {
            grades.add(grade);
        } else {
            grades.set(index, grade);
        }
        return "redirect:/grades";
    }

    public int getGradeIndex(String id){
        for (int index = 0; index < grades.size(); index++) {
            if(grades.get(index).getId().equals(id)){
                return index;
            }
        }
        return -1;
    }
}
