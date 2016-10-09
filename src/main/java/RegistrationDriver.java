import org.joda.time.LocalDate;
import studentregistration.CourseProgramme;
import studentregistration.Module;
import studentregistration.Student;

import java.util.ArrayList;

/**
 * Created by Catherine on 05/10/2016.
 */
public class RegistrationDriver {
    public static void main(String[] args) {

        //Possible courses
        CourseProgramme csit = new CourseProgramme("Computer Science & Information Technology", new LocalDate("2016-09-01") ,new LocalDate("2020-05-01"));
        CourseProgramme fme = new CourseProgramme("Financial Mathematics and Economics", new LocalDate("2016-09-01") ,new LocalDate("2020-05-01"));

        //Possible modules
        Module discreteMath = new Module("Discrete Mathematics", "MA1");
        Module programming2 = new Module("Programming", "CS1");
        Module softwareEng = new Module("Software Engineering", "CS2");
        Module probability = new Module("Probability", "MA2");

        //Students registering
        Student s1 = new Student("Anne Aherne", 13381234, new LocalDate("1996-01-01"), csit);
        Student s2 = new Student("Ben Bishop", 13385678, new LocalDate("1996-02-02"), fme);
        Student s3 = new Student("Cath Casey", 13389012, new LocalDate("1997-03-03"), csit);

        ArrayList<Student> allStudents = new ArrayList<Student>();
        allStudents.add(s1);
        allStudents.add(s2);
        allStudents.add(s3);


        //Modules Add Students
        discreteMath.addStudent(s1);
        discreteMath.addStudent(s2);
        discreteMath.addStudent(s3);

        programming2.addStudent(s1);
        programming2.addStudent(s3);

        softwareEng.addStudent(s1);
        softwareEng.addStudent(s3);

        probability.addStudent(s2);


        //Courses Add Modules
        csit.addModule(discreteMath);
        csit.addModule(programming2);
        csit.addModule(softwareEng);

        fme.addModule(discreteMath);
        fme.addModule(probability);


        //Printing info to console
        for(Student currStudent : allStudents){
            System.out.println("------------------------------------------------------------------------");
            System.out.println(currStudent.toString() + "\n");
            int numModules = currStudent.getCourse().getModuleList().size();
            System.out.println("Student has the following " + numModules + " modules:");
            for(int i = 0; i<numModules; i++){
                System.out.println( currStudent.getCourse().getModuleList().get(i).toString());
            }
        }

    }

}