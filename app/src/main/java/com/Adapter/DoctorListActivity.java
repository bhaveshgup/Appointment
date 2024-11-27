package com.Adapter;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appointment.R;
import com.view.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DoctorAdapter doctorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data for doctors
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(new Doctor("Doctor 1", "10:00 AM - 5:00 PM", true));
        doctorList.add(new Doctor("Doctor 2", "9:00 AM - 2:00 PM", false));
        doctorList.add(new Doctor("Doctor 3", "11:00 AM - 4:00 PM", true));

        // Set up the adapter with the data
        doctorAdapter = new DoctorAdapter(doctorList);
        recyclerView.setAdapter(doctorAdapter);
    }
}
