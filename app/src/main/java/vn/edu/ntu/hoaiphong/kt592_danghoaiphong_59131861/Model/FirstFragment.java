package vn.edu.ntu.hoaiphong.kt592_danghoaiphong_59131861.Model;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import java.util.Calendar;

import vn.edu.ntu.hoaiphong.kt592_danghoaiphong_59131861.R;

public class FirstFragment extends Fragment implements View.OnClickListener{

    EditText edtNgay, edtMua, edtBan;
    ImageView imvNgay;
    RadioGroup rdgTienTe;
    RadioButton rdbUSD, rdbEUR, rdbCNY;
    Button btnThem, btnXem;

    Calendar calendar = Calendar.getInstance();

    NavController navController;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addView(view);
        setView();
    }

    private void setView() {
        imvNgay.setOnClickListener((View.OnClickListener) this);
    }


    private void addView(View view) {
        edtNgay = view.findViewById(R.id.edtNgay);
        edtMua = view.findViewById(R.id.edtMua);
        edtBan = view.findViewById(R.id.edtBan);
        imvNgay = view.findViewById(R.id.imvNgay);
        rdgTienTe = view.findViewById(R.id.rdgNgoaiTe);
        rdbUSD = view.findViewById(R.id.rdbUSD);
        rdbEUR = view.findViewById(R.id.rdbEUR);
        rdbCNY = view.findViewById(R.id.rdbCNY);
        btnThem = view.findViewById(R.id.btnThem);
        btnXem = view.findViewById(R.id.btnXemDS);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.btnXemDS: XemDanhSach(); break;
            //case R.id.btnThem: Them(); break;
            case R.id.imvNgay: ChonNgay(); break;
        }
    }

    private void XemDanhSach() {
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private void ChonNgay() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                setTextNgaySinh(calendar);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(((MainActivity)getActivity()), listener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void setTextNgaySinh(Calendar calendar) {

        StringBuilder builder = new StringBuilder();
        builder.append(calendar.get(Calendar.DAY_OF_MONTH)).append("/").
                append(calendar.get(Calendar.MONTH) + 1).append("/").
                append(calendar.get(Calendar.YEAR));
        edtNgay.setText(builder);
    }
}