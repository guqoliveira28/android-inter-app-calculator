package com.example.calculatorclient.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatorclient.R;
import com.example.calculatorclient.database.OperationEntity;

import java.util.List;

public class HistoryViewAdapter extends RecyclerView.Adapter<HistoryViewAdapter.ViewHolder> {
    private final List<OperationEntity> operations;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNum1;
        private final TextView textViewNum2;
        private final TextView textViewOperation;
        private final TextView textViewResult;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewNum1 = view.findViewById(R.id.textViewNum1);
            textViewNum2 = view.findViewById(R.id.textViewNum2);
            textViewOperation = view.findViewById(R.id.textViewOperation);
            textViewResult = view.findViewById(R.id.textViewResult);
        }

        public TextView getTextViewNum1() {
            return textViewNum1;
        }

        public TextView getTextViewNum2() {
            return textViewNum2;
        }

        public TextView getTextViewOperation() {
            return textViewOperation;
        }

        public TextView getTextViewResult() {
            return textViewResult;
        }
    }

    public HistoryViewAdapter(List<OperationEntity> dataSet) {
        operations = dataSet;
    }

    public void addOperation(OperationEntity operation) {
        operations.add(0, operation);
        notifyItemInserted(0);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setOperations(List<OperationEntity> operations) {
        this.operations.clear();
        this.operations.addAll(operations);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.operations_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextViewNum1().setText(String.valueOf(operations.get(position).getNumber1()));
        viewHolder.getTextViewNum2().setText(String.valueOf(operations.get(position).getNumber2()));
        viewHolder.getTextViewOperation().setText(operations.get(position).getOperation());
        viewHolder.getTextViewResult().setText(operations.get(position).getResult());
    }

    @Override
    public int getItemCount() {
        if (operations == null) {
            return 0;
        }
        return operations.size();
    }
}
