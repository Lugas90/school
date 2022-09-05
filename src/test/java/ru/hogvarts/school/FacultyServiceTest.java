package ru.hogvarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hogvarts.school.model.Faculty;
import ru.hogvarts.school.service.FacultyService;

import java.util.HashSet;
import java.util.Set;

import static ru.hogvarts.school.FacultyConstants.*;

public class FacultyServiceTest {
    private final FacultyService out = new FacultyService();


    @Test
    public void shouldReturnAddFaculty() {
        Faculty fac = new Faculty(1L, NAME1, COLOR1);
        Faculty actual = out.addFaculty(fac);
        Faculty expected = new Faculty(1L, NAME1, COLOR1);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnGetFaculty() {
        Faculty fac = new Faculty(1L, NAME2, COLOR2);
        out.addFaculty(fac);
        Faculty actual = out.getFaculty(1L);
        Faculty expected = new Faculty(1L, NAME2, COLOR2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnEditFaculty() {
        Faculty fac = new Faculty(1L, NAME2, COLOR2);
        Faculty fac2 = new Faculty(2L, NAME3, COLOR3);
        out.addFaculty(fac);
        Faculty actual = out.editFaculty(1L, fac2);
        Faculty expected = new Faculty(2L, NAME3, COLOR3);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnDeleteFaculty() {
        Faculty fac = new Faculty(1L, NAME1, COLOR1);
        Faculty fac2 = new Faculty(2L, NAME2, COLOR2);
        out.addFaculty(fac);
        out.addFaculty(fac2);
        Set<Faculty> expected = new HashSet<>(Set.of(fac));
        out.deleteFaculty(2L);
        Assertions.assertThat(out.getAll()).isEqualTo(expected);
    }
}
