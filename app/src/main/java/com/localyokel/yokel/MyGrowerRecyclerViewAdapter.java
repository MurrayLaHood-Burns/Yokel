package com.localyokel.yokel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.localyokel.yokel.GrowerFragment.OnListFragmentInteractionListener;
import com.localyokel.yokel.ListItems.GrowerContent;
import com.localyokel.yokel.ListItems.GrowerContent.GrowerItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link GrowerContent.GrowerItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyGrowerRecyclerViewAdapter extends RecyclerView.Adapter<MyGrowerRecyclerViewAdapter.ViewHolder> {

    private final List<GrowerContent.GrowerItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyGrowerRecyclerViewAdapter(List<GrowerContent.GrowerItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_grower, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mDescriptionView.setText(mValues.get(position).description);
        holder.mProduceView.setText(mValues.get(position).produces);
        holder.mLocationView.setText(mValues.get(position).location);



        switch (position)
        {
            case 0:
                holder.mImageView.setImageResource(R.drawable.cycle_farms_opt);
                break;
            case 1:
                holder.mImageView.setImageResource(R.drawable.best_day_farms_opt);
                break;
            case 2:
                holder.mImageView.setImageResource(R.drawable.liberty_farms_opt);
                break;
            default:
                holder.mImageView.setImageResource(R.drawable.farmer1);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView mNameView;
        public TextView mLocationView;
        public TextView mDescriptionView;
        public TextView mProduceView;
        public GrowerItem mItem;
        public ImageView mImageView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
            mLocationView = (TextView) view.findViewById(R.id.location);
            mDescriptionView = (TextView) view.findViewById(R.id.description);
            mProduceView = (TextView) view.findViewById(R.id.produces);
            mImageView = (ImageView) view.findViewById(R.id.imageView2);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDescriptionView.getText() + "'";
        }
    }
}
