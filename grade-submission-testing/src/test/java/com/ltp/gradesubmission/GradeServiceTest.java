package com.ltp.gradesubmission;

import com.ltp.gradesubmission.pojo.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {
    @Mock
    private GradeRepository gradeRepository;
    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromRepoTest(){
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
            new Grade("Harry", "Potions", "C-"),
            new Grade("Hermione", "Arithmancy", "A+")
        ));

        List<Grade> result = gradeService.getGrades();

        assertEquals("Harry", result.get(0).getName());
        assertEquals("Arithmancy", result.get(1).getSubject());
    }

    @Test
    public void gradeIndexTest(){
        Grade grade = new Grade("Harry", "Potions", "C-");
        when(gradeRepository.getGrades()).thenReturn(List.of(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        int valid = gradeService.getGradeIndex(grade.getId());
        int notFound = gradeService.getGradeIndex("123");

        assertEquals(0, valid);
        assertEquals(Constants.NOT_FOUND, notFound);
    }

    @Test
    public void returnGradeByIdTest(){
        Grade grade = new Grade("Harry", "Potions", "C-");
        when(gradeRepository.getGrades()).thenReturn(List.of(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        String id = grade.getId();
        Grade res = gradeService.getGradeById(id);

        assertEquals(grade, res);
    }
}
