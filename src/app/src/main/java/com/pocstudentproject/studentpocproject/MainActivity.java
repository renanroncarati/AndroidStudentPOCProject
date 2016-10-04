package com.pocstudentproject.studentpocproject;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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

    @ViewById(R.id.btnRequest)
    Button btnRequest;

    StudentAdapter studentsAdapter;
    List<Student> students;

    @RestService
    ServiceRest serviceRest;

    String[] mobileArray = {"Android", "IPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X"};


    @AfterViews
    void content() {

    }

    @Click(R.id.btnRequest)
    void requestButton() {
        JSONAnnotations();
    }

    @UiThread
    void updateUi(List<Student> students)
    {
        studentsAdapter = new StudentAdapter(this, R.layout.student_listview, students);
        studentsList.setAdapter(studentsAdapter);
    }

    @Background
    void JSONAnnotations() {
        StudentListWrapper studentListWrapper = serviceRest.getStudents();



        if (studentListWrapper != null){
            Log.d("TESTE", studentListWrapper.getStudents().get(0).getEndereco());

            updateUi(studentListWrapper.getStudents());
        }


//        serviceRest.removeStudent("AjoYF598sQ");

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
}
