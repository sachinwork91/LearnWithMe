package com.example.sachin.learnwithme;

/**
 * Created by sachin on 3/26/2018.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sachin.learnwithme.data.Category;

import java.util.List;


/**
 * Created by norman on 12/26/16.
 */

public class CategoryAdapter extends ArrayAdapter<Category> {

    private Context context;
    private List<Category> values;

    public CategoryAdapter(Context context, List<Category> values) {
        super(context, R.layout.list_item_pagination, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Log.d("test", "Get view is called ..");
        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);

        Category item = values.get(position);
        String message = item.getCategoryName ();
        Log.d("test", "item => "+ message);
        textView.setText("SACHIN");

        return row;
    }
}
