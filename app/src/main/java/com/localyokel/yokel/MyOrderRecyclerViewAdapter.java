package com.localyokel.yokel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localyokel.yokel.ListItems.OrderContent;
import com.localyokel.yokel.ListItems.OrderContent.OrderItem;
import com.localyokel.yokel.OrderFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link OrderItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyOrderRecyclerViewAdapter extends RecyclerView.Adapter<MyOrderRecyclerViewAdapter.ViewHolder> {

    private final List<OrderItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyOrderRecyclerViewAdapter(List<OrderContent.OrderItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mPackageName.setText(mValues.get(position).packageName);
        holder.mDeliveryDate.setText(mValues.get(position).deliveryDate);
        holder.mPrice.setText(mValues.get(position).price);
        holder.mSummary.setText(mValues.get(position).summary);

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
        public TextView mPackageName;
        public TextView mSummary;
        public TextView mDeliveryDate;
        public TextView mPrice;
        public OrderItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPackageName = (TextView) view.findViewById(R.id.package_name);
            mSummary = (TextView) view.findViewById(R.id.description);
            mDeliveryDate = (TextView) view.findViewById(R.id.delivery_date);
            mPrice = (TextView) view.findViewById(R.id.price);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mSummary.getText() + "'";
        }
    }
}
