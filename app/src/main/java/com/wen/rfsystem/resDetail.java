package com.wen.rfsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class resDetail extends AppCompatActivity {
    TextView tv;
    EditText ed4, ed5;
    customer p;
    reserve ord;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_detail);

        Intent it = getIntent();
        pos = it.getIntExtra("pos", 0);
        //res _id

        SFsysDAO dao =new SFsysDAOImp(resDetail.this);



    }
}
/*


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    TextView tv;
    EditText ed4, ed5;
    Student s;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent it = getIntent();
        pos = it.getIntExtra("pos", 0);

        tv = (TextView) findViewById(R.id.textView);
        ed4 = (EditText) findViewById(R.id.editText4);
        ed5 = (EditText) findViewById(R.id.editText5);
        StudentDAO dao = new StudentDAODBImpl(DetailActivity.this);
        List<Student> mylist = dao.getAllStudent();
        s = mylist.get(pos);
        tv.setText(s.name);
        ed4.setText(s.addr);
        ed5.setText(s.tel);
    }

    public void click_update(View v)
    {
        StudentDAO dao = new StudentDAODBImpl(DetailActivity.this);
        Student s = new Student(tv.getText().toString(), ed4.getText().toString(), ed5.getText().toString());
        dao.updateStudent(s);
    }

    public void click_del(View v)
    {
        StudentDAO dao = new StudentDAODBImpl(DetailActivity.this);
        List<Student> mylist = dao.getAllStudent();
        s = mylist.get(pos);
        dao.delStudent(s);
        finish();
    }

}

 */