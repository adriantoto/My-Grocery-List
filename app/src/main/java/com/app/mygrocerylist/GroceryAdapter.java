package com.app.mygrocerylist;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// For displaying the entries

//<GroceryAdapter.GroceryViewHolder>
public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {

    // Declare context and cursor variables
    private Context mContext;
    private Cursor mCursor;

    // Assign the variables
    public GroceryAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder {

        // Declare item's variables
        public TextView nameText;
        public TextView countText;

        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);
            // Assign the variables
            nameText = itemView.findViewById(R.id.textview_name_item);
            countText = itemView.findViewById(R.id.textview_amount_item);
        }
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Declare the inflater
        LayoutInflater inflater = LayoutInflater.from(mContext);
        // Put what to inflate
        View view = inflater.inflate(R.layout.grocery_item, viewGroup, false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder groceryViewHolder, int i) {
        // If the cursor cannot move to the position
        if (!mCursor.moveToPosition(i)) {
            return;
        }
        // Get the name and amount at the current cursor's position
        String name = mCursor.getString(mCursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_NAME));
        int amount = mCursor.getInt(mCursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_AMOUNT));
        // Read the ID
        long id = mCursor.getLong(mCursor.getColumnIndex(GroceryContract.GroceryEntry._ID));
        // Pass the values to item's layout
        groceryViewHolder.nameText.setText(name);
        groceryViewHolder.countText.setText(String.valueOf(amount));
        // Pass the ID to the main activity
        groceryViewHolder.itemView.setTag(id);
        // Selectable text
        groceryViewHolder.nameText.setTextIsSelectable(true);
        groceryViewHolder.countText.setTextIsSelectable(true);
    }

    @Override
    public int getItemCount() {
        // Get all the positions
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        // Get rid of the existing cursor
        if (mCursor != null) {
            mCursor.close();
        }
        // Declare the new cursor
        mCursor = newCursor;
        // If new cursor exist, change the cursor
        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}