package com.localyokel.yokel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.localyokel.yokel.ListItems.PackageContent;
import com.localyokel.yokel.ListItems.PackageContent.PackageItem;
import com.localyokel.yokel.PackageFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PackageItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPackageRecyclerViewAdapter extends RecyclerView.Adapter<MyPackageRecyclerViewAdapter.ViewHolder> {

    private final List<PackageItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyPackageRecyclerViewAdapter(List<PackageContent.PackageItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_package, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mDescriptionView.setText(mValues.get(position).description);
        holder.mIngredientsView.setText(mValues.get(position).ingredients);
        holder.mPriceView.setText(mValues.get(position).price);


        switch (position)
        {
            case 0:
                holder.mImageView.setImageResource(R.drawable.family_four_opt);
                break;
            case 1:
                holder.mImageView.setImageResource(R.drawable.empty_nesters_opt);
                break;
            case 2:
                holder.mImageView.setImageResource(R.drawable.date_night_opt);
                break;
            default:
                holder.mImageView.setImageResource(R.drawable.hello1);
                break;
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
        public TextView mDescriptionView;
        public TextView mIngredientsView;
        public TextView mPriceView;
        public ImageView mImageView;
        public PackageItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
            mDescriptionView = (TextView) view.findViewById(R.id.description);
            mIngredientsView = (TextView) view.findViewById(R.id.ingredients);
            mPriceView = (TextView) view.findViewById(R.id.price);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}
