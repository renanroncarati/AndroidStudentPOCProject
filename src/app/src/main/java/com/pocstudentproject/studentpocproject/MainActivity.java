package com.pocstudentproject.studentpocproject;

import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.pocstudentproject.models.Student;
import com.pocstudentproject.models.StudentAdapter;
import com.pocstudentproject.models.StudentListWrapper;
import com.pocstudentproject.services.ServiceRest;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @ViewById(R.id.listStudents)
    ListView studentsList;

    @ViewById(R.id.pink_icon)
    FloatingActionButton floatingActionButton;

    StudentAdapter studentsAdapter;

    @RestService
    ServiceRest serviceRest;


    @AfterViews
    void init() {
        RequestStudentData();
    }

    @Click(R.id.pink_icon)
    void floatAction() {
        Toast.makeText(this, "Intent Tela Adicionar novo Student", Toast.LENGTH_SHORT).show();
    }

    @UiThread
    void updateUi(List<Student> students) {
        studentsAdapter = new StudentAdapter(this, R.layout.student_listview, students);
        studentsList.setAdapter(studentsAdapter);
    }

    @Background
    void RequestStudentData() {
        StudentListWrapper studentListWrapper = serviceRest.getStudents();

        if (studentListWrapper != null) {
            updateUi(studentListWrapper.getStudents());
        }

//metodo delete
//        serviceRest.removeStudent("AjoYF598sQ");

        //metodo create new student
//        Student newStudent = new Student() {
//            {
//                setEndereco("rua das oliveiras");
//                setFotoUrl("https://robohash.org/1460852849489.png");
//                setIdade(26);
//                setNome("Marmita e marmota");
//                setTelefone("3177777785252");
//            }
//        };
//        serviceRest.createStudent(newStudent);

    }

    void deleteStudent(int position) {

    }
}
