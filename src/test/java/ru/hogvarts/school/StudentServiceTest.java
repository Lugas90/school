package ru.hogvarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hogvarts.school.model.Student;
import ru.hogvarts.school.service.StudentService;

import java.util.HashSet;
import java.util.Set;

import static ru.hogvarts.school.constantsStudent.*;

public class StudentServiceTest {
    private final StudentService out = new StudentService();


    @Test
    public void shouldReturnAddStudent() {
        Student st = new Student(1L, NAME1, AGE1);
        Student actual = out.addStudent(st);
        Student expected = new Student(1L, NAME1, AGE1);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnGetStudent() {
        Student st = new Student(1L, NAME2, AGE2);
        out.addStudent(st);
        Student actual = out.getStudent(1L);
        Student expected = new Student(1L, NAME2, AGE2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnEditStudent() {
        Student st = new Student(1L, NAME2, AGE2);
        Student st2 = new Student(2L, NAME3, AGE3);
        out.addStudent(st);
        Student actual = out.editStudent(1L, st2);
        Student expected = new Student(2L, NAME3, AGE3);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnDeleteStudent() {
        Student st = new Student(1L, NAME1, AGE1);
        Student st2 = new Student(2L, NAME2, AGE2);
        out.addStudent(st);
        out.addStudent(st2);
        Set<Student> expected = new HashSet<>(Set.of(st));
        out.deleteStudent(2L);
        Assertions.assertThat(out.getAll()).isEqualTo(expected);
    }
}
