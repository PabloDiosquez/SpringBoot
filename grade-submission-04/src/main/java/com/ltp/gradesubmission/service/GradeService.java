package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import java.util.List;

public class GradeService {
    private final GradeRepository gradeRepository = new GradeRepository();

    public Grade getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public Grade getGradeById(String id){
        int index = getGradeIndex(id);
        return index == Constants.NOT_FOUND ? new Grade() : getGrade(index);
    }

    public List<Grade> getGrades(){
        return gradeRepository.getGrades();
    }

    public void submitGrade(Grade grade){
        int index = getGradeIndex(grade.getId());
        if(index == Constants.NOT_FOUND){
            addGrade(grade);
        } else {
            updateGrade(index, grade);
        }
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(int index, Grade grade) {
        gradeRepository.updateGrade(index, grade);
    }
    public int getGradeIndex(String id) {
        for (int i = 0; i < getGrades().size(); i++) {
            if (getGrades().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }
}
