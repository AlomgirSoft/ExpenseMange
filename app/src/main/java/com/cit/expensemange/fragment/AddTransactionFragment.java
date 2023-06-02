package com.cit.expensemange.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cit.expensemange.Adapter.CategoryAdapter;
import com.cit.expensemange.Model.SimpleCategoryModel;
import com.cit.expensemange.R;
import com.cit.expensemange.databinding.FragmentAddTransactionBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddTransactionFragment extends BottomSheetDialogFragment {


    public AddTransactionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
      FragmentAddTransactionBinding binding;




    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding =FragmentAddTransactionBinding.inflate(inflater,container,false);


  binding.incomeBtn.setOnClickListener(v->{
     binding.incomeBtn.setBackground(getContext().getDrawable(R.drawable.fragment_top_textback_rount_income_select));
     binding.expenseBtn.setBackground(getContext().getDrawable(R.drawable.fragment_top_textback_rount));
     binding.incomeBtn.setTextColor(getContext().getColor(R.color.black));
     binding.expenseBtn.setTextColor(getContext().getColor(R.color.green));
  });

        binding.expenseBtn.setOnClickListener(v->{
            binding.incomeBtn.setBackground(getContext().getDrawable(R.drawable.fragment_top_textback_rount));
            binding.expenseBtn.setBackground(getContext().getDrawable(R.drawable.fragment_top_textback_rount_expanse_select));
            binding.incomeBtn.setTextColor(getContext().getColor(R.color.black));
            binding.expenseBtn.setTextColor(getContext().getColor(R.color.orange));
        });

        binding.edDateTime.setOnClickListener(v->{

            showDatePicker();
        });

        binding.edCategory.setOnClickListener(v->{

            showCategorys();

        });



        return binding.getRoot();
    }

    private void showCategorys() {










        List<SimpleCategoryModel> modelList = new ArrayList<>();

        modelList.add(new SimpleCategoryModel("salary", R.drawable.salary));
        modelList.add(new SimpleCategoryModel("Business", R.drawable.busness));
        modelList.add(new SimpleCategoryModel("Investment", R.drawable.trans));
        modelList.add(new SimpleCategoryModel("lon", R.drawable.loan));
        modelList.add(new SimpleCategoryModel("salary", R.drawable.rend));
        modelList.add(new SimpleCategoryModel("salary", R.drawable.others));


        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), modelList);

    }


    void showDatePicker(){


       DatePickerDialog datePickerDialog = new DatePickerDialog(getContext());
       datePickerDialog.setOnDateSetListener((datePicker, i, i1, i2) -> {
           Calendar calendar = Calendar.getInstance();
           calendar.set(Calendar.DAY_OF_MONTH,datePicker.getDayOfMonth());
           calendar.set(Calendar.MONTH,datePicker.getMonth());
           calendar.set(Calendar.YEAR,datePicker.getYear());

           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd  MMMM yyyy");
           String dateToShow=simpleDateFormat.format(calendar.getTime());
           binding.edDateTime.setText(dateToShow);
       });
       datePickerDialog.show();
   }






    private void showCustomDialog(String item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.simple_categroy_list, null);
        builder.setView(dialogView);



        // Create and show the custom dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}