package com.pocstudentproject.studentpocproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
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

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_newuser, null);

        //Dialog Elements
        final EditText userName = (EditText) view.findViewById(R.id.edt_name);

        final EditText userAge = (EditText) view.findViewById(R.id.edt_idade);

        final EditText userAddress = (EditText) view.findViewById(R.id.edt_endereco);

        final EditText userPhone = (EditText) view.findViewById(R.id.edt_telefone);

        final EditText userPhotoUri = (EditText) view.findViewById(R.id.edt_foto);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Novo Aluno");
        builder.setView(view);
        builder.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //do not prevent null fields
                createStudent(userName.getText().toString(), Integer.parseInt(userAge.getText().toString()), userPhotoUri.getText().toString()
                        , userPhone.getText().toString(), userAddress.getText().toString());

                Toast.makeText(getBaseContext(), "Aluno Criado", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
//        AlertDialog dialog = builder.create();
//        dialog.show();
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



    }

    void deleteStudent(int position) {

    }

    @Background
    void createStudent(final String name, final int age, final String photoUri, final String phone, final String address) {
        //metodo create new student
        Student newStudent = new Student() {
            {
                setEndereco(address);
                setFotoUrl(photoUri);
                setIdade(age);
                setNome(name);
                setTelefone(phone);
            }
        };
        serviceRest.createStudent(newStudent);

        RequestStudentData();
    }


//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        // Get the layout inflater
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//
//        // Inflate and set the layout for the dialog
//        // Pass null as the parent view because its going in the dialog layout
//        builder.setView(inflater.inflate(R.layout.dialog_signin, null))
//                // Add action buttons
//                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        // sign in the user ...
//                    }
//                })
//                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        LoginDialogFragment.this.getDialog().cancel();
//                    }
//                });
//        return builder.create();
//    }
}
