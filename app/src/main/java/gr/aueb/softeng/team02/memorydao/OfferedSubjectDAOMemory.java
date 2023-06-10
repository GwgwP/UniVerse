package gr.aueb.softeng.team02.memorydao;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class OfferedSubjectDAOMemory implements OfferedSubjectDAO {
    private static ArrayList<OfferedSubject> list = new ArrayList<>();

    /**
     * Store the offered subject if it doesn't exist in the dao
     *
     * @param entity offered subject object
     */
    @Override
    public void save(OfferedSubject entity) {
        if (!list.contains(entity)) {
            list.add(entity);
        }
    }

    /**
     * Delete the offered subject if it does exist in the dao
     *
     * @param entity offered subject object
     */
    @Override
    public void delete(OfferedSubject entity) {
        list.remove(entity);
    }

    /**
     * Get a list with all offered subjects in the dao
     *
     * @return a list of offered subject objects
     */
    @Override
    public List<OfferedSubject> findAll() {
        return new ArrayList<>(list);
    }

    /**
     * Get a list of offered subject based on the modulo of the semester (even or odd number)
     *
     * @param mod  result of modulo is 0 or 1
     * @param year specific academic year object
     * @return a list of offered subject objects
     */
    @Override
    public List<OfferedSubject> findByModulo(int mod, String year) {
        ArrayList<OfferedSubject> subjects = new ArrayList<>();
        for (OfferedSubject subject : list) {
            if (subject.getSemester() % 2 == mod && subject.getAcademicYearINString().equals(year)) {
                subjects.add(subject);
            }
        }
        return subjects;
    }

    /**
     * Get an offered subject based on a specific academic year time stamp and the subject title
     *
     * @param year  the time stamp of an academic year in a string
     * @param title the title of a subject as a string
     * @return an offered subject object if it does exist in the dao or null
     */
    @Override
    public OfferedSubject findByYearAndName(String year, String title) {
        for (OfferedSubject subject : list) {
            if (subject.getTitle().equals(title) && subject.getAcademicYearINString().equals(year))
                return subject;
        }
        return null;
    }

    /**
     * Get a list of offered subjects based on the semester abd the time stamp of the academic year
     *
     * @param year     the time stamp of the academic year in string
     * @param semester the semester as an integer
     * @return a list of offered subject objects
     */
    @Override
    public List<OfferedSubject> findAllSubjectsByYearAndBySemester(String year, int semester) {
        List<OfferedSubject> subjects = new ArrayList<>();
        for (OfferedSubject sub : list) {
            if (sub.getAcademicYearINString().equals(year) && sub.getSemester() == semester) {
                subjects.add(sub);
            }
        }
        return subjects;
    }

    /**
     * Get an offered subject based on the time stamp of an academic year
     *
     * @param year the time stamp of the academic year in string
     * @return an offered subject object or null
     */
    @Override
    public List<OfferedSubject> findByYear(String year) {
        ArrayList<OfferedSubject> subjects = new ArrayList<>();

        for (OfferedSubject sub : list) {
            if (sub.getAcademicYearINString().equals(year))
                subjects.add(sub);
        }
        return subjects;
    }

    /**
     * Get an offered subject based on the title of it's subject
     *
     * @param title the title of the subject as a string
     * @return an offered subject object or null
     */
    @Override
    public OfferedSubject findByTitle(String title) {
        for (OfferedSubject sub : list) {
            if (sub.getTitle().equalsIgnoreCase(title)) {
                return sub;
            }
        }

        return null;
    }

}
